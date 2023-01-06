package com.kimmy.learn.web.controller;

import com.kimmy.learn.web.controller.domain.request.generate.*;
import com.kimmy.learn.web.controller.domain.request.project.ProjectAddRequest;
import com.kimmy.learn.web.controller.domain.request.project.ProjectListRequest;
import com.kimmy.learn.web.controller.domain.response.generate.*;
import com.kimmy.learn.web.controller.domain.response.project.ProjectAddResponse;
import com.kimmy.learn.web.controller.domain.response.project.ProjectListResponse;
import com.kimmy.learn.web.service.GeneratePolicyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/generatePolicy")
public class GeneratePolicyController {

    @Autowired
    GeneratePolicyService generatePolicyService;

    @RequestMapping("/list")
    public GeneratePolicyListResponse list(@RequestBody GeneratePolicyListRequest request) {
        return generatePolicyService.list(request);
    }

    @RequestMapping("/add")
    public GeneratePolicyAddResponse add(@RequestBody GeneratePolicyAddRequest request) {
        return generatePolicyService.add(request);
    }

    @RequestMapping("/del")
    public GeneratePolicyDelResponse del(@RequestBody GeneratePolicyDelRequest request) {
        return generatePolicyService.del(request);
    }

    @RequestMapping("/detailList")
    public GeneratePolicyDetailListResponse detailList(@RequestBody GeneratePolicyDetailListRequest request) {
        return generatePolicyService.detailList(request);
    }

    @RequestMapping("/addDetail")
    public GeneratePolicyAddDetailResponse addDetail(@RequestBody GeneratePolicyAddDetailRequest request) {
        return generatePolicyService.addDetail(request);
    }

    @RequestMapping("delDetail")
    public GeneratePolicyDelDetailResponse delDetail(@RequestBody GeneratePolicyDelDetailRequest request) {
        return generatePolicyService.delDetail(request);
    }

    @RequestMapping("updDetail")
    public GeneratePolicyUpdDetailResponse updDetail(@RequestBody GeneratePolicyUpdDetailRequest request) {
        return generatePolicyService.updDetail(request);
    }


}
