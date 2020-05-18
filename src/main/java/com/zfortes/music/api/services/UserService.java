package com.zfortes.music.api.services;

import com.zfortes.music.api.repository.UserRepository;
import com.zfortes.music.api.services.dtos.UserDTO;
import com.zfortes.music.api.services.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<UserDTO> save(UserDTO userDTO) {
        return ResponseEntity.ok().body(userRepository.save(userDTO.toUser()).toDto());
    }

    public ResponseEntity<UserDTO> findById(Long id) {
        return ResponseEntity.ok().body(userRepository.findById(id).get().toDto());
    }

    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok()
                .body(userRepository.findAll().stream().map(UserMapper::toDto).collect(Collectors.toList()));
    }

    public ResponseEntity<?> update(UserDTO userDTO) {
        if (userDTO.getId() != null)
            return ResponseEntity.ok().body(userRepository.save(userDTO.toUser()).toDto());
        else
            return ResponseEntity.badRequest().body("ID is not set null");
    }
}
