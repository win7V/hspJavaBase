package com.edu.map_;

import java.util.HashMap;
import java.util.Map;

public class MapExercise {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1, new Employee("jack", 18000, 1));
        map.put(2, new Employee("bob", 19000, 2));
        map.put(3, new Employee("jame", 8000, 3));

        System.out.println(map);

        for (Object entryObj :map.entrySet()) {
            Map.Entry entry = (Map.Entry) entryObj;
            Employee worker = (Employee)entry.getValue();
            if(worker.getSal() >= 18000) {
                System.out.println("ID:" + worker.getId() + " name:" +worker.getName() + " sal:" + worker.getSal());
            }
        }


    }
}
class Employee {
    private String name;
    private double sal;
    private int id;

    public Employee(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}
