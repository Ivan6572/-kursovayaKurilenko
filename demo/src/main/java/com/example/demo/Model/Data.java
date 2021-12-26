package com.example.demo.Model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Мебель")
public class Data {
    @Schema(description = "Номер", example = "1")
    public int id;
    @Schema(description = "Название мебели", example = "Диван")
    public String name_furniture;
    @Schema(description = "Состав", example = "Кожа")
    public String description;
}
