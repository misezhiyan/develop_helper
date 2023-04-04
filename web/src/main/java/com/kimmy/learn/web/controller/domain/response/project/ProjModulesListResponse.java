package com.kimmy.learn.web.controller.domain.response.project;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.entity.db.ProjectModule;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class ProjModulesListResponse extends BaseResponse {

    List<ProjectModule> list;

    public static ProjModulesListResponse success(List<ProjectModule> list) {
        ProjModulesListResponse response = new ProjModulesListResponse();
        response.setList(list);
        return response;
    }
}
