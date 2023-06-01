package org.eijsink.injection.complex;

import org.eijsink.injection.complex.controller.MenuController;
import org.eijsink.injection.complex.repository.MenuRepository;
import org.eijsink.injection.complex.service.MenuService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        // No inversion of control or Dependency Injection
        MenuRepository menuRepository = new MenuRepository();
        MenuService menuService = new MenuService();
        menuService.setMenuRepository( menuRepository);
        MenuController menuController = new MenuController();
        menuController.setMenuService( menuService);

        List<String> menus = menuController.findAll();

        for (String menu: menus) {
            System.out.println( menu);;
        }

        // Let framework do it's magic
        FrameWork.wireApplication();
        Map<String, Object> context =  FrameWork.getContext();
        for( String name: context.keySet()){
            System.out.println("Name: " + name);
        }

        menus = menuController.findAll();

        for (String menu: menus) {
            System.out.println( menu);;
        }

    }
}
