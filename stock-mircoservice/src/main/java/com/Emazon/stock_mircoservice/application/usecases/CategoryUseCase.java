package com.Emazon.stock_mircoservice.application.usecases;

import com.Emazon.stock_mircoservice.domine.models.Category;
import com.Emazon.stock_mircoservice.domine.ports.input.ICategoryServicePort;
import com.Emazon.stock_mircoservice.domine.ports.out.ICategoryPersistencePort;

public class CategoryUseCase implements ICategoryServicePort {

    private ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void createCategory(Category category) {
     categoryPersistencePort.save((category));
    }
}
