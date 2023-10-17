package com.can.autoRegSystem.bussiness.abstractt;


import com.can.autoRegSystem.DTOs.request.ImageAddRequest;
import com.can.autoRegSystem.DTOs.response.ImageResponse;
import com.can.autoRegSystem.core.utilities.DataResult;

import java.util.List;
import java.util.Optional;

public interface IImageCarService {
    DataResult<List<ImageResponse>> getAllOrByCarId(Optional<Integer> carId);

    DataResult<ImageResponse> getImageById(int imageId);

    DataResult<ImageResponse> addOneImage(ImageAddRequest imageAddRequest);

    DataResult<Integer> removeOneImage(int imageId);
}
