package com.can.autoRegSystem.DTOs.request;

import lombok.Data;

@Data
public class CreateCarRequest {


    private String carName;

    private String brand;

    private String modal;

    private String year;

    private String plate;

    private int userId;
    private String url;
}
