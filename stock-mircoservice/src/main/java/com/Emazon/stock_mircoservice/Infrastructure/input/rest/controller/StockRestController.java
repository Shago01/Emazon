package com.Emazon.stock_mircoservice.Infrastructure.input.rest.controller;

import com.Emazon.stock_mircoservice.Infrastructure.input.rest.dto.request.RequestDto;
import com.Emazon.stock_mircoservice.Infrastructure.input.rest.dto.res.ResponseDto;
import com.Emazon.stock_mircoservice.Infrastructure.input.rest.mapper.DtoRestMapper;
import com.Emazon.stock_mircoservice.application.handler.ICategoryHandler;

import com.Emazon.stock_mircoservice.domine.models.Category;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import  org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock/category")
@RequiredArgsConstructor

@Tag(name = "category", description = "Operaciones relacionadas con las categorías en el stock")
public class StockRestController {
    private final ICategoryHandler categoryHandler;
    private final DtoRestMapper dtoRestMapper;

    @Operation(
            summary = "Crear una nueva categoría",
            description = "Crea una nueva categoría en el stock utilizando los datos proporcionados en el cuerpo de la solicitud."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoría creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida. Los datos proporcionados son incorrectos o incompletos."),
            @ApiResponse(responseCode = "409", description = "Conflicto. La categoría ya existe o hay un conflicto con los datos proporcionados."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor. No se pudo procesar la solicitud.")
    })
    @PostMapping()
    public ResponseEntity<Void> createCategory(@RequestBody RequestDto requestDto) {
        categoryHandler.saveCategoryInStock(dtoRestMapper.toCategoryModel(requestDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
