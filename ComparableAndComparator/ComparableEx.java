package ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements  Comparable<Student>{
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student that) {
        return this.age > that.age  ? 1:-1;
    }
}

public class ComparableEx {
    public static void main(String[] args) {

        List<Student> stud =new ArrayList<>();
        stud.add(new Student(21, "Arnav"));
        stud.add(new Student(28, "Ankit"));
        stud.add(new Student(27, "Rishi"));
        stud.add(new Student(24, "Aman"));

        Collections.sort(stud);
        System.out.println(stud);

    }
}
