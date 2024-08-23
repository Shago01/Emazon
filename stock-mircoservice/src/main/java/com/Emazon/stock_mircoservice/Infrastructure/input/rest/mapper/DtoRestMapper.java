package com.Emazon.stock_mircoservice.Infrastructure.input.rest.mapper;

import com.Emazon.stock_mircoservice.Infrastructure.input.rest.dto.request.RequestDto;
import com.Emazon.stock_mircoservice.Infrastructure.input.rest.dto.res.ResponseDto;
import com.Emazon.stock_mircoservice.domine.models.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoRestMapper {

    public Category toCategoryModel(RequestDto requestDto){
        return new Category(
                requestDto.getName(),
                requestDto.getDescription()
        );
    }

    public ResponseDto toResposeDto(Category category){
        return new ResponseDto(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }

}
