package com.kimmy.learn.web.mapper;

import com.kimmy.learn.web.controller.domain.request.generate.GeneratePolicyAddRequest;
import com.kimmy.learn.web.controller.domain.request.generate.GeneratePolicyDelRequest;
import com.kimmy.learn.web.entity.db.DbConnectConfig;
import com.kimmy.learn.web.entity.db.GeneratePolicy;
import com.kimmy.learn.web.entity.domains.generate.PolicyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GeneratePolicyMapper {

    List<GeneratePolicy> list();

    int add(GeneratePolicy request);

    int del(GeneratePolicy request);

    PolicyDetail policyDetail(Integer policyId);
}
