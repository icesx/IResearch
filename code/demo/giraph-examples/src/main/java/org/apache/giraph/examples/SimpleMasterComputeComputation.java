/*
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

package org.apache.giraph.examples;

import java.io.IOException;

import org.apache.giraph.aggregators.DoubleOverwriteAggregator;
import org.apache.giraph.graph.BasicComputation;
import org.apache.giraph.graph.Vertex;
import org.apache.giraph.master.DefaultMasterCompute;
import org.apache.giraph.worker.WorkerContext;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.log4j.Logger;

/**
 * Demonstrates a computation with a centralized part implemented via a
 * MasterCompute.
 */
public class SimpleMasterComputeComputation extends BasicComputation<
    LongWritable, DoubleWritable, FloatWritable, DoubleWritable> {
  /** Aggregator to get values from the master to the workers */
  public static final String SMC_AGG = "simplemastercompute.aggregator";
  /** Logger */
  private static final Logger LOG =
      Logger.getLogger(SimpleMasterComputeComputation.class);

  @Override
  public void compute(
      Vertex<LongWritable, DoubleWritable, FloatWritable> vertex,
      Iterable<DoubleWritable> messages) throws IOException {
    double oldSum = getSuperstep() == 0 ? 0 : vertex.getValue().get();
    double newValue = this.<DoubleWritable>getAggregatedValue(SMC_AGG).get();
    double newSum = oldSum + newValue;
    vertex.setValue(new DoubleWritable(newSum));
    SimpleMasterComputeWorkerContext workerContext = getWorkerContext();
    workerContext.setFinalSum(newSum);
    LOG.info("Current sum: " + newSum);
  }

  /**
   * Worker context used with {@link SimpleMasterComputeComputation}.
   */
  public static class SimpleMasterComputeWorkerContext
      extends WorkerContext {
    /** Final sum value for verification for local jobs */
    private static double FINAL_SUM;

    @Override
    public void preApplication()
      throws InstantiationException, IllegalAccessException {
    }

    @Override
    public void preSuperstep() {
    }

    @Override
    public void postSuperstep() {
    }

    @Override
    public void postApplication() {
    }

    public static void setFinalSum(double sum) {
      FINAL_SUM = sum;
    }

    public static double getFinalSum() {
      return FINAL_SUM;
    }
  }

  /**
   * MasterCompute used with {@link SimpleMasterComputeComputation}.
   */
  public static class SimpleMasterCompute
      extends DefaultMasterCompute {
    @Override
    public void compute() {
      setAggregatedValue(SMC_AGG,
          new DoubleWritable(((double) getSuperstep()) / 2 + 1));
      if (getSuperstep() == 10) {
        haltComputation();
      }
    }

    @Override
    public void initialize() throws InstantiationException,
        IllegalAccessException {
      registerAggregator(SMC_AGG, DoubleOverwriteAggregator.class);
    }
  }
}
