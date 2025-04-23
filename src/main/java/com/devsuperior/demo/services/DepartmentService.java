package com.devsuperior.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.demo.dto.DepartmentDTO;
import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.repositories.DepartmentRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    // busca paginada
   @Transactional(readOnly = true)
    public List<DepartmentDTO> findAll() {
        List<Department> list = departmentRepository.findAll(Sort.by("name"));
        return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
    }
}