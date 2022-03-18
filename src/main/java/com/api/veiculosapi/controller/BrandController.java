package com.api.veiculosapi.controller;

import com.api.veiculosapi.dto.BrandDTO;
import com.api.veiculosapi.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService service;

    @PostMapping("/post")
    public void save(@RequestBody BrandDTO brand) {
        service.save(brand);
    }

    @GetMapping("/get-by-id/{id}")
    public BrandDTO getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @GetMapping("/get-all")
    public List<BrandDTO> getAll() {
        return service.getAll();
    }
}
