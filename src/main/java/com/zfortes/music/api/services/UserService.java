package com.zfortes.music.api.services;

import com.zfortes.music.api.repository.UserRepository;
import com.zfortes.music.api.services.dtos.AppUserDTO;
import com.zfortes.music.api.services.mappers.AppUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<AppUserDTO> save(AppUserDTO appUserDTO) {
        return ResponseEntity.ok().body(AppUserMapper.toDto(userRepository.save(AppUserMapper.toAppUser(appUserDTO))));
    }

    public ResponseEntity<AppUserDTO> findById(Long id) {
        return ResponseEntity.ok().body(AppUserMapper.toDto(userRepository.findById(id).get()));
    }

    public ResponseEntity<List<AppUserDTO>> findAll() {
        return ResponseEntity.ok()
                .body(userRepository.findAll().stream().map(AppUserMapper::toDto).collect(Collectors.toList()));
    }

    public ResponseEntity<?> update(AppUserDTO appUserDTO) {
        if (appUserDTO.getId() != null)
            return ResponseEntity.ok().body(AppUserMapper.toDto(userRepository.save(AppUserMapper.toAppUser(appUserDTO))));
        else
            return ResponseEntity.badRequest().body("ID is not set null");
    }
}
