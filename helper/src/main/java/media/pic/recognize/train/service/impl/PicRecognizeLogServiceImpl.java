package media.pic.recognize.train.service.impl;

import media.pic.recognize.train.entity.PicRecognizeLog;
import media.pic.recognize.train.mapper.PicRecognizeLogMapper;
import media.pic.recognize.train.service.PicRecognizeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @discription 图片识别记录
 * @author kimmy
 * @date ${date}
 */
@Service
public class PicRecognizeLogServiceImpl implements PicRecognizeLogService {

    @Autowired
    PicRecognizeLogMapper picRecognizeLogMapper;

    @Override
    public List<PicRecognizeLog> list() {
        List<PicRecognizeLog> list = picRecognizeLogMapper.list(null);
        return list;
    }
}
