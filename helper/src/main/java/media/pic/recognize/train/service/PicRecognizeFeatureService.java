package media.pic.recognize.train.service;

import media.pic.recognize.train.controller.domain.request.FeatureListRequest;
import media.pic.recognize.train.controller.domain.request.FeatureLogDelRequest;
import media.pic.recognize.train.controller.domain.request.FeatureMatchRequest;
import media.pic.recognize.train.controller.domain.request.FeatureToPicRequest;
import media.pic.recognize.train.controller.domain.response.*;
import media.pic.recognize.train.entity.PicRecognizeLog;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @discription 特征点训练
 * @author kimmy
 * @date ${date}
 */
public interface PicRecognizeFeatureService {

    FeatureListResponse unmatchFeatureList(FeatureListRequest request);

    FeatureMatchResponse matchFeature(FeatureMatchRequest request);

    void featureToPic(String feature, Integer featureSize, HttpServletResponse response);

    FeatureLogDelResponse delLog(FeatureLogDelRequest request);
}
