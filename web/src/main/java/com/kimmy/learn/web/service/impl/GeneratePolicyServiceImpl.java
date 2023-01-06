package com.kimmy.learn.web.service.impl;

import com.kimmy.learn.web.controller.domain.request.generate.*;
import com.kimmy.learn.web.controller.domain.request.project.ProjectAddRequest;
import com.kimmy.learn.web.controller.domain.request.project.ProjectDelRequest;
import com.kimmy.learn.web.controller.domain.request.project.ProjectListRequest;
import com.kimmy.learn.web.controller.domain.request.project.ProjectUpdateRequest;
import com.kimmy.learn.web.controller.domain.response.generate.*;
import com.kimmy.learn.web.controller.domain.response.project.ProjectAddResponse;
import com.kimmy.learn.web.controller.domain.response.project.ProjectDelResponse;
import com.kimmy.learn.web.controller.domain.response.project.ProjectListResponse;
import com.kimmy.learn.web.controller.domain.response.project.ProjectUpdateResponse;
import com.kimmy.learn.web.entity.db.GeneratePolicyDetail;
import com.kimmy.learn.web.entity.db.ProjDbMapping;
import com.kimmy.learn.web.mapper.GeneratePolicyDetailMapper;
import com.kimmy.learn.web.mapper.GeneratePolicyMapper;
import com.kimmy.learn.web.mapper.ProjDbMappingMapper;
import com.kimmy.learn.web.mapper.ProjectMapper;
import com.kimmy.learn.web.service.GeneratePolicyService;
import com.kimmy.learn.web.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class GeneratePolicyServiceImpl implements GeneratePolicyService {

    @Autowired
    GeneratePolicyMapper generatePolicyMapper;
    @Autowired
    GeneratePolicyDetailMapper generatePolicyDetailMapper;

    @Override
    public GeneratePolicyListResponse list(GeneratePolicyListRequest request) {
        return GeneratePolicyListResponse.success(generatePolicyMapper.list());
    }

    @Override
    public GeneratePolicyAddResponse add(GeneratePolicyAddRequest request) {
        generatePolicyMapper.add(request);
        return GeneratePolicyAddResponse.success();
    }

    @Override
    public GeneratePolicyDelResponse del(GeneratePolicyDelRequest request) {
        generatePolicyMapper.del(request);
        return GeneratePolicyDelResponse.success();
    }

    @Override
    public GeneratePolicyDetailListResponse detailList(GeneratePolicyDetailListRequest request) {
        return GeneratePolicyDetailListResponse.success(generatePolicyDetailMapper.listByPolicyId(request.getPolicyId()));
    }

    @Override
    public GeneratePolicyAddDetailResponse addDetail(GeneratePolicyAddDetailRequest request) {
        generatePolicyDetailMapper.add(request);
        return GeneratePolicyAddDetailResponse.success();
    }

    @Override
    public GeneratePolicyDelDetailResponse delDetail(GeneratePolicyDelDetailRequest request) {
        generatePolicyDetailMapper.del(request.getPolicyId(), request.getPolicyDetailId());
        return GeneratePolicyDelDetailResponse.success();
    }

    @Override
    public GeneratePolicyUpdDetailResponse updDetail(GeneratePolicyUpdDetailRequest request) {
        generatePolicyDetailMapper.upd(request);
        return GeneratePolicyUpdDetailResponse.success();
    }

}
