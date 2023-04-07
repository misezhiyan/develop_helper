package media.pic.recognize.train.service.impl;

import media.pic.recognize.train.mapper.PicRecognizeLogMapper;
import media.pic.recognize.train.service.PicRecognizeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @discription 图片识别记录
 * @author kimmy
 * @date ${date}
 */
@Service
public class PicRecognizeLogServiceImpl implements PicRecognizeLogService {

    @Autowired
    PicRecognizeLogMapper picRecognizeLogMapper;

}
