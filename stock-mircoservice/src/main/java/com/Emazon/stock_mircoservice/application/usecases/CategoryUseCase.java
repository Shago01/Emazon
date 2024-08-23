package com.Emazon.stock_mircoservice.application.usecases;

import com.Emazon.stock_mircoservice.domine.models.Category;
import com.Emazon.stock_mircoservice.domine.ports.input.ICategoryServicePort;
import com.Emazon.stock_mircoservice.domine.ports.out.ICategoryPersistencePort;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

    private ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public List<Category> getAllCategories(Integer page, Integer pageZise, String SortBy, Boolean asc) {
        return categoryPersistencePort.getAllCategories(page,pageZise,SortBy,asc);
    }

    @Override
    public void createCategory(Category category) {
     categoryPersistencePort.save((category));
    }
}
