package com.easyplanning.demo.domain.service;


import com.easyplanning.demo.domain.dto.PaqueteDTO;
import com.easyplanning.demo.domain.mapper.PaqueteMapper;
import com.easyplanning.demo.persistence.repository.PaqueteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PaqueteService {
    @Autowired
    private final PaqueteRepository paqueteRepository;

    public PaqueteDTO save(PaqueteDTO paqueteDTO) {
        paqueteRepository.save(PaqueteMapper.toEntity(paqueteDTO));
        return paqueteDTO;
    }

    public List<PaqueteDTO> getAll() {
        return paqueteRepository.findAll().stream().map(PaqueteMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<PaqueteDTO> findById(Long id) {
        return paqueteRepository.findById(id).map(PaqueteMapper::toDTO);
    }

}
