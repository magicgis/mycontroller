/*
 * Copyright 2015-2017 Jeeva Kandasamy (jkandasa@gmail.com)
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mycontroller.standalone.api.jaxrs.model;

import org.mycontroller.standalone.db.tables.MetricsBatteryUsage;
import org.mycontroller.standalone.db.tables.MetricsDoubleTypeDevice;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Jeeva Kandasamy (jkandasa)
 * @since 0.0.3
 */

@Getter
@ToString
@Builder
public class DataPointDouble extends DataPointBase {
    private Double min;
    private Double max;
    private Double avg;
    private Integer samples;

    public static DataPointDouble get(MetricsDoubleTypeDevice metric, Long start, Long end) {
        if (metric == null) {
            DataPointDouble dataPoint = DataPointDouble.builder().build();
            dataPoint.setStart(start);
            dataPoint.setEnd(end);
            dataPoint.setEmpty(true);
            return dataPoint;
        }
        DataPointDouble dataPoint = DataPointDouble.builder()
                .min(metric.getMin())
                .max(metric.getMax())
                .avg(metric.getAvg())
                .samples(metric.getSamples()).build();
        dataPoint.setEmpty(false);
        if (start != null) {
            dataPoint.setStart(start);
            dataPoint.setEnd(end);
        } else {
            dataPoint.setTimestamp(metric.getTimestamp());
        }
        return dataPoint;
    }

    public static DataPointDouble get(MetricsBatteryUsage metric, Long start, Long end) {
        if (metric == null) {
            DataPointDouble dataPoint = DataPointDouble.builder().build();
            dataPoint.setStart(start);
            dataPoint.setEnd(end);
            dataPoint.setEmpty(true);
            return dataPoint;
        }
        DataPointDouble dataPoint = DataPointDouble.builder()
                .min(metric.getMin())
                .max(metric.getMax())
                .avg(metric.getAvg())
                .samples(metric.getSamples()).build();
        dataPoint.setEmpty(false);
        if (start != null) {
            dataPoint.setStart(start);
            dataPoint.setEnd(end);
        } else {
            dataPoint.setTimestamp(metric.getTimestamp());
        }
        return dataPoint;
    }
}
