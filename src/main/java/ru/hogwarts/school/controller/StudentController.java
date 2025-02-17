package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("{id}")
    public Student getStudentInfo(@PathVariable long id) {
        return studentService.findStudent(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("{id}")
    public Student editStudent(@RequestBody Student student, @PathVariable long id) {
        return studentService.editStudent(student, id);
    }

    @DeleteMapping("{id}")
    public Void deleteStudent(@PathVariable long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping()
    public List<Student> findByAgeBetween(int min, int max) {
        return studentService.findByAgeBetween(min, max);
    }

    ;

    @GetMapping("/studentlist")
    public List<Student> findAllByFaculty(Long facultyId) {
        return studentService.findAllByFaculty(facultyId);
    }
}
