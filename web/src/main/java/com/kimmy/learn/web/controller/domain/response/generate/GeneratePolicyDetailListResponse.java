package com.kimmy.learn.web.controller.domain.response.generate;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.entity.db.GeneratePolicy;
import com.kimmy.learn.web.entity.db.GeneratePolicyDetail;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneratePolicyDetailListResponse extends BaseResponse {

    private List<GeneratePolicyDetail> generatePolicyDetailList;

    public List<GeneratePolicyDetail> getGeneratePolicyDetailList() {
        return generatePolicyDetailList;
    }

    public void setGeneratePolicyDetailList(List<GeneratePolicyDetail> generatePolicyDetailList) {
        this.generatePolicyDetailList = generatePolicyDetailList;
    }

    public static GeneratePolicyDetailListResponse success(List<GeneratePolicyDetail> generatePolicyDetailList) {
        GeneratePolicyDetailListResponse response = new GeneratePolicyDetailListResponse();
        response.setGeneratePolicyDetailList(generatePolicyDetailList);
        return response;
    }
}
