package com.api.veiculosapi.dto;

import com.api.veiculosapi.entity.enums.CategoryEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class CarDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String model;
    @NotBlank
    private Integer year;
    @NotBlank
    private String color;
    @NotBlank
    private CategoryEnum category;
    @NotBlank
    private Integer brandId;
}

