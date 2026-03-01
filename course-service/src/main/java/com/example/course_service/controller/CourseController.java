package com.example.course_service.controller;

import com.example.course_service.entity.Course;
import com.example.course_service.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository repository;

    @GetMapping
    public List<Course> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return repository.save(course);
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}