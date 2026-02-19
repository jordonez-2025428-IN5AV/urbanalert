package com.codecrafters.urbanalertgt.repository;


import com.codecrafters.urbanalertgt.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEstado
    extends JpaRepository <Estado, Long>{
}
