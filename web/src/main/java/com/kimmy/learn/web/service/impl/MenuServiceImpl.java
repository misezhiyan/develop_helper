package com.kimmy.learn.web.service.impl;

import com.kimmy.learn.web.controller.domain.request.MenuRequest;
import com.kimmy.learn.web.controller.domain.response.MenuResponse;
import com.kimmy.learn.web.mapper.MenuMapper;
import com.kimmy.learn.web.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public MenuResponse getMenuList(MenuRequest request) {

        return MenuResponse.success(menuMapper.getMenuTree());
    }

    @Override
    public MenuResponse addMenu(MenuRequest request) {
        menuMapper.addMenu(request);
        return MenuResponse.success();
    }

    @Override
    public MenuResponse delMenu(MenuRequest request) {
        menuMapper.delMenu(request);
        return MenuResponse.success();
    }
}
