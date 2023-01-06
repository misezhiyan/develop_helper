package com.kimmy.learn.web.controller.domain.request.generate;

import org.springframework.stereotype.Component;

@Component
public class GeneratePolicyDelDetailRequest  {

    private Integer policyId;
    private Integer policyDetailId;

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public Integer getPolicyDetailId() {
        return policyDetailId;
    }

    public void setPolicyDetailId(Integer policyDetailId) {
        this.policyDetailId = policyDetailId;
    }
}
