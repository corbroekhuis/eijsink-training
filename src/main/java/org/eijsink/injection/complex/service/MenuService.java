package org.eijsink.injection.complex.service;

import org.eijsink.injection.complex.annotation.Autowired;
import org.eijsink.injection.complex.annotation.SpringAnnotation;
import org.eijsink.injection.complex.cloud.CloudService;
import org.eijsink.injection.complex.repository.MenuRepository;

import java.util.List;

@SpringAnnotation
public class MenuService {

    MenuRepository menuRepository;
    CloudService cloudService;

    @Autowired
    public void setMenuRepository(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Autowired
    public void setCloudService(CloudService cloudService) {
        this.cloudService = cloudService;
    }

    public List<String> findAll(){

        cloudService.callAzureService();
        return menuRepository.findAll();
    }
}
