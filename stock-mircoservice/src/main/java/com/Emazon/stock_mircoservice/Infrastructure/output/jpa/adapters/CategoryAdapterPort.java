package com.Emazon.stock_mircoservice.Infrastructure.output.jpa.adapters;

import com.Emazon.stock_mircoservice.Infrastructure.exceptionHandler.exception.CategoryAlreadyExistsException;
import com.Emazon.stock_mircoservice.Infrastructure.exceptionHandler.exception.ElementNotFoundException;
import com.Emazon.stock_mircoservice.Infrastructure.output.jpa.entities.CategoryEntity;
import com.Emazon.stock_mircoservice.Infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.Emazon.stock_mircoservice.Infrastructure.output.jpa.repositories.ICategoryRepository;
import com.Emazon.stock_mircoservice.domine.models.Category;
import com.Emazon.stock_mircoservice.domine.ports.out.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;


@RequiredArgsConstructor
public class CategoryAdapterPort implements ICategoryPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public List<Category> getAllCategories(Integer page, Integer pageZise, String SortBy, Boolean asc) {
        PageRequest pagination = PageRequest.of(page,pageZise,asc ? Sort.by(SortBy).ascending() : Sort.by(SortBy).descending());
        List<CategoryEntity> listEntities = categoryRepository.findAll(pagination).getContent();

        if(listEntities.isEmpty()){
         throw new ElementNotFoundException();
        }

        return categoryEntityMapper.toListCategory(listEntities);
    }

    @Override
    public void save(Category category) {
       if(categoryRepository.findByName(category.getName()).isPresent()) {
           throw new CategoryAlreadyExistsException();
       }
       categoryRepository.save(categoryEntityMapper.toEntity(category));
     
    }


}
