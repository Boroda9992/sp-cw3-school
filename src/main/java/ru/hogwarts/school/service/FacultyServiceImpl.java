package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.FacultyRepository;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    private final StudentRepository studentRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository, StudentRepository studentRepository) {
        this.facultyRepository = facultyRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }

    @Override
    public Faculty editFaculty(Faculty faculty, long id) {
        if (facultyRepository.existsById(id)) {
            facultyRepository.save(faculty);
            return faculty;
        }
        return null;
    }

    @Override
    public Void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
        return null;
    }

    @Override
    public List<Faculty> findByNameIgnoreCaseOrColourIgnoreCase(String name, String colour) {
        return facultyRepository.findByNameIgnoreCaseOrColourIgnoreCase(name, colour);
    }

    @Override
    public Faculty facultyByStudentId(long studentId) {
        return studentRepository.findById(studentId).map(Student::getFaculty).orElse(null);
    }

}
