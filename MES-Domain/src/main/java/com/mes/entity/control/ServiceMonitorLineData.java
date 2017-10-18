package com.mes.entity.control;

import java.util.List;

/**
 * Created by xiuyou.xu on 2017/8/22.
 */
public class ServiceMonitorLineData {
    private LineData yearLine;
    private LineData monthLine;

    public LineData getYearLine() {
        return yearLine;
    }

    public void setYearLine(LineData yearLine) {
        this.yearLine = yearLine;
    }

    public LineData getMonthLine() {
        return monthLine;
    }

    public void setMonthLine(LineData monthLine) {
        this.monthLine = monthLine;
    }

    public static class LineData {
        private List<String> labels;
        private List<Long> successes;
        private List<Long> fails;

        public List<String> getLabels() {
            return labels;
        }

        public void setLabels(List<String> labels) {
            this.labels = labels;
        }

        public List<Long> getSuccesses() {
            return successes;
        }

        public void setSuccesses(List<Long> successes) {
            this.successes = successes;
        }

        public List<Long> getFails() {
            return fails;
        }

        public void setFails(List<Long> fails) {
            this.fails = fails;
        }
    }
}
