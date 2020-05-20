package com.zfortes.music.api.repository;

import com.zfortes.music.api.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    List<AppUser> findAll();
    Optional<AppUser> findByUsername(String username);
    boolean existsAppUserByIdAndUsername(Long id, String username);
}
