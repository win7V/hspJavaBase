//package com.edu.set_;
//
//import java.util.HashSet;
//import java.util.Objects;
//
//public class HashSetExercise01 {
//
//    public static void main(String[] args) {
//        HashSet set = new HashSet();
//        set.add(new Employee("xiaoming",18));
//        set.add(new Employee("xiaoli",19));
//        set.add(new Employee("xiaoming",18));
//
//        System.out.println(set);
//
//        for (Object o :set) {
//            System.out.println(o);
//        }
//
//    }
//}
//
//class Employee {
//    private String name;
//    private int age;
//
//    public Employee(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//
//    //如果name和age相同  返回相同的hashcode
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return age == employee.age &&
//                Objects.equals(name, employee.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }
//}
