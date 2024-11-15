package com.example.demo.repository;

import com.example.demo.model.FichaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaRepository extends JpaRepository<FichaEntity, Long> {
}
