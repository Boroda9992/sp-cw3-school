package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.FacultyRepository;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.HashMap;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    private final FacultyRepository facultyRepository;

    public StudentServiceImpl(StudentRepository studentRepository, FacultyRepository facultyRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudent(long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student editStudent(Student student, long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.save(student);
            return student;
        }
        return null;
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min,max);
    }

    @Override
    public List<Student> findAllByFaculty(long facultyId) {
        Faculty studentFaculty = facultyRepository.findById(facultyId).orElse(null);
        return studentRepository.findAllByFaculty(studentFaculty);
    }

}
