package com.Emazon.stock_mircoservice.Infrastructure.input.rest.controller;

import com.Emazon.stock_mircoservice.Infrastructure.exceptionHandler.ResponseException;
import com.Emazon.stock_mircoservice.Infrastructure.input.rest.dto.request.CategoryReq;
import com.Emazon.stock_mircoservice.Infrastructure.input.rest.dto.res.CategoryRes;
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
    public ResponseEntity<Void> createCategory(@RequestBody CategoryReq categoryReq) {
        categoryHandler.saveCategoryInStock(dtoRestMapper.toCategoryModel(categoryReq));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(
            summary = "Obtiene una lista de todas las categorías",
            description = "Este endpoint permite obtener una lista de categorías con paginación y ordenamiento. " +
                    "Se puede especificar el número de página y el tamaño de la página para controlar la paginación. " +
                    "También se puede elegir el campo por el que ordenar las categorías y la dirección del ordenamiento (ascendente o descendente). " +
                    "Si no se proporciona el campo de ordenamiento, se usa por defecto el campo 'name'. " +
                    "La dirección del ordenamiento por defecto es ascendente.",
            parameters = {
                    @Parameter(name = "page", description = "Número de la página para la paginación. El valor debe ser mayor o igual a 0.", example = "0"),
                    @Parameter(name = "size", description = "Número de elementos por página. El valor debe ser mayor que 0.", example = "10"),
                    @Parameter(name = "sortBy", description = "Campo por el que ordenar las categorías. El valor predeterminado es 'name'.", example = "name"),
                    @Parameter(name = "asc", description = "Indica si el ordenamiento debe ser ascendente. El valor predeterminado es true.", example = "true")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de categorías ordenadas y paginadas con éxito", content = {
                            @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json",
                                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CategoryRes.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Solicitud inválida, por ejemplo, parámetros de página o tamaño incorrectos",
                    content = {
                            @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json",
                            schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ResponseException.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
            }
    )
    @GetMapping
    public ResponseEntity<List<CategoryRes>> getAllCategoriesByOrder(
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam(defaultValue = "name", required = false) String sortBy,
            @RequestParam(defaultValue = "true", required = false) boolean asc) {

        List<Category> listCategory = categoryHandler.getAllCategories(page, size, sortBy, asc);
        return ResponseEntity.ok(dtoRestMapper.toListCategoryRes(listCategory));
    }
}



