package com.devsuperior.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devsuperior.demo.dto.DepartmentDTO;
import com.devsuperior.demo.services.DepartmentService;

@Controller
@RequestMapping(value = "/departments") // Mudei de "/department" para "/departments" para corresponder ao teste
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // find all por List
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll() {
        List<DepartmentDTO> list = departmentService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
