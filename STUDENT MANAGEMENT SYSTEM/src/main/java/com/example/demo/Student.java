import java.util.ArrayList;
import java.util.List;

public class Student {  
    private final String studentID;
    private List<Double> grades;
    private int age;
    private String name;

    public Student(String name, int age, String studentID) {
        this.studentID = studentID;
        this.grades = new ArrayList<>();
        this.age = age;
        this.name = name;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        return grades.stream().mapToDouble(g -> g).average().orElse(0);
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}