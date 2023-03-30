package media.pic.recognize.service;

/**
 * @description: 去噪
 * @author: liyq
 * @createtime: 2023-03-28 19:03:43
 */
public interface RemoveNoise {
    int[][] removeNoise(int[][] square);
}
