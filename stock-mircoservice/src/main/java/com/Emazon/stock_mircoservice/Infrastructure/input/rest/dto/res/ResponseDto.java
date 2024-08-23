package com.Emazon.stock_mircoservice.Infrastructure.input.rest.dto.res;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
    private long id;
    private String name;
    private String description;

}
