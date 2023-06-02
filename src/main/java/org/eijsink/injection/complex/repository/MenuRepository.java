package org.eijsink.injection.complex.repository;

import org.eijsink.injection.complex.annotation.SpringAnnotation;

import java.util.Arrays;
import java.util.List;

@SpringAnnotation
public class MenuRepository {

    List<String> menus = Arrays.asList(
            "Lasagna",
            "Pizza pepperoni",
            "Stuffed aubergine",
            "Spaghetti carbonara",
            "Fritata with vegetables"
    );

    public List<String> findAll(){
        return menus;
    }

}
