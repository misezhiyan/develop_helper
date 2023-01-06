package com.kimmy.learn.web.controller.domain.request.generate;

import com.kimmy.learn.web.entity.db.GeneratePolicyDetail;
import org.springframework.stereotype.Component;

@Component
public class GeneratePolicyUpdDetailRequest extends GeneratePolicyDetail {

    private Integer policyDetailId;

    public Integer getPolicyDetailId() {
        return policyDetailId;
    }

    public void setPolicyDetailId(Integer policyDetailId) {
        this.policyDetailId = policyDetailId;
    }
}
