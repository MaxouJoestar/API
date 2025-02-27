package com.example.demo;

public class Enrollment{
    private String studentName;
    private String courseCode;
    private Student student;
    private Course course;

    
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public void register() {
        course.enrollStudent(student);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

}
