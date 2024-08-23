package com.Emazon.stock_mircoservice.application.handler;

import com.Emazon.stock_mircoservice.Infrastructure.output.jpa.repositories.ICategoryRepository;
import com.Emazon.stock_mircoservice.domine.models.Category;
import com.Emazon.stock_mircoservice.domine.ports.input.ICategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryHandler implements ICategoryHandler {

    private final ICategoryServicePort categoryServicePort;

    @Override
    public void saveCategoryInStock(Category category) {
        categoryServicePort.createCategory(category);
    }

    @Override
    public List<Category> getAllCategories(Integer page, Integer pageZise, String SortBy, Boolean ascending) {
        return categoryServicePort.getAllCategories(page,pageZise,SortBy,ascending);
    }

}
