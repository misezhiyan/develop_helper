package com.kimmy.learn.web.mapper;

import com.kimmy.learn.web.controller.domain.request.generate.GeneratePolicyDetailListRequest;
import com.kimmy.learn.web.controller.domain.request.generate.GeneratePolicyUpdDetailRequest;
import com.kimmy.learn.web.entity.db.GeneratePolicy;
import com.kimmy.learn.web.entity.db.GeneratePolicyDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GeneratePolicyDetailMapper {

    int add(GeneratePolicyDetail request);

    List<GeneratePolicyDetail> listByPolicyId(Integer policyId);

    int del(@Param("policyId")Integer policyId, @Param("id") Integer id);

    int upd(GeneratePolicyDetail request);
}
