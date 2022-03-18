package com.api.veiculosapi.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class BrandDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotBlank
    private String name;
}
