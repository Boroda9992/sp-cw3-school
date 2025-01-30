package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    Student findStudent(long id);
    Student editStudent(Student student, long id);
    void deleteStudent(long id);
    List<Student> findByAgeBetween(int min, int max);
    List<Student> findAllByFaculty(long facultyId);
}
