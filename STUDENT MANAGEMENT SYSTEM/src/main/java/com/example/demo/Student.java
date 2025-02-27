package com.example.demo;

public class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public double getAverageGrade() {
        // Default implementation
        return 0.0;
    }
}