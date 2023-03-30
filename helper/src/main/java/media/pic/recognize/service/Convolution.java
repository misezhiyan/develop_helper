package media.pic.recognize.service;

import media.pic.recognize.service.impl.convolution.entity.ConvoWindowEntity;

/**
 * @description: 卷积计算
 * @author: liyq
 * @createtime: 2023-03-28 20:21
 */
public interface Convolution {

    int[][] convolution(int[][] src, ConvoWindowEntity convoWindowEntity);
}
