package util;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @discription 路径工具
 * @author kimmy
 * @date 2018年9月30日 上午9:33:39
 */
public class PathUtil {

    public static final String PATH_WIN_SPLIT = "\\";
    public static final String PATH_LINE_SPLIT = "/";
    public static final String PATH_POINT_SPLIT = ".";

    /**
     * @description: 文件地址拼接
     * @author: liyq
     * @createtime: 2023-04-06 14:34:29
     * @param: s
     * @param: entityFullDir
     * @return boolean
     */
    public static String filePath(String fileName, String... pathArr) {

        return combineLinePath(pathArr) + PATH_LINE_SPLIT + fileName;
    }

    // 拼接路径
    public static String combineLinePath(String... pathArr) {

        return Arrays.stream(pathArr).map(path -> {
            path = matchLinePath(path);
            while (path.startsWith(PATH_LINE_SPLIT)) {
                path = path.substring(1);
            }
            while (path.endsWith(PATH_LINE_SPLIT)) {
                path = path.substring(0, path.length() - 1);
            }
            return path;
        }).collect(Collectors.joining(PATH_LINE_SPLIT));
    }

    // 无头无尾反斜杠路径
    public static String matchLinePath(String path) {

        path = path.replace(PATH_POINT_SPLIT, PATH_LINE_SPLIT);
        path = path.replace(PATH_WIN_SPLIT, PATH_LINE_SPLIT);

        while (path.startsWith(PATH_LINE_SPLIT))
            path = path.substring(1);
        while (path.endsWith(PATH_LINE_SPLIT))
            path = path.substring(0, path.length() - 1);
        while (path.contains(doubleLinePath()))
            path = path.replace(doubleLinePath(), PATH_LINE_SPLIT);

        return path;
    }

    private static CharSequence doubleLinePath() {
        return PATH_LINE_SPLIT + PATH_LINE_SPLIT;
    }

    // 无头无尾点路径
    public static String pointPath(String path) {

        path = path.replace("\\", PATH_LINE_SPLIT);
        while (path.startsWith(PATH_LINE_SPLIT))
            path = path.substring(1);
        while (path.endsWith(PATH_LINE_SPLIT))
            path = path.substring(0, path.length() - 1);
        while (path.contains("//"))
            path = path.replace("//", PATH_LINE_SPLIT);

        path = path.replace(PATH_LINE_SPLIT, PATH_POINT_SPLIT);

        return path;
    }

}
