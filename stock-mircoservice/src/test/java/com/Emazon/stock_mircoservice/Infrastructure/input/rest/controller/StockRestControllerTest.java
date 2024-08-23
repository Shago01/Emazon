package com.Emazon.stock_mircoservice.Infrastructure.input.rest.controller;

import com.Emazon.stock_mircoservice.Infrastructure.input.rest.dto.request.CategoryReq;
import com.Emazon.stock_mircoservice.application.handler.ICategoryHandler;
import com.Emazon.stock_mircoservice.domine.exception.EmptyFieldException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)  // Puedes omitir esta si usas Spring Boot 2.1+ ya que @SpringBootTest la incluye por defecto.
@AutoConfigureMockMvc
class StockRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICategoryHandler categoryHandler;

    @Test
    void shouldCreateCategorySuccessfully() throws Exception {
        // Arrange
        CategoryReq categoryReq = new CategoryReq();
        categoryReq.setName("Electronics");
        categoryReq.setDescription("All kinds of electronics.");

        // Act & Assert
        mockMvc.perform(post("/stock/category/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Electronics\",\"description\":\"All kinds of electronics.\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldReturnBadRequestWhenNameIsEmpty() throws Exception {
        // Act & Assert
        mockMvc.perform(post("/stock/category/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"\",\"description\":\"All kinds of electronics.\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestWhenDescriptionIsEmpty() throws Exception {
        // Act & Assert
        mockMvc.perform(post("/stock/category/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Electronics\",\"description\":\"\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldHandleEmptyFieldException() throws Exception {
        // Arrange
        Mockito.doThrow(new EmptyFieldException()).when(categoryHandler).saveCategoryInStock(Mockito.any());

        // Act & Assert
        mockMvc.perform(post("/stock/category/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"\",\"description\":\"\"}"))
                .andExpect(status().isBadRequest());
    }
}
