package com.kimmy.learn.web.service;

import com.kimmy.learn.web.controller.domain.request.template.*;
import com.kimmy.learn.web.controller.domain.response.template.*;

public interface TemplateService {

    TemplateListResponse templateList(TemplateListRequest request);

    TemplateAddResponse add(TemplateAddRequest request);

    TemplateUdpResponse update(TemplateUdpRequest request);

    TemplateFieldsListResponse templateFieldsList(TemplateFieldsListRequest request);

    TemplateFieldAddResponse templateFieldAdd(TemplateFieldAddRequest request);

    TemplateShowResponse showTemplateResult(TemplateShowRequest request);
}
