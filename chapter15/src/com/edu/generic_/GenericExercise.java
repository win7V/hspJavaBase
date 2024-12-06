package com.edu.generic_;

import java.util.HashSet;
import java.util.Iterator;

public class GenericExercise {

    public static void main(String[] args) {

        HashSet<Student> students = new HashSet<>();
        students.add(new Student("xiaoming", 18));
        students.add(new Student("xiaohua", 20));
        students.add(new Student("lili", 1));

        System.out.println(students);

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.name +  " " + student.age);
        }

        for (Student stu : students) {
            System.out.println(stu.name + "\t" + stu.age);

        }

    }
}

class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
