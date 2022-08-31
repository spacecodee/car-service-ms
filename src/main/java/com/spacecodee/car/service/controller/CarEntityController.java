package com.spacecodee.car.service.controller;

import com.spacecodee.car.service.entity.CarEntity;
import com.spacecodee.car.service.service.CarEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "http://localhost:4200/")
public class CarEntityController {

    private final CarEntityService carEntityService;

    public CarEntityController(CarEntityService carEntityService) {
        this.carEntityService = carEntityService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/list-all")
    public ResponseEntity<List<CarEntity>> getAllCars() {
        return ResponseEntity.ok(this.carEntityService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/by-user/{id}")
    public ResponseEntity<List<CarEntity>> getByUserId(@PathVariable int id) {
        return ResponseEntity.ok(this.carEntityService.findByUserId(id));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<CarEntity> getCarById(@PathVariable int id) {
        CarEntity user = this.carEntityService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/add")
    public ResponseEntity<CarEntity> addCar(@RequestBody CarEntity carEntity) {
        return new ResponseEntity<>(this.carEntityService.save(carEntity), HttpStatus.OK);
    }
}
