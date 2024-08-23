package com.Emazon.stock_mircoservice.Infrastructure.input.rest.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryReq {
    private String name;
    private String description;
}
