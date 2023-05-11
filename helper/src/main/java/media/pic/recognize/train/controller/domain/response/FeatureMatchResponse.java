package media.pic.recognize.train.controller.domain.response;

import media.pic.recognize.train.controller.domain.BaseResponse;
import media.pic.recognize.train.entity.PicRecognizeFeatureLog;
import media.pic.recognize.train.enums.ResMsg;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeatureMatchResponse extends BaseResponse {

    public static FeatureMatchResponse success() {
        FeatureMatchResponse response = response(ResMsg.SUCCESS);
        return response;
    }

    public static FeatureMatchResponse fail(String msg) {
        FeatureMatchResponse response = response(ResMsg.FAIL);
        response.setResMsg(msg);
        return response;
    }

    public static FeatureMatchResponse response(ResMsg resMsg) {
        FeatureMatchResponse response = new FeatureMatchResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
