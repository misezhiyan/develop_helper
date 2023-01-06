package com.kimmy.learn.web.util;

import java.io.*;

public class PathUtils {

    static final String PATH_SPLITER = "/";
    static final String PATH_SPLITER_WIN = "\\";

    public static String combinePath(String... paths) {

        String fullPath = "";
        for (int i = 0; i < paths.length; i++)
            if (i == 0)
                fullPath = formmateSpliter(paths[i]);
            else
                fullPath = combineOnePathSpliter(fullPath, formmateSpliter(paths[i]));

        return fullPath;
    }

    private static String combineOnePathSpliter(String pre, String suf) {

        while (pre.contains(PATH_SPLITER + PATH_SPLITER)) {
            pre = pre.replace(PATH_SPLITER + PATH_SPLITER, PATH_SPLITER);
        }
        while (suf.contains(PATH_SPLITER + PATH_SPLITER)) {
            suf = pre.replace(PATH_SPLITER + PATH_SPLITER, PATH_SPLITER);
        }

        if (!pre.endsWith(PATH_SPLITER) && !suf.startsWith(PATH_SPLITER)) {
            return pre + PATH_SPLITER + suf;
        }

        if (pre.endsWith(PATH_SPLITER) && suf.startsWith(PATH_SPLITER)) {
            return pre + suf.substring(1);
        }

        return pre + suf;
    }

    private static String formmateSpliter(String path) {
        if (StringUtils.isEmpty(path)) {
            return "";
        }
        return path.replace(PATH_SPLITER_WIN, PATH_SPLITER);
    }

    public static String toPointPath(String path) {
        return formmateSpliter(path).replace(PATH_SPLITER, FileUtils.POINT);
    }
}
