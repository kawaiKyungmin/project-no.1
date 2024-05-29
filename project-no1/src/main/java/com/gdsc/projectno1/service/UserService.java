package com.gdsc.projectno1.service;

import com.gdsc.projectno1.dto.request.UserDto;
import com.gdsc.projectno1.entity.User;
import com.gdsc.projectno1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signIn(UserDto userDto){                        //로그인

        try {
            return userRepository.findByNameAndPassword(userDto.getName(), userDto.getPassword());

        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Error");
        }

    }


    public void signUp(UserDto userDto){                        // 회원 가입
        if((userRepository.findByName(userDto.getName())) != null){
            throw new IllegalArgumentException("This name is already used");
        }
        User user = new User(UUID.randomUUID().toString(),
                userDto.getName(),
                userDto.getPassword());
                userRepository.save(user);
    }

    public List<User> showAllUsers(){

        return userRepository.findAll();
    }
    public void deleteAll(){
        userRepository.deleteAll();
    }

}
