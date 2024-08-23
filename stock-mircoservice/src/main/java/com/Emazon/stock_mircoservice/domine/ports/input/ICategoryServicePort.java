package com.Emazon.stock_mircoservice.domine.ports.input;

import com.Emazon.stock_mircoservice.domine.models.Category;

public interface ICategoryServicePort {
    void createCategory(Category category);
}
