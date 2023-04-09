package media.pic.recognize.train.service;

import media.pic.recognize.train.entity.PicRecognizeLog;

import java.util.List;

/**
 * @discription 图片识别记录
 * @author kimmy
 * @date ${date}
 */
public interface PicRecognizeLogService {

    List<PicRecognizeLog> list();
}
