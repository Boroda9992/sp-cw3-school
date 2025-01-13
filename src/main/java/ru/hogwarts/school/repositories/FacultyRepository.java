package ru.hogwarts.school.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
