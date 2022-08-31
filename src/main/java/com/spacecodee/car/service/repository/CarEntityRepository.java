package com.spacecodee.car.service.repository;

import com.spacecodee.car.service.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarEntityRepository extends JpaRepository<CarEntity, Integer> {

    List<CarEntity> findByCarUserId(int userId);
}