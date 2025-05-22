package com.atividade.sa4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade.sa4.model.userModel;

public interface userRepository extends JpaRepository<userModel,Long> {
    Optional<userModel> findbyemail (String email);    
}
