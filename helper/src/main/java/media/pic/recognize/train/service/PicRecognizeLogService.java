package media.pic.recognize.train.service;

import media.pic.recognize.train.controller.domain.response.LogDelResponse;
import media.pic.recognize.train.controller.domain.response.RecognizeResponse;
import media.pic.recognize.train.entity.PicRecognizeLog;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @discription 图片识别记录
 * @author kimmy
 * @date ${date}
 */
public interface PicRecognizeLogService {

    List<PicRecognizeLog> list();

    RecognizeResponse recognize(MultipartFile file);

    LogDelResponse delLog(Integer id);
}
