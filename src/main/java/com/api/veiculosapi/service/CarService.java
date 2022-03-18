package com.api.veiculosapi.service;

import com.api.veiculosapi.dto.CarDTO;
import com.api.veiculosapi.entity.Brand;
import com.api.veiculosapi.entity.Car;
import com.api.veiculosapi.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CarService {

    private final CarRepository carRepository;

    @Transactional
    public void save(CarDTO carDTO) {
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setName(carDTO.getName());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setColor(carDTO.getColor());
        car.setCategory(carDTO.getCategory());
        Brand brand = new Brand();
        brand.setId(carDTO.getBrandId());
        car.setBrand(brand);
        carRepository.save(car);
    }

    public CarDTO getById(Integer id) {
        if (carRepository.findById(id).isPresent()) {
            CarDTO carDTO = new CarDTO();
            carDTO.setId(carRepository.findById(id).get().getId());
            carDTO.setName(carRepository.findById(id).get().getName());
            return carDTO;
        }
        return null;
    }

    public List<CarDTO> getAll() {
        List<CarDTO> list = new ArrayList<CarDTO>();
        carRepository.findAll().forEach(it -> {
            CarDTO carDTO = new CarDTO();
            carDTO.setId(it.getId());
            carDTO.setName(it.getName());
            carDTO.setModel(it.getModel());
            carDTO.setColor(it.getColor());
            carDTO.setYear(it.getYear());
            carDTO.setCategory(it.getCategory());
            carDTO.setBrandId(it.getBrand().getId());
            list.add(carDTO);
        });
        return list;
    }

    @Transactional
    public void delete(Integer id) {
        carRepository.deleteById(id);
    }
}
