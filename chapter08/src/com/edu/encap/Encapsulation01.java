package com.edu.encap;

public class Encapsulation01 {
    public static void main(String[] args) {
        Person worker = new Person();
        worker.setName("jack");
        worker.setAge(30);
        worker.setSalary(3000.0);
        System.out.println(worker.info());

        Person smith = new Person("smith", 2000, 30000);
        System.out.println(smith.info());
    }
}
/*
那么在java中如何实现这种类似的控制呢?
请大家看一个小程序(com.hspedu.encap: Encapsulation01.java),
不能随便查看人的年龄,工资等隐私，并对设置的年龄进行合理的验证。年龄合理就设置，否则给默认
年龄, 必须在 1-120, 年龄， 工资不能直接查看 ， name的长度在 2-6字符 之间

 */

class Person {
    public String name;
    private int age;
    private double salary;

    //构造器

    //无参构造器
    public Person() {
    }

    //三属性构造器
    public Person(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;

        //可以把set方法写在构造器  这样仍然可以使用
        setName(name);//等价于this.setName(name)
        setAge(age);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if(name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println("name length Error");
            this.name = "moren";
        }

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age >= 1 && age <=120) {
            this.age = age;
        } else {
            System.out.println("age Error");
            this.age = 18;//default age
        }

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //写一个方法  返回属性信息
    public String info() {
        return "信息为 name = " + name + " age = " + age + " salary = " + salary;
    }
}