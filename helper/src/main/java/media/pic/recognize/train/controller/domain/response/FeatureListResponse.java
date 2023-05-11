package media.pic.recognize.train.controller.domain.response;

import media.pic.recognize.train.controller.domain.BaseResponse;
import media.pic.recognize.train.controller.domain.dto.FeatureLogDto;
import media.pic.recognize.train.enums.ResMsg;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeatureListResponse extends BaseResponse {

    private List<FeatureLogDto> list;

    public List<FeatureLogDto> getList() {
        return list;
    }

    public void setList(List<FeatureLogDto> list) {
        this.list = list;
    }

    public static FeatureListResponse success(List<FeatureLogDto> list) {
        FeatureListResponse response = response(ResMsg.SUCCESS);
        response.setList(list);
        return response;
    }

    public static FeatureListResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static FeatureListResponse response(ResMsg resMsg) {
        FeatureListResponse response = new FeatureListResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
