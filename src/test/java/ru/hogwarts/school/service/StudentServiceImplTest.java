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

import java.util.Optional;

import static org.mockito.Mockito.times;

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
        Mockito.when(studentRepository.save(studentToAdd)).thenReturn(studentToAdd);
        //when
        Student result = studentService.addStudent(studentToAdd);
        //then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(studentToAdd, result);
        Mockito.verify(studentRepository, times(1)).save(studentToAdd);
    }

    @Test
    public void shouldCorrectlyFindStudent() {
        //given
        Student studentToFind = new Student(1, "Harry", 12);
        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(studentToFind));
        //when
        Student result = studentService.findStudent(studentToFind.getId());
        //then
        Assertions.assertEquals(studentToFind, result);
        Mockito.verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    public void shouldCorrectlyEditStudent() {
        //given
        Student studentToEdit = new Student(2L, "Harry", 12);

        Mockito.when(studentRepository.existsById(1L)).thenReturn(true);
        Mockito.when(studentRepository.save(studentToEdit)).thenReturn(studentToEdit);
        //when
        Student result = studentService.editStudent(studentToEdit, 1L);
        //then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2L, result.getId());
        Mockito.verify(studentRepository, times(1)).existsById(1L);
        Mockito.verify(studentRepository, times(1)).save(studentToEdit);
    }

    @Test
    public void testDeleteStudent() {
        //given
        Mockito.doNothing().when(studentRepository).deleteById(1L);
        //when
        studentService.deleteStudent(1L);
        //then
        Mockito.verify(studentRepository, times(1)).deleteById(1L);
    }


}
