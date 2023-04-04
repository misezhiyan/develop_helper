package com.kimmy.learn.web.controller.domain.response.project;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.entity.domains.project.ProjectComponent;
import com.kimmy.learn.web.entity.domains.project.ProjectComponentRelyTree;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class ProjectModuleComponentRelyTreeListResponse extends BaseResponse {

    List<ProjectComponentRelyTree> treeList;

    public static ProjectModuleComponentRelyTreeListResponse success(List<ProjectComponentRelyTree> treeList) {
        ProjectModuleComponentRelyTreeListResponse response = new ProjectModuleComponentRelyTreeListResponse();
        response.setTreeList(treeList);
        return response;
    }
}
