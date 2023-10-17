package com.can.autoRegSystem.DTOs.response;

import com.can.autoRegSystem.entities.Car;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CarResponse {
    private int id;

   private int userId;
    private String userName;

    private String carName;

    private String brand;

    private String modal;

    private String year;

    private String plate;
    private Date createDate;
    private List<ImageResponse> carImages;

    public CarResponse(Car entity, List<ImageResponse>images) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getUserName();
        this.carName = entity.getCarName();
        this.brand = entity.getBrand();
        this.modal = entity.getModal();
        this.year = entity.getYear();
        this.plate = entity.getPlate();
        this.createDate = entity.getCreateDate();
        this.carImages=images;
    }
}

