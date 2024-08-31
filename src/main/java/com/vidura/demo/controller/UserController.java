package com.vidura.demo.controller;

import com.vidura.demo.dto.UserDTO;
import com.vidura.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<UserDTO> getUser() {
        return userService.getAllUsers();
    }

    @PostMapping("")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping("")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
}
