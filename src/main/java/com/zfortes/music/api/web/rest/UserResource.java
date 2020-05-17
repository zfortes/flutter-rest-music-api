package com.zfortes.music.api.web.rest;

import com.zfortes.music.api.services.UserService;
import com.zfortes.music.api.services.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> save(@Valid UserDTO userDTO){
        return userService.save(userDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long  id){
        return userService.findById(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid UserDTO userDTO){
        return userService.update(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return userService.findAll();
    }
}
