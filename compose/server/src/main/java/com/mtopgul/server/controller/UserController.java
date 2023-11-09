package com.mtopgul.server.controller;

import com.mtopgul.server.data.UserModel;
import com.mtopgul.server.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author muhammed-topgul
 * @since 09/11/2023 10:53
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/status")
    public String status() {
        return "Server is Up";
    }

    @GetMapping("/time")
    public String getTime() {
        return "Server time: " + LocalDateTime.now();
    }

    @GetMapping("/find/{username}")
    public String findUser(@PathVariable String username) {
        UserModel userModel = userRepository.findByUsername(username);
        if (Objects.isNull(userModel)) {
            return "User not found";
        }
        return userModel.toString();
    }
}
