package com.Emazon.stock_mircoservice.domine.ports.out;

import com.Emazon.stock_mircoservice.domine.models.Category;

import java.util.List;

public interface ICategoryPersistencePort {

    void save(Category category);

}
