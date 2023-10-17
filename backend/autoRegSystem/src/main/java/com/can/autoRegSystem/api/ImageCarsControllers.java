package com.can.autoRegSystem.api;


import com.can.autoRegSystem.DTOs.request.ImageAddRequest;
import com.can.autoRegSystem.DTOs.response.ImageResponse;
import com.can.autoRegSystem.bussiness.abstractt.IImageCarService;
import com.can.autoRegSystem.core.utilities.DataResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/images")
public class ImageCarsControllers {


    private final IImageCarService iImageCarService;

    public ImageCarsControllers(IImageCarService iImageCarService) {
        this.iImageCarService = iImageCarService;
    }


    @GetMapping
    public DataResult<List<ImageResponse>>getAllOrByCarId(@RequestParam Optional<Integer> carId){
        return iImageCarService.getAllOrByCarId(carId);
    }


    @GetMapping("/{imageId}")
    public DataResult<ImageResponse> getImageById(@PathVariable int imageId){
        return iImageCarService.getImageById(imageId);
    }

    @PostMapping
    public DataResult<ImageResponse> addOneImage(@RequestBody ImageAddRequest imageAddRequest){
        return iImageCarService.addOneImage(imageAddRequest);
    }

    @DeleteMapping("/{imageId}")
    public DataResult<Integer> removeOneImage(@PathVariable int imageId){
        return iImageCarService.removeOneImage(imageId);
    }

}
