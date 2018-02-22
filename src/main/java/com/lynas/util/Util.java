package com.lynas.util;

import java.text.DecimalFormat;

public class Util {
    public Double formateRatingAvg(double value) {
        DecimalFormat df = new DecimalFormat("#.#");
        String stringValue = df.format(value);
        return Double.valueOf(stringValue);
    }
}
