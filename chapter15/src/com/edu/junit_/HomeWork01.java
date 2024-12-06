package com.edu.junit_;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeWork01 {

    public static void main(String[] args) {
        // 创建 DAO 对象
        DAO<User> userDAO = new DAO<>();

        // 创建 User 对象
        User user1 = new User(1, 25, "Alice");
        User user2 = new User(2, 30, "Bob");
        User user3 = new User(3, 28, "Charlie");

        // 调用 save 方法
        userDAO.save("1", user1);
        userDAO.save("2", user2);
        userDAO.save("3", user3);

        // 调用 get 方法
        System.out.println("Get user with ID 2: " + userDAO.get("2").getName());
        System.out.println("===================================");

        // 调用 update 方法
        userDAO.update("2", new User(2, 31, "Bob Updated"));
        System.out.println("Updated user with ID 2: " + userDAO.get("2").getName());
        System.out.println("===================================");

        // 调用 list 方法
        System.out.println("List of all users:");
        for (User user : userDAO.list()) {
            System.out.println("ID: " + user.getId() + ", Age: " + user.getAge() + ", Name: " + user.getName());
        }
        System.out.println("===================================");

        // 调用 delete 方法
        userDAO.delete("1");
        System.out.println("After deleting user with ID 1:");
        for (User user : userDAO.list()) {
            System.out.println("ID: " + user.getId() + ", Age: " + user.getAge() + ", Name: " + user.getName());
        }
        System.out.println("===================================");
    }

    @Test
    public void testList() {
        DAO<User> dao = new DAO<>();
        dao.save("001", new User(1,10,"jack"));
        dao.save("002", new User(2,55,"jame"));
        dao.save("003", new User(3,7,"lili"));

        List<User> list = dao.list();
        System.out.println("list = " + list);
    }

}

class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id,T entity) {
        map.put(id, entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {//要返回 map 中存放的所有 T 类型对象，可以将 map 的值集合转换为一个 List 并返回
        return new ArrayList<>(map.values());
    }

    public void delete(String id) {
        map.remove(id);
    }
}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}