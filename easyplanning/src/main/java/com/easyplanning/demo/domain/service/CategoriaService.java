package com.easyplanning.demo.domain.service;

import com.easyplanning.demo.domain.dto.CategoriaDTO;
import com.easyplanning.demo.domain.mapper.CategoriaMapper;
import com.easyplanning.demo.persistence.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
@Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaDTO save(CategoriaDTO categoryDTO) {
        categoriaRepository.save(CategoriaMapper.toEntity(categoryDTO));
        return categoryDTO;
    }

    public List<CategoriaDTO> getAll() {
        return categoriaRepository.findAll().stream().map(CategoriaMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<CategoriaDTO> findById(Long id) {
        return categoriaRepository.findById(id).map(CategoriaMapper::toDTO);
    }

}
