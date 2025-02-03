package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty addFaculty(Faculty faculty);

    Faculty findFaculty(long id);

    Faculty editFaculty(Faculty faculty, long id);

    Void deleteFaculty(long id);

    List<Faculty> findByNameIgnoreCaseOrColourIgnoreCase(String name, String colour);

    Faculty facultyByStudentId(long studentId);
}
