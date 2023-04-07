package media.pic.recognize.train.controller;

import media.pic.recognize.train.service.PicRecognizeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author: liyq
 * @createtime: 2023-04-07 17:27
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    PicRecognizeLogService picRecognizeLogService;

    @RequestMapping("/test")
    public String test(){

        return 123+"";
    }

}
