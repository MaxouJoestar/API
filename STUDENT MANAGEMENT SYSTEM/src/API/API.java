import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@SpringBootApplication
@RestController
public class StudentManagementApi {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApi.class, args);
    }

    private Map<String, Student> students = new HashMap<>();
    private Map<String, Course> courses = new HashMap<>();

    @PostMapping("/students")
    public String createStudent(@RequestBody Student student) {
        students.put(student.getStudentID(), student);
        return "Student created successfully!";
    }

    @PostMapping("/courses")
    public String createCourse(@RequestBody Course course) {
        courses.put(course.getCourseCode(), course);
        return "Course created successfully!";
    }

    @PostMapping("/enrollments")
    public String enrollStudent(@RequestBody Enrollment enrollment) {
        Student student = students.get(enrollment.getStudentID());
        Course course = courses.get(enrollment.getCourseCode());
        if (student != null && course != null) {
            course.enrollStudent(student);
            return "Student enrolled successfully!";
        }
        return "Student or course not found!";
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable String id) {
        return students.get(id);
    }

    @GetMapping("/courses/{code}")
    public Course getCourse(@PathVariable String code) {
        return courses.get(code);
    }
}

class Student {
    private String name;
    private String studentID;
    private int age;

    public Student() {}

    public String getStudentID() { return studentID; }
    public void setStudentID(String studentID) { this.studentID = studentID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

class Course {
    private String courseName;
    private String courseCode;
    private List<Student> students = new ArrayList<>();

    public Course() {}

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void enrollStudent(Student student) { students.add(student); }
    public List<Student> getStudents() { return students; }
}

class Enrollment {
    private String studentID;
    private String courseCode;

    public Enrollment() {}

    public String getStudentID() { return studentID; }
    public void setStudentID(String studentID) { this.studentID = studentID; }
    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
}
