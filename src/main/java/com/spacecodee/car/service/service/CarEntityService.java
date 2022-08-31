package com.spacecodee.car.service.service;

import com.spacecodee.car.service.entity.CarEntity;
import com.spacecodee.car.service.repository.CarEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarEntityService {

    private final CarEntityRepository carEntityRepository;

    public CarEntityService(CarEntityRepository carEntityRepository) {
        this.carEntityRepository = carEntityRepository;
    }

    public List<CarEntity> findAll() {
        return this.carEntityRepository.findAll();
    }

    public CarEntity getUserById(int id) {
        return this.carEntityRepository.findById(id).orElse(null);
    }

    public CarEntity save(CarEntity userEntity) {
        return this.carEntityRepository.save(userEntity);
    }

    public List<CarEntity> findByUserId(int userId) {
        return this.carEntityRepository.findByCarUserId(userId);
    }
}
