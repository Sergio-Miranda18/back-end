package com.easyplanning.demo.domain.service;

import com.easyplanning.demo.domain.dto.PaqueteDTO;
import com.easyplanning.demo.domain.dto.ServicioDTO;
import com.easyplanning.demo.domain.mapper.PaqueteMapper;
import com.easyplanning.demo.domain.mapper.ServicioMapper;
import com.easyplanning.demo.persistence.entity.Servicio;
import com.easyplanning.demo.persistence.repository.ServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ServicioService {
    @Autowired
    private final ServicioRepository servicioRepository;

    public ServicioDTO save(ServicioDTO servicioDTO) {
        servicioRepository.save(ServicioMapper.toEntity(servicioDTO));
        return servicioDTO;
    }

    public List<ServicioDTO> getAll() {
        return servicioRepository.findAll().stream().map(ServicioMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<ServicioDTO> findById(Long id) {
        return servicioRepository.findById(id).map(ServicioMapper::toDTO);
    }
}