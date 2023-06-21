package com.kimmy.learn.web.controller;

import com.kimmy.learn.web.controller.domain.request.MenuRequest;
import com.kimmy.learn.web.controller.domain.response.MenuResponse;
import com.kimmy.learn.web.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
// @CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    /**
     * 菜单列表
     * @param request
     * @return
     */
    @RequestMapping("/getMenuList")
    public MenuResponse getMenuList(@RequestBody MenuRequest request) {

        return menuService.getMenuList(request);
    }

    @RequestMapping("/addMenu")
    public MenuResponse addMenu(@RequestBody MenuRequest request) {

        return menuService.addMenu(request);
    }

    @RequestMapping("/delMenu")
    public MenuResponse delMenu(@RequestBody MenuRequest request) {

        return menuService.delMenu(request);
    }
}
