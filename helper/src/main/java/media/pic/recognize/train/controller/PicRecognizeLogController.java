package media.pic.recognize.train.controller;

import media.pic.recognize.train.controller.domain.request.LogDelRequest;
import media.pic.recognize.train.controller.domain.response.LogDelResponse;
import media.pic.recognize.train.controller.domain.response.LogListResponse;
import media.pic.recognize.train.controller.domain.response.RecognizeResponse;
import media.pic.recognize.train.entity.PicRecognizeLog;
import media.pic.recognize.train.service.PicRecognizeLogService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * @description: 识别
     * @author: liyq
     * @createtime: 2023-04-11 09:39:09
     * @param: file
     * @param: request
     * @return RecognizeResponse
     */
    @RequestMapping("recognize")
    public RecognizeResponse recognize(@Param("file") MultipartFile file, HttpServletRequest request) {
        return picRecognizeLogService.recognize(file);
    }

    @RequestMapping("listLog")
    public LogListResponse listLog(@RequestBody String body) {
        List<PicRecognizeLog> list = picRecognizeLogService.list();
        return LogListResponse.success(list);
    }

    @RequestMapping("delLog")
    public LogDelResponse delLog(@RequestBody LogDelRequest request) {
        return picRecognizeLogService.delLog(request.getId());
    }


}
