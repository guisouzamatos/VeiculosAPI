package com.api.veiculosapi.repository;

import com.api.veiculosapi.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
