package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api")
public class API {
    
    private final List<Student> students = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courses;
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        courses.add(course);
        return course;
    }

    @PostMapping("/enrollments")
    public String enrollStudent(@RequestBody Enrollment request) {
        Optional<Student> studentOpt = students.stream()
            .filter(student -> student.getName().equals(request.getStudentName()))
            .findFirst();
        Optional<Course> courseOpt = courses.stream()
            .filter(course -> course.getCourseCode().equals(request.getCourseCode()))
            .findFirst();

        if (studentOpt.isPresent() && courseOpt.isPresent()) {
            Enrollment enrollment = new Enrollment(studentOpt.get(), courseOpt.get());
            enrollment.register();
            return "Student enrolled successfully";
        } else {
            return "Student or Course not found";
        }
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable String id) {
        return students.stream()
            .filter(student -> student.getName().equals(id))
            .findFirst()
            .orElse(null);
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable String id) {
        return courses.stream()
            .filter(course -> course.getCourseCode().equals(id))
            .findFirst()
            .orElse(null);
    }
}