package com.kimmy.learn.web.controller.domain.response.generate;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.entity.db.GeneratePolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneratePolicyListResponse extends BaseResponse {

    private List<GeneratePolicy> generatePolicyList;

    public List<GeneratePolicy> getGeneratePolicyList() {
        return generatePolicyList;
    }

    public void setGeneratePolicyList(List<GeneratePolicy> generatePolicyList) {
        this.generatePolicyList = generatePolicyList;
    }

    public static GeneratePolicyListResponse success(List<GeneratePolicy> generatePolicyList) {
        GeneratePolicyListResponse response = new GeneratePolicyListResponse();
        response.setGeneratePolicyList(generatePolicyList);
        return response;
    }
}
