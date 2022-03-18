package com.api.veiculosapi.service;

import com.api.veiculosapi.dto.BrandDTO;
import com.api.veiculosapi.entity.Brand;
import com.api.veiculosapi.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BrandService {
    private final BrandRepository brandRepository;

    @Transactional
    public Brand save(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setId(brandDTO.getId());
        brand.setName(brandDTO.getName());
        return brandRepository.save(brand);
    }

    public BrandDTO getById(Integer id) {
        if (brandRepository.findById(id).isPresent()) {
            BrandDTO brandDTO = new BrandDTO();
            brandDTO.setId(brandRepository.findById(id).get().getId());
            brandDTO.setName(brandRepository.findById(id).get().getName());
            return brandDTO;
        }
        return null;
    }

    public List<BrandDTO> getAll() {
        List<BrandDTO> lista = new ArrayList<BrandDTO>();
        brandRepository.findAll().forEach(it -> {
            BrandDTO brandDTO = new BrandDTO();
            brandDTO.setId(it.getId());
            brandDTO.setName(it.getName());
            lista.add(brandDTO);
        });
        return lista;
    }
}
