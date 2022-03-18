package com.api.veiculosapi.controller;

import com.api.veiculosapi.dto.CarDTO;
import com.api.veiculosapi.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {

    private final CarService service;

    @PostMapping("/post")
    public void save(@RequestBody CarDTO carDTO) {
        service.save(carDTO);
    }

    @GetMapping("/get-by-id/{id}")
    public CarDTO getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @GetMapping("get-all")
    public List<CarDTO> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
