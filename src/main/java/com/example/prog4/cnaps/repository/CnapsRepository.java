package com.example.prog4.cnaps.repository;

import com.example.prog4.cnaps.entity.Cnaps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CnapsRepository extends JpaRepository<Cnaps, String> {
}
