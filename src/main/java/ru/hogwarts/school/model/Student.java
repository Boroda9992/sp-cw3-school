package ru.hogwarts.school.model;

import java.util.Objects;

public class Student {
    final long id;
    final String name;
    final int age;

    public Student(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
//get
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
//set
    public long setId(long l) {
        return id;
    }

    public String setName() {
        return name;
    }

    public int setAge() {
        return age;
    }
//equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && Objects.equals(name, student.name);
    }
//hash-code
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
//toString
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
