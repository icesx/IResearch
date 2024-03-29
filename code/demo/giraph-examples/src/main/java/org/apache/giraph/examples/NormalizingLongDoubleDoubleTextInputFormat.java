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
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.giraph.conf.ImmutableClassesGiraphConfigurable;
import org.apache.giraph.conf.ImmutableClassesGiraphConfiguration;
import org.apache.giraph.edge.Edge;
import org.apache.giraph.edge.EdgeFactory;
import org.apache.giraph.graph.Vertex;
import org.apache.giraph.io.formats.TextVertexInputFormat;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import com.google.common.collect.Lists;

/**
 * Simple text-based {@link org.apache.giraph.io.VertexInputFormat} for
 * unweighted graphs with long ids. Each line consists of: vertex
 * neighbor1:weight1 neighbor2:weight2 ...
 */
public class NormalizingLongDoubleDoubleTextInputFormat
    extends
    TextVertexInputFormat<LongWritable, DoubleWritable, DoubleWritable>
    implements ImmutableClassesGiraphConfigurable<LongWritable, DoubleWritable,
    DoubleWritable> {
  /** Configuration. */
  private ImmutableClassesGiraphConfiguration<LongWritable, DoubleWritable,
      DoubleWritable> conf;

  @Override
  public TextVertexReader createVertexReader(
      InputSplit split, TaskAttemptContext context) throws IOException {
    return new NormalizingLongDoubleDoubleDoubleVertexReader();
  }

  @Override
  public void setConf(ImmutableClassesGiraphConfiguration<LongWritable,
      DoubleWritable, DoubleWritable> configuration) {
    conf = configuration;
  }

  @Override
  public ImmutableClassesGiraphConfiguration<LongWritable, DoubleWritable,
      DoubleWritable> getConf() {
    return conf;
  }

  /**
   * Vertex reader associated with
   * {@link LongDoubleDoubleTextInputFormat}.
   */
  public class NormalizingLongDoubleDoubleDoubleVertexReader
      extends NormalizingLongDoubleDoubleTextInputFormat.TextVertexReader {
    /** Separator of the vertex and neighbors */
    private final Pattern edgeSeparator = Pattern.compile("\\s+");
    /** Separator of the edge id and edge weight */
    private final Pattern weightSeparator = Pattern.compile(":");

    @Override
    public Vertex<LongWritable, DoubleWritable, DoubleWritable>
    getCurrentVertex() throws IOException, InterruptedException {
      Vertex<LongWritable, DoubleWritable, DoubleWritable> vertex =
          conf.createVertex();

      String[] tokens = edgeSeparator.split(getRecordReader()
          .getCurrentValue().toString());
      List<Edge<LongWritable, DoubleWritable>> edges = Lists
          .newArrayListWithCapacity(tokens.length - 1);
      parse(tokens, edges);
      normalize(edges);

      LongWritable vertexId = new LongWritable(Long.parseLong(tokens[0]));
      vertex.initialize(vertexId, new DoubleWritable(), edges);

      return vertex;
    }

    /**
     * Parse a set of tokens into a map ID -> weight.
     * @param tokens The tokens to be parsed.
     * @param edges The map that will contain the result of the parsing.
     */
    void parse(String[] tokens,
               Collection<Edge<LongWritable, DoubleWritable>> edges) {
      for (int n = 1; n < tokens.length; n++) {
        String[] parts = weightSeparator.split(tokens[n]);
        edges.add(EdgeFactory.create(new LongWritable(Long.parseLong(parts[0])),
            new DoubleWritable(Double.parseDouble(parts[1]))));
      }
    }

    /**
     * Normalize the edges with L1 normalization.
     * @param edges The edges to be normalized.
     */
    void normalize(Collection<Edge<LongWritable, DoubleWritable>> edges) {
      if (edges == null || edges.size() == 0) {
        throw new IllegalArgumentException(
            "Cannot normalize an empy set of edges");
      }
      float normalizer = 0.0f;
      for (Edge<LongWritable, DoubleWritable> edge : edges) {
        normalizer += edge.getValue().get();
      }
      for (Edge<LongWritable, DoubleWritable> edge : edges) {
        edge.getValue().set(edge.getValue().get() / normalizer);
      }
    }

    @Override
    public boolean nextVertex() throws IOException, InterruptedException {
      return getRecordReader().nextKeyValue();
    }
  }
}
