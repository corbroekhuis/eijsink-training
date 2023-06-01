package org.eijsink.injection.complex.repository;

import org.eijsink.injection.complex.annotation.SpringAnnotation;

import java.util.Arrays;
import java.util.List;

@SpringAnnotation
public class MenuRepository {

    List<String> menus = Arrays.asList(
            "Lasagna",
            "Pazza pepperoni",
            "Stuffed aubergine",
            "Spagetti carbonara",
            "Fritata with vegetables"
    );

    public List<String> findAll(){
        return menus;
    }

}
