package com.miles.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.util.List;


@Api(tags = "用户管理")
@RestController
public class UserController {

    @Autowired
    private userRepository userRepository;

    @ApiOperation(value = "获取所有用户列表")
    @GetMapping(value = "/users")
    public List<User> userList()
    {
        return userRepository.findAll();
    }

    @ApiOperation(value = "创建用户")
    @PostMapping(value = "/users")
    public User addUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }
}
