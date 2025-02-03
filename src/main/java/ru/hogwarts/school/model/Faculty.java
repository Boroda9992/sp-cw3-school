package ru.hogwarts.school.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Faculty {

    @Id
    @GeneratedValue
    final long id;
    final String name;
    final String colour;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "faculty")
    private List<Student> students;


    public Faculty(long id, String name, String colour) {
        this.id = id;
        this.name = name;
        this.colour = colour;
    }

    //get
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public List<Student> getStudents() {
        return students;
    }

    //set
    public long setId(long id) {
        return id;
    }

    public String setName() {
        return name;
    }

    public String setColour() {
        return colour;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id == faculty.id && Objects.equals(name, faculty.name) && Objects.equals(colour, faculty.colour);
    }

    //hash-code
    @Override
    public int hashCode() {
        return Objects.hash(id, name, colour);
    }

    //toString
    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
