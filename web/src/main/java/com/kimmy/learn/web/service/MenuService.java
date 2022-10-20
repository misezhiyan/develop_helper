package com.kimmy.learn.web.service;

import com.kimmy.learn.web.controller.domain.request.MenuRequest;
import com.kimmy.learn.web.controller.domain.response.MenuResponse;

public interface MenuService {

    MenuResponse getMenuList(MenuRequest request);

    MenuResponse addMenu(MenuRequest request);

    MenuResponse delMenu(MenuRequest request);
}
