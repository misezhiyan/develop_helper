package com.kimmy.learn.web.service;

import com.kimmy.learn.web.controller.domain.request.generate.*;
import com.kimmy.learn.web.controller.domain.response.generate.*;

public interface GeneratePolicyService {

    GeneratePolicyListResponse list(GeneratePolicyListRequest request);

    GeneratePolicyAddResponse add(GeneratePolicyAddRequest request);

    GeneratePolicyDetailListResponse detailList(GeneratePolicyDetailListRequest request);

    GeneratePolicyDelResponse del(GeneratePolicyDelRequest request);

    GeneratePolicyAddDetailResponse addDetail(GeneratePolicyAddDetailRequest request);

    GeneratePolicyDelDetailResponse delDetail(GeneratePolicyDelDetailRequest request);

    GeneratePolicyUpdDetailResponse updDetail(GeneratePolicyUpdDetailRequest request);
}
