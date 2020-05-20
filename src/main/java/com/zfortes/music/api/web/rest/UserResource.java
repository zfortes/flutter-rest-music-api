package com.zfortes.music.api.web.rest;

import com.zfortes.music.api.services.UserService;
import com.zfortes.music.api.services.dtos.AppUserDTO;
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
    public ResponseEntity<?> save(@RequestBody @Valid AppUserDTO appUserDTO){
        return userService.save(appUserDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUserDTO> findById(@PathVariable Long  id){
        return userService.findById(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid AppUserDTO appUserDTO){
        return userService.update(appUserDTO);
    }

    @GetMapping
    public ResponseEntity<List<AppUserDTO>> findAll(){
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return userService.deleteById(id);
    }
}
