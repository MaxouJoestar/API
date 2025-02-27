package com.example.demo;

public class UndergraduateStudent extends Student {
    public UndergraduateStudent(String name, int age) {
        super(name, age);
    }

    @Override
    public double getAverageGrade() {
        // Specific implementation for undergraduate students
        return 3.0;
    }
}