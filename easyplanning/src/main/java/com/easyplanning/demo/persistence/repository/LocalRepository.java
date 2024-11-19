package com.easyplanning.demo.persistence.repository;

import com.easyplanning.demo.persistence.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
}
