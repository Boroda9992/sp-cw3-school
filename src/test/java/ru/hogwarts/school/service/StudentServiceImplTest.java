package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    public void setup() {
        studentRepository = Mockito.mock(StudentRepository.class);
        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    public void shouldCorrectlyAddNewStudent() {
        //given
        Student studentToAdd = new Student(1, "Harry Potter", 12);
        //when
        Mockito.when(studentRepository.save(studentToAdd)).thenReturn(studentToAdd);
        Student result = studentService.addStudent(studentToAdd);
        //then
        Assertions.assertEquals(studentToAdd, result);
    }

    //    public void shouldCorrectlyFindStudent(long id);
//    @Test
//    public void shouldCorrectlyFindStudent() {
//        //given
//        Student studentToFind = new Student(1, "Harry", 12);
//        //when
//        Mockito.when(studentRepository.save(studentToFind)).thenReturn(studentToFind);
//        studentService.addStudent(studentToFind);
//        Student result = studentService.findStudent(studentToFind.getId());
//
//        //then
//        Assertions.assertEquals(studentToFind, result);
//
//    }

    @Test
    public void shouldCorrectlyEditStudent() {
        //given
        Student studentToEdit = new Student(1, "Harry", 12);
        long newId = studentToEdit.getId() + 1;
        //when
        Mockito.when(studentRepository.save(studentToEdit)).thenReturn(studentToEdit);
        Student result = studentService.editStudent(studentToEdit,newId);
        //then
        Assertions.assertEquals(studentToEdit, result);
    }

//    @Test
//    public void shouldCorrectlyDeleteStudent() {
//        //given
//        Student studentToDelete = new Student(1, "Harry", 12);
//        studentService.addStudent(studentToDelete);
//        //when
//
//        //then
//        Assertions.assertEquals(studentToDelete, studentBeingDeleted);
//    }


}
