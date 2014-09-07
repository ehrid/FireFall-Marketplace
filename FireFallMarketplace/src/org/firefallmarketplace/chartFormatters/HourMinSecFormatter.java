package org.firefallmarketplace.chartFormatters;

import java.util.Date;

import com.jjoe64.graphview.CustomLabelFormatter;

public class HourMinSecFormatter implements CustomLabelFormatter {
    @Override
    public String formatLabel(double value, boolean isValueX) {
        if (isValueX) {
            Date time = new Date((long) value);
            return time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds();
        }
        return null; // let graphview generate Y-axis label for us
    }
}