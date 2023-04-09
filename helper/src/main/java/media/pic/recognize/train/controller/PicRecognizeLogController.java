package media.pic.recognize.train.controller;

import com.alibaba.fastjson.JSON;
import media.pic.recognize.train.controller.domain.response.LogListResponse;
import media.pic.recognize.train.entity.PicRecognizeLog;
import media.pic.recognize.train.service.PicRecognizeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping("list")
    public LogListResponse list(@RequestBody String body) {
        List<PicRecognizeLog> list = picRecognizeLogService.list();
        return LogListResponse.success(list);
    }

}
