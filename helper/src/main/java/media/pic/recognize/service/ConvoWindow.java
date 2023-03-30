package media.pic.recognize.service;

import media.pic.recognize.service.impl.convolution.entity.ConvoWindowEntity;

/**
 * @description: 卷积窗口
 * @author: liyq
 * @createtime: 2023-03-28 19:10:45
 */
public interface ConvoWindow {

    ConvoWindowEntity convoWindow(int windowRadius);
}
