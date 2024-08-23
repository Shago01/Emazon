package com.Emazon.stock_mircoservice.application.handler;

import com.Emazon.stock_mircoservice.domine.models.Category;

public interface ICategoryHandler {
    void saveCategoryInStock(Category category);
}
