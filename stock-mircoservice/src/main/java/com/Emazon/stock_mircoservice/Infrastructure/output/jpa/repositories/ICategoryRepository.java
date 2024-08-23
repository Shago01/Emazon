package com.Emazon.stock_mircoservice.Infrastructure.output.jpa.repositories;


import com.Emazon.stock_mircoservice.Infrastructure.output.jpa.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);

}
