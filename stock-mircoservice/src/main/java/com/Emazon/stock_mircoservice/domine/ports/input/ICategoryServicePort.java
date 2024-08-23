package com.Emazon.stock_mircoservice.domine.ports.input;

import com.Emazon.stock_mircoservice.domine.models.Category;

import java.util.List;

public interface ICategoryServicePort {
    List<Category> getAllCategories( Integer page, Integer pageZise, Boolean ascending );
    void createCategory(Category category);
}
