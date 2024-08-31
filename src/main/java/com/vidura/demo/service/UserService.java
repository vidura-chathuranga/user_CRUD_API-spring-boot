package com.vidura.demo.service;

import com.vidura.demo.dto.UserDTO;
import com.vidura.demo.model.User;
import com.vidura.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        return modelMapper.map(users,new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = userRepository.save(modelMapper.map(userDTO,User.class));

        return modelMapper.map(user,UserDTO.class);
    }

    public UserDTO updateUser(UserDTO userDTO){
        User user = userRepository.save(modelMapper.map(userDTO,User.class));
        return modelMapper.map(user,UserDTO.class);
    }

    public String deleteUser(Integer id){
        userRepository.deleteById(id);
        return "user deleted";
    }
}
