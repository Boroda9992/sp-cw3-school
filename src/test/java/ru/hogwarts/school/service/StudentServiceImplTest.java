package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;
@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    public void clear() {
        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    public void shouldCorrectlyAddNewStudent() {
        //given
        Student studentToAdd = new Student(1, "Harry Potter", 12);
        //when
        Student studentBeingAdded = new Student(studentToAdd.getId(), studentToAdd.getName(), studentToAdd.getAge());
        //then
        Assertions.assertEquals(studentToAdd, studentBeingAdded);
    }

    //    public void shouldCorrectlyFindStudent(long id);
    @Test
    public void shouldCorrectlyFindStudent() {
        //given
        Student studentToFind = new Student(1, "Harry", 12);
        studentService.addStudent(studentToFind);
        //when

        Student studentBeingFound = new Student(studentToFind.getId(), studentToFind.getName(), studentToFind.setAge());
        //then
        Assertions.assertEquals(studentToFind, studentBeingFound);

    }

    @Test
    public void shouldCorrectlyEditStudent() {
        //given
        Student studentToEdit = new Student(1, "Harry", 12);
        studentService.addStudent(studentToEdit);
        studentService.editStudent(studentToEdit, 2);
        //when
        Student studentBeingEdited = new Student(studentToEdit.getId(), studentToEdit.getName(), studentToEdit.getAge());
        //then
        Assertions.assertEquals(studentToEdit, studentBeingEdited);
    }

    @Test
    public void shouldCorrectlyDeleteStudent() {
        //given
        Student studentToDelete = new Student(1, "Harry", 12);
        studentService.addStudent(studentToDelete);
        //when
        Student studentBeingDeleted = new Student(studentToDelete.getId(), studentToDelete.getName(), studentToDelete.getAge());
        //then
        Assertions.assertEquals(studentToDelete, studentBeingDeleted);
    }

}
