package com.chris.demo.lock;

public class User implements Comparable<User> {

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private Integer id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(User user) {
        return this.id.compareTo(user.getId());
    }
}
