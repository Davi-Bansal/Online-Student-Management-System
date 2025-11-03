package com.courseapp.service;

import com.courseapp.model.Course;
import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();
    Course getCourseById(int id);
    Course addCourse(Course course);
    Course updateCourse(int id, Course course);
    void deleteCourse(int id);
}
