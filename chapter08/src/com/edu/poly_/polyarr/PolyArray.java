package com.edu.poly_.polyarr;

public class PolyArray {

    public static void main(String[] args) {
        Person[] people = new Person[5];

        people[0] = new Person("a", 11);
        people[1] = new Student("b", 7, 85);
        people[2] = new Student("c", 12, 66.6);
        people[3] = new Teacher("d", 25, 3000);
        people[4] = new Teacher("e", 34, 4300);

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i].say());

            if(people[i] instanceof Student) { //判断people[i]运行类型是否是Student
                Student person1 = (Student)people[i];
                person1.learn();
            }

            if(people[i] instanceof Teacher) { //判断people[i]运行类型是否是Teacher
                ((Teacher)people[i]).teach();

            }
        }


    }
}
