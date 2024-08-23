package com.Emazon.stock_mircoservice.Infrastructure.input.rest.mapper;

import com.Emazon.stock_mircoservice.Infrastructure.input.rest.dto.request.CategoryReq;
import com.Emazon.stock_mircoservice.Infrastructure.input.rest.dto.res.CategoryRes;
import com.Emazon.stock_mircoservice.domine.models.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoRestMapper {

    public Category toCategoryModel(CategoryReq categoryReq){
        return new Category(
                categoryReq.getName(),
                categoryReq.getDescription()
        );
    }

    public CategoryRes toCategoryRes(Category category){
        return new CategoryRes(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }

    public List<CategoryRes> toListCategoryRes(List<Category> categories){
        return  categories.stream().map(this::toCategoryRes).collect(Collectors.toList());
    }

}
