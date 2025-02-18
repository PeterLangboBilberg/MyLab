package org.bilberg.langbo.peter.SpectacledPenguin_server.student;

import java.time.LocalDate;

public class Student {

    private long id;
    private String name;
    private String email;
    private Integer age;

    public Student(){

    }
    public Student(long id, String name, String email,  Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;

        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
