package com.example.demo.repository;

import com.example.demo.model.FichaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaRepository extends JpaRepository<FichaEntity, Long> {
}
