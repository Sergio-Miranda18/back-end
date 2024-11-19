package com.easyplanning.demo.domain.service;


import com.easyplanning.demo.domain.dto.LocalDTO;
import com.easyplanning.demo.domain.mapper.LocalMapper;
import com.easyplanning.demo.persistence.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class LocalService {
@Autowired

    private LocalRepository localRepository;

    public LocalDTO save(LocalDTO localDTO) {
        localRepository.save(LocalMapper.toEntity(localDTO));
        return localDTO;
    }

    public List<LocalDTO> getAll() {
        return localRepository.findAll().stream().map(LocalMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<LocalDTO> findById(Long idLocal) {
        return localRepository.findById(idLocal).map(LocalMapper::toDTO);
    }

}
