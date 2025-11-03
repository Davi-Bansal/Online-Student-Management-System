package com.courseapp.service;

import com.courseapp.model.Course;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private List<Course> courseList = new ArrayList<>();

    public CourseServiceImpl() {
        courseList.add(new Course(1, "Java Basics", "Intro to Java"));
        courseList.add(new Course(2, "Spring Boot", "Learn Spring Boot"));
    }

    @Override
    public List<Course> getAllCourses() {
        return courseList;
    }

    @Override
    public Course getCourseById(int id) {
        return courseList.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Course addCourse(Course course) {
        courseList.add(course);
        return course;
    }

    @Override
    public Course updateCourse(int id, Course course) {
        Course existing = getCourseById(id);
        if (existing != null) {
            existing.setName(course.getName());
            existing.setDescription(course.getDescription());
        }
        return existing;
    }

    @Override
    public void deleteCourse(int id) {
        courseList.removeIf(c -> c.getId() == id);
    }
}
