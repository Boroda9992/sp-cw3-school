package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
@Service
public class FacultyServiceImpl implements FacultyService{
    private final HashMap<Long, Faculty> faculties = new HashMap<>();
    private long count = 0;
    @Override
    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(count++);
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    @Override
    public Faculty findFaculty(long id) {
        return faculties.get(id);
    }

    @Override
    public Faculty editFaculty(Faculty faculty, long id) {
        if (faculties.containsKey(id)) {
            faculties.put(id, faculty);
            return faculty;
        }
        return null;
    }

    @Override
    public void deleteFaculty(long id) {
        faculties.remove(id);

    }
}
