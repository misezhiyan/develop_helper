package media.pic.recognize.train.controller;

import media.pic.recognize.train.controller.domain.request.*;
import media.pic.recognize.train.controller.domain.response.*;
import media.pic.recognize.train.entity.PicRecognizeLog;
import media.pic.recognize.train.service.PicRecognizeFeatureService;
import media.pic.recognize.train.service.PicRecognizeLogService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @discription 图片识别记录
 * @author kimmy
 * @date ${date}
 */
@RequestMapping("/picrecognizefeature")
@RestController
public class PicRecognizeFeatureController {

    @Autowired
    PicRecognizeFeatureService picRecognizeFeatureService;

    /**
     * @description: 识别
     * @author: liyq
     * @createtime: 2023-04-11 09:39:09
     * @param: file
     * @param: request
     * @return RecognizeResponse
     */
    @RequestMapping("unmatchFeatureList")
    public FeatureListResponse unmatchFeatureList(@RequestBody FeatureListRequest request) {
        return picRecognizeFeatureService.unmatchFeatureList(request);
    }

    /**
     * @description: 特征点转为图片查看
     * @author: liyq
     * @createtime: 2023-04-12 11:28:13
     * @param: feature
     * @param: featureSize
     * @param: response
     */
    @RequestMapping("featureToPic")
    public void featureToPic(@Param("feature") String feature, @Param("featureSize") Integer featureSize, HttpServletResponse response) {
        picRecognizeFeatureService.featureToPic(feature, featureSize, response);
    }

    /**
     * @description: 特征点匹配文字
     * @author: liyq
     * @createtime: 2023-04-12 09:20:24
     * @param: request
     * @return FeatureMatchResponse
     */
    @RequestMapping("matchFeature")
    public FeatureMatchResponse matchFeature(@RequestBody FeatureMatchRequest request) {
        return picRecognizeFeatureService.matchFeature(request);
    }

    /**
     * @description: 删除识别错误记录
     * @author: liyq
     * @createtime: 2023-04-12 11:36:26
     * @param: request
     * @return FeatureMatchResponse
     */
    @RequestMapping("delLog")
    public FeatureLogDelResponse delLog(@RequestBody FeatureLogDelRequest request) {
        return picRecognizeFeatureService.delLog(request);
    }
}
