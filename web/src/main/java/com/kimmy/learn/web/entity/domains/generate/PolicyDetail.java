package com.kimmy.learn.web.entity.domains.generate;

import com.kimmy.learn.web.entity.db.GeneratePolicy;
import com.kimmy.learn.web.entity.db.GeneratePolicyDetail;

import java.util.List;

public class PolicyDetail extends GeneratePolicy {

    private List<GeneratePolicyDetail> detailList;

    public List<GeneratePolicyDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<GeneratePolicyDetail> detailList) {
        this.detailList = detailList;
    }
}
