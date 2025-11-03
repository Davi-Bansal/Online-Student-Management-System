package com.courseapp.controller;

import com.courseapp.model.Course;
import com.courseapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return "Course removed with id " + id;
    }
}
