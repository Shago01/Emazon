package com.Emazon.stock_mircoservice.Infrastructure.config;

import com.Emazon.stock_mircoservice.Infrastructure.output.jpa.adapters.CategoryAdapterPort;
import com.Emazon.stock_mircoservice.Infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.Emazon.stock_mircoservice.Infrastructure.output.jpa.repositories.ICategoryRepository;
import com.Emazon.stock_mircoservice.application.usecases.CategoryUseCase;
import com.Emazon.stock_mircoservice.domine.ports.input.ICategoryServicePort;

import com.Emazon.stock_mircoservice.domine.ports.out.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ICategoryRepository categoryRepository;
    private  final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public ICategoryPersistencePort categoryPersistencePort(){
        return new CategoryAdapterPort(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryService() {
        return new CategoryUseCase(categoryPersistencePort());
    }



}
