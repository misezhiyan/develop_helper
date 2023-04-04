package media.pic.recognize.service;

/**
 * @description: 图片缩放
 * @author: liyq
 * @createtime: 2023-03-30 13:11:29
 */
public interface Zoom {

    /**
     * @description: 图片缩放
     * @author: liyq
     * @createtime: 2023-04-03 13:13:16
     * @param: cutSquare
     * @return int[][]
     */
    int[][] zoom(int[][] square);
}
