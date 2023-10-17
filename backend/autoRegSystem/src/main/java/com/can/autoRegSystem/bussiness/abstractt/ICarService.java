package com.can.autoRegSystem.bussiness.abstractt;

import com.can.autoRegSystem.DTOs.request.CreateCarRequest;
import com.can.autoRegSystem.DTOs.request.UpdateCarRequest;
import com.can.autoRegSystem.DTOs.response.CarResponse;
import com.can.autoRegSystem.core.utilities.DataResult;
import com.can.autoRegSystem.entities.Car;

import java.util.List;
import java.util.Optional;

public interface ICarService {
    DataResult<List<CarResponse>> getAllCarsOrfindByUserIdOrBrandOrModel(Optional<Integer> userId, Optional<String> modal, Optional<String> brand);

    DataResult<Car> getOneCarsByIdHelp(int carId);
    DataResult<CarResponse> getOneCarsByIdApi(int carId);


    DataResult<Car> createOneCar(CreateCarRequest createCarRequest);

    DataResult<Car> updateOneCar(int carId, UpdateCarRequest updateCarRequest);

    DataResult<Integer> removeById(int carId);
}
