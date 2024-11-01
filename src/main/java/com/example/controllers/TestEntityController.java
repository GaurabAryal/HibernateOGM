package com.example.controllers;

import com.example.entities.TestEntity;
import com.example.repositories.TestEntityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestEntityController {

    private final TestEntityRepository testEntityRepository;

    public TestEntityController(TestEntityRepository testEntityRepository) {
        this.testEntityRepository = testEntityRepository;
    }

    @GetMapping
    public List<TestEntity> getAll() {
        return testEntityRepository.findAll();
    }
}
