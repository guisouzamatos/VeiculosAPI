package com.api.veiculosapi.entity;

import com.api.veiculosapi.entity.enums.CategoryEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String name;
    @Column
    private String model;
    @Column
    private Integer year;
    @Column
    private String color;
    @Column
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand", referencedColumnName = "id")
    private Brand brand;
}
