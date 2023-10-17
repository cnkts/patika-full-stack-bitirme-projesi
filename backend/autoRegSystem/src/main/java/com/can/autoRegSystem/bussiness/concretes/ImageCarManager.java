package com.can.autoRegSystem.bussiness.concretes;

import com.can.autoRegSystem.DTOs.request.ImageAddRequest;
import com.can.autoRegSystem.DTOs.response.ImageResponse;
import com.can.autoRegSystem.bussiness.abstractt.ICarService;
import com.can.autoRegSystem.bussiness.abstractt.IImageCarService;
import com.can.autoRegSystem.core.utilities.DataResult;
import com.can.autoRegSystem.core.utilities.ErrorDataResult;
import com.can.autoRegSystem.core.utilities.SuccesDataResult;
import com.can.autoRegSystem.entities.Car;
import com.can.autoRegSystem.entities.ImageCar;
import com.can.autoRegSystem.repository.ImageCarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageCarManager implements IImageCarService {

    private final ImageCarRepository imageCarRepository;
    private final ICarService carService;

    public ImageCarManager(ImageCarRepository imageCarRepository, ICarService carService) {
        this.imageCarRepository = imageCarRepository;
        this.carService = carService;
    }


    @Override
    public DataResult<List<ImageResponse>> getAllOrByCarId(Optional<Integer> carId) {
        List<ImageCar> images;
        if (carId.isPresent()){
            images=imageCarRepository.findByCarId(carId.get());
            return new
                    SuccesDataResult<List<ImageResponse>>
                    ("Data getirildi",  images.stream().map(imageCar -> new ImageResponse(imageCar)).collect(Collectors.toList()));
        }
        images=imageCarRepository.findAll();
        return new SuccesDataResult<List<ImageResponse>>
                ("Data getirildi",images.stream().map(imageCar -> new ImageResponse(imageCar)).collect(Collectors.toList()));
    }

    @Override
    public DataResult<ImageResponse> getImageById(int imageId) {
        Optional<ImageCar> image=imageCarRepository.findById(imageId);
        if (image.isPresent()){
            return new SuccesDataResult<ImageResponse>("Data Getirildi",new ImageResponse(image.get()));
        }
        return new ErrorDataResult<ImageResponse>("Data Getirilemedi",null);
    }

    public DataResult<ImageCar> getImageByIdHelp(int imageId) {
        Optional<ImageCar> image=imageCarRepository.findById(imageId);
        if (image.isPresent()){
            return new SuccesDataResult<ImageCar>("Data Getirildi",image.get());
        }
        return new ErrorDataResult<ImageCar>("Data Getirilemedi",null);
    }

    @Override
    public DataResult<ImageResponse> addOneImage(ImageAddRequest imageAddRequest) {
        Car isHaveCar=carService.getOneCarsByIdHelp(imageAddRequest.getCarId()).getData();
        if (isHaveCar!=null){
            ImageCar imageCar=new ImageCar();
            imageCar.setUrl(imageAddRequest.getUrl());
            imageCar.setCar(isHaveCar);
            imageCarRepository.save(imageCar);
            return new SuccesDataResult<ImageResponse>("Resim Eklendi",new ImageResponse(imageCar));
        }

        return new ErrorDataResult<ImageResponse>("Resim eklenemedi",null);
    }

    @Override
    public DataResult<Integer> removeOneImage(int imageId) {
        ImageCar imageCar=getImageByIdHelp(imageId).getData();
        if (imageCar!=null){
            return new SuccesDataResult<>("Resim silindi...",imageId);
        }
        return new ErrorDataResult<>("Silinecek resim yok",null);
    }


}
