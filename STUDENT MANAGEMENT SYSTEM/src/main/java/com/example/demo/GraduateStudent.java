package com.example.demo;

public class GraduateStudent extends Student {
    public GraduateStudent(String name, int age) {
        super(name, age);
    }

    @Override
    public double getAverageGrade() {
        // Specific implementation for graduate students
        return 4.0;
    }
}