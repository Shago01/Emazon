package com.Emazon.stock_mircoservice.application.handler;

import com.Emazon.stock_mircoservice.domine.models.Category;

import java.util.List;

public interface ICategoryHandler {
    void saveCategoryInStock(Category category);
    List<Category> getAllCategories( Integer page, Integer pageZise, Boolean ascending );
}
