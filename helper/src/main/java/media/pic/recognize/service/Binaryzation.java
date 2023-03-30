package media.pic.recognize.service;


/**
 * @description: 二值化
 * @author: liyq
 * @createtime: 2023-03-28 19:10:45
 */
public interface Binaryzation {
    int[][] binaryzation(int[][] square, int threshold);
}
