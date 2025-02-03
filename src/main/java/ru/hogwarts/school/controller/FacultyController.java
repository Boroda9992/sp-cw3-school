package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public Faculty getFacultyInfo(@PathVariable long id) {
        return facultyService.findFaculty(id);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }

    @PutMapping("{id}")
    public Faculty editFaculty(@RequestBody Faculty faculty, @PathVariable long id) {
        return facultyService.editFaculty(faculty, id);
    }

    @DeleteMapping("{id}")
    public Void deleteFaculty(@PathVariable long id) {
        return facultyService.deleteFaculty(id);
    }

    @GetMapping
    public List<Faculty> findByNameIgnoreCaseOrColourIgnoreCase(String name, String colour) {
        return facultyService.findByNameIgnoreCaseOrColourIgnoreCase(name, colour);
    }

    @GetMapping("/facultyByStudent")
    public Faculty findFacultyByStudent(long studentId) {
        return facultyService.facultyByStudentId(studentId);
    }

}
