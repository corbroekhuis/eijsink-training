package org.eijsink.injection.complex.controller;

import org.eijsink.injection.complex.annotation.Autowired;
import org.eijsink.injection.complex.annotation.SpringAnnotation;
import org.eijsink.injection.complex.service.MenuService;

import java.util.List;

@SpringAnnotation
public class MenuController {

    MenuService menuService;

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    public List<String> findAll(){
        return menuService.findAll();
    }

}
