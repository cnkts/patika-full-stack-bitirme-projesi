package com.can.autoRegSystem.repository;

import com.can.autoRegSystem.entities.ImageCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ImageCarRepository extends JpaRepository<ImageCar,Integer> {
    List<ImageCar> findByCarId(Integer carId);
}
