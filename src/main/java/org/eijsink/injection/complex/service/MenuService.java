package org.eijsink.injection.complex.service;

import org.eijsink.injection.complex.annotation.Autowired;
import org.eijsink.injection.complex.annotation.SpringAnnotation;
import org.eijsink.injection.complex.repository.MenuRepository;

import java.util.List;

@SpringAnnotation
public class MenuService {

    MenuRepository menuRepository;

    @Autowired
    public void setMenuRepository(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<String> findAll(){
        return menuRepository.findAll();
    }
}
