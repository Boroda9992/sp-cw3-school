package ru.hogwarts.school.model;

import java.util.Objects;

public class Faculty {

    final long id;
    final String name;
    final String colour;

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
//set
    public long setId(long l) {
        return id;
    }

    public String setName() {
        return name;
    }

    public String setColour() {
        return colour;
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
