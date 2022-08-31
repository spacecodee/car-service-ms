package com.spacecodee.car.service.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "car", schema = "car-service")
public class CarEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "car_id", nullable = false)
    private int carId;
    @Basic
    @Column(name = "car_model", nullable = false, length = 100)
    private String carModel;
    @Basic
    @Column(name = "car_brand", nullable = false, length = 100)
    private String carBrand;
    @Basic
    @Column(name = "car_user_id", nullable = false)
    private int carUserId;

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity carEntity = (CarEntity) o;
        return carId == carEntity.carId && carUserId == carEntity.carUserId && Objects.equals(carModel,
                                                                                              carEntity.carModel) && Objects.equals(
                carBrand, carEntity.carBrand);
    }

    @Override public int hashCode() {
        return Objects.hash(carId, carModel, carBrand, carUserId);
    }
}
