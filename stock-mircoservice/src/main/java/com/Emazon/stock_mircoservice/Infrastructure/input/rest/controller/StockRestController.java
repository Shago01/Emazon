package com.Emazon.stock_mircoservice.Infrastructure.input.rest.controller;

import com.Emazon.stock_mircoservice.Infrastructure.input.rest.dto.request.RequestDto;
import com.Emazon.stock_mircoservice.Infrastructure.input.rest.mapper.DtoRestMapper;
import com.Emazon.stock_mircoservice.application.handler.ICategoryHandler;
import com.Emazon.stock_mircoservice.domine.exception.EmptyFieldException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import  org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock/category")
@RequiredArgsConstructor
public class StockRestController {
    private final ICategoryHandler categoryHandler;
    private final DtoRestMapper dtoRestMapper;

    @PostMapping("/")
    public ResponseEntity<Void> createCategory(@RequestBody RequestDto requestDto) {
        categoryHandler.saveCategoryInStock(dtoRestMapper.toCategoryModel(requestDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
