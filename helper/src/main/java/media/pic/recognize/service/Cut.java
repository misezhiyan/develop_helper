package media.pic.recognize.service;

/**
 * @description: 图片切割
 * @author: liyq
 * @createtime: 2023-03-30 13:11:29
 */
public interface Cut {

    /**
     * @description:
     * @author: liyq
     * @createtime: 2023-03-31 17:00:55
     * @param: square
     * @return int[][]
     */
    int[][] cut(int[][] square);
}
