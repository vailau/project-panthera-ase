/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.ql.udf.generic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDFArgumentTypeException;
import org.apache.hadoop.hive.ql.exec.WindowFunctionDescription;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils.ObjectInspectorCopyOption;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;

@WindowFunctionDescription(description = @Description(name = "last_value", value = "_FUNC_(x)"), supportsWindow = true, pivotResult = false, impliesOrder = true)
public class GenericUDAFLastValue extends AbstractGenericUDAFResolver
{
	static final Log LOG = LogFactory.getLog(GenericUDAFLastValue.class
			.getName());

	@Override
	public GenericUDAFEvaluator getEvaluator(TypeInfo[] parameters)
			throws SemanticException
	{
		if (parameters.length > 2)
		{
			throw new UDFArgumentTypeException(2, "At most 2 arguments expected");
		}
		if ( parameters.length > 1 && !parameters[1].equals(TypeInfoFactory.booleanTypeInfo) )
		{
			throw new UDFArgumentTypeException(1, "second argument must be a boolean expression");
		}
		return createEvaluator();
	}

	protected GenericUDAFLastValueEvaluator createEvaluator()
	{
		return new GenericUDAFLastValueEvaluator();
	}

	static class LastValueBuffer implements AggregationBuffer
	{
		Object val;
		boolean firstRow;
		boolean skipNulls;

		LastValueBuffer()
		{
			init();
		}

		void init()
		{
			val = null;
			firstRow = true;
			skipNulls = false;
		}

	}

	public static class GenericUDAFLastValueEvaluator extends
			GenericUDAFEvaluator
	{
		ObjectInspector inputOI;
		ObjectInspector outputOI;

		@Override
		public ObjectInspector init(Mode m, ObjectInspector[] parameters)
				throws HiveException
		{
			super.init(m, parameters);
			if (m != Mode.COMPLETE)
			{
				throw new HiveException(
						"Only COMPLETE mode supported for Rank function");
			}
			inputOI = parameters[0];
			outputOI = ObjectInspectorUtils.getStandardObjectInspector(inputOI,
					ObjectInspectorCopyOption.WRITABLE);
			return outputOI;
		}

		@Override
		public AggregationBuffer getNewAggregationBuffer() throws HiveException
		{
			return new LastValueBuffer();
		}

		@Override
		public void reset(AggregationBuffer agg) throws HiveException
		{
			((LastValueBuffer) agg).init();
		}

		@Override
		public void iterate(AggregationBuffer agg, Object[] parameters)
				throws HiveException
		{
			LastValueBuffer lb = (LastValueBuffer) agg;
			if (lb.firstRow )
			{
				lb.firstRow = false;
				if ( parameters.length == 2  )
				{
					lb.skipNulls = PrimitiveObjectInspectorUtils.getBoolean(
							parameters[1],
							PrimitiveObjectInspectorFactory.writableBooleanObjectInspector);
				}
			}

			if ( !lb.skipNulls || lb.val != null )
			{
				lb.val = parameters[0];
			}
		}

		@Override
		public Object terminatePartial(AggregationBuffer agg)
				throws HiveException
		{
			throw new HiveException("terminatePartial not supported");
		}

		@Override
		public void merge(AggregationBuffer agg, Object partial)
				throws HiveException
		{
			throw new HiveException("merge not supported");
		}

		@Override
		public Object terminate(AggregationBuffer agg) throws HiveException
		{
			LastValueBuffer lb = (LastValueBuffer) agg;
			return ObjectInspectorUtils.copyToStandardObject(lb.val, inputOI,
					ObjectInspectorCopyOption.WRITABLE);

		}
	}

}

