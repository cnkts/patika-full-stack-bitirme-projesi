package com.can.autoRegSystem.api;

import com.can.autoRegSystem.DTOs.request.CreateCarRequest;
import com.can.autoRegSystem.DTOs.request.UpdateCarRequest;
import com.can.autoRegSystem.DTOs.response.CarResponse;
import com.can.autoRegSystem.bussiness.abstractt.ICarService;
import com.can.autoRegSystem.core.utilities.DataResult;
import com.can.autoRegSystem.entities.Car;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarsController {
    private final ICarService carService;

    public CarsController(ICarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public DataResult<List<CarResponse>> getAllCarsOrfindByUserIdOrBrandOrModel
            (@RequestParam Optional<Integer> userId,@RequestParam Optional<String> brand,@RequestParam Optional<String> modal){
        return carService.getAllCarsOrfindByUserIdOrBrandOrModel(userId,modal,brand);
    }


    @GetMapping("/{carId}")
    public DataResult<CarResponse> getOneCarsById(@PathVariable int carId){
        return carService.getOneCarsByIdApi(carId);
    }

    @PostMapping
    public DataResult<Car> createOneCar(@RequestBody CreateCarRequest createCarRequest){
        return carService.createOneCar(createCarRequest);
    }

    @PutMapping("/{carId}")
    public DataResult<Car> updateOneCar(@PathVariable int carId,@RequestBody UpdateCarRequest UpdateCarRequest){
        return carService.updateOneCar(carId,UpdateCarRequest);
    }

    @DeleteMapping("{carId}")
    public DataResult<Integer> removeById(@PathVariable int carId){
        return carService.removeById(carId);
    }
}
