package com.kimmy.learn.web.util;

public class IdUtils {

    public static String combineSeriaNo(String prefix, int seriaNo, int seriaNoLength) {
        return prefix + fillLength(seriaNo, seriaNoLength);
    }

    private static String fillLength(Integer seriaNo, int seriaNoLength) {

        String seriaNoStr = String.valueOf(seriaNo);
        while (seriaNoStr.length() < seriaNoLength) {
            seriaNoStr = "0" + seriaNoStr;
        }
        return seriaNoStr;
    }
}
