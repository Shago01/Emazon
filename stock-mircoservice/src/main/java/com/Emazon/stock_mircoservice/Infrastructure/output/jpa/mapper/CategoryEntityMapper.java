package com.Emazon.stock_mircoservice.Infrastructure.output.jpa.mapper;

import com.Emazon.stock_mircoservice.Infrastructure.output.jpa.entities.CategoryEntity;
import com.Emazon.stock_mircoservice.domine.models.Category;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryEntityMapper {
    
    public Category toModel(CategoryEntity entity) {
        return new Category(entity.getId(), entity.getName(), entity.getDescription()); 
    }
    
    public CategoryEntity toEntity(Category model) {
        CategoryEntity entity = new CategoryEntity();
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        return entity;
    }

    public  List<Category> toListCategory (List<CategoryEntity> entities) {
        return entities.stream().map(this::toModel).collect(Collectors.toList());
    }

}
