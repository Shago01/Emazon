package com.Emazon.stock_mircoservice.domine.ports.out;

import com.Emazon.stock_mircoservice.domine.models.Category;

import java.util.List;

public interface ICategoryPersistencePort {

    List<Category> getAllCategories(Integer page, Integer pageZise, String SortBy, Boolean asc);
    void save(Category category);

}
