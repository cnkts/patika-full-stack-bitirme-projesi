package com.can.autoRegSystem.bussiness.abstractt;

import com.can.autoRegSystem.DTOs.request.ChangePasswordUserRequest;
import com.can.autoRegSystem.DTOs.request.CreateUserRequest;
import com.can.autoRegSystem.DTOs.response.ChangePasswordResponse;
import com.can.autoRegSystem.core.utilities.DataResult;
import com.can.autoRegSystem.core.utilities.Result;
import com.can.autoRegSystem.entities.User;

import java.util.List;

public interface IUserService {
    DataResult<List<User>> getAllUser();

    DataResult<User> getById(int userId);

    DataResult<User> getByUserName(String userName);

    DataResult<User> createOneUser(CreateUserRequest createUserRequest);

   ChangePasswordResponse updateOneUser(int userId, ChangePasswordUserRequest changePasswordUserRequest);

    Result removeById(int userId);
}
