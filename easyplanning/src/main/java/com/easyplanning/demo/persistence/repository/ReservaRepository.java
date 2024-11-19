package com.easyplanning.demo.persistence.repository;

import com.easyplanning.demo.persistence.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, String> {
}
