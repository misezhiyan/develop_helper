package media.pic.recognize.train.controller;

import media.pic.recognize.train.service.PicRecognizeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @discription 图片识别记录
 * @author kimmy
 * @date ${date}
 */
@RequestMapping("/picrecognizelog")
@RestController
public class PicRecognizeLogController {

    @Autowired
    PicRecognizeLogService picRecognizeLogService;

}
