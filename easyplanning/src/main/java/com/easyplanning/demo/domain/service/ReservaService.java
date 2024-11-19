package com.easyplanning.demo.domain.service;

import com.easyplanning.demo.domain.dto.ReservaDTO;
import com.easyplanning.demo.domain.mapper.ReservaMapper;
import com.easyplanning.demo.persistence.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReservaService {
    @Autowired
    private final ReservaRepository reservaRepository;

    public ReservaDTO save(ReservaDTO reservaDTO) {
        reservaRepository.save(ReservaMapper.toEntity(reservaDTO));
        return reservaDTO;
    }

    public List<ReservaDTO> getAll() {
        return reservaRepository.findAll().stream().map(ReservaMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<ReservaDTO> findById(String id) {
        return reservaRepository.findById(id).map(ReservaMapper::toDTO);
    }
}
