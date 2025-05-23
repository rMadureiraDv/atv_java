package com.atividade.sa4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade.sa4.model.userModel;

public interface userRepository extends JpaRepository<userModel,Long>{

}
