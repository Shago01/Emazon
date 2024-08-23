package com.Emazon.stock_mircoservice.Infrastructure.output.jpa.adapters;

import com.Emazon.stock_mircoservice.Infrastructure.exceptionHandler.exception.CategoryAlreadyExistsException;
import com.Emazon.stock_mircoservice.Infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.Emazon.stock_mircoservice.Infrastructure.output.jpa.repositories.ICategoryRepository;
import com.Emazon.stock_mircoservice.domine.models.Category;
import com.Emazon.stock_mircoservice.domine.ports.out.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CategoryAdapterPort implements ICategoryPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;    

    @Override
    public void save(Category category) {
       if(categoryRepository.findByName(category.getName()).isPresent()) {
           throw new CategoryAlreadyExistsException();
       }
       categoryRepository.save(categoryEntityMapper.toEntity(category));
     
    }

}
