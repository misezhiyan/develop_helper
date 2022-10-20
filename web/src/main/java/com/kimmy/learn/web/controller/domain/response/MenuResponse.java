package com.kimmy.learn.web.controller.domain.response;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.entity.db.Menu;
import com.kimmy.learn.web.entity.domains.MenuTree;
import com.kimmy.learn.web.enums.ResMsg;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuResponse extends BaseResponse {

    private List<MenuTree> menuList;

    public List<MenuTree> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuTree> menuList) {
        this.menuList = menuList;
    }

    public static MenuResponse success(List<MenuTree> menuList) {
        MenuResponse response = response(ResMsg.SUCCESS);
        response.setMenuList(menuList);
        return response;
    }

    public static MenuResponse success() {
        return response(ResMsg.SUCCESS);
    }

    public static MenuResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static MenuResponse response(ResMsg resMsg) {
        MenuResponse response = new MenuResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
