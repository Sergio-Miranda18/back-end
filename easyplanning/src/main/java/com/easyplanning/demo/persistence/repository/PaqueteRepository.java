package com.easyplanning.demo.persistence.repository;

import com.easyplanning.demo.persistence.entity.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Long> {
}
