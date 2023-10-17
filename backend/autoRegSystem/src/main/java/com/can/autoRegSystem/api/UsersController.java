package com.can.autoRegSystem.api;

import com.can.autoRegSystem.DTOs.request.ChangePasswordUserRequest;
import com.can.autoRegSystem.DTOs.request.CreateUserRequest;
import com.can.autoRegSystem.DTOs.response.ChangePasswordResponse;
import com.can.autoRegSystem.bussiness.abstractt.IUserService;
import com.can.autoRegSystem.core.utilities.DataResult;
import com.can.autoRegSystem.core.utilities.Result;
import com.can.autoRegSystem.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final IUserService userService;

    public UsersController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public DataResult<List<User>>getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/{userId}")
    public DataResult<User> getById(@PathVariable int userId){
        return userService.getById(userId);

    }



    @PostMapping
    public DataResult<User> createOneUser(@RequestBody CreateUserRequest createUserRequest){
        return userService.createOneUser(createUserRequest);
    }

    @PutMapping("/{userId}")
    public ChangePasswordResponse updateOneUser(@PathVariable int userId, @RequestBody ChangePasswordUserRequest changePasswordUserRequest){
        return userService.updateOneUser(userId,changePasswordUserRequest);
    }

    @DeleteMapping("/{userId}")
    public Result removeById(@PathVariable int userId){
        return userService.removeById(userId);
    }
}
