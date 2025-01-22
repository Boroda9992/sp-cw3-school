package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.Optional;

import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class FacultyServiceImplTest {
    @Mock
    private FacultyRepository facultyRepository;
    @InjectMocks
    private FacultyServiceImpl facultyService;

    @BeforeEach
    public void clear() {
        facultyService = new FacultyServiceImpl(facultyRepository);
    }


    @Test
    public void shouldCorrectlyAddNewStudent() {
        //given
        Faculty facultyToAdd = new Faculty(1, "Testendor", "000FFF");
        Mockito.when(facultyRepository.save(facultyToAdd)).thenReturn(facultyToAdd);
        //when
        Faculty result = facultyService.addFaculty(facultyToAdd);
        //then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(facultyToAdd, result);
        Mockito.verify(facultyRepository, times(1)).save(facultyToAdd);
    }

    @Test
    public void shouldCorrectlyFindStudent() {
        //given
        Faculty facultyToFind = new Faculty(1, "Testendor", "000FFF");
        Mockito.when(facultyRepository.findById(1L)).thenReturn(Optional.of(facultyToFind));
        //when
        Faculty result = facultyService.findFaculty(facultyToFind.getId());
        //then
        Assertions.assertEquals(facultyToFind, result);
        Mockito.verify(facultyRepository, times(1)).findById(1L);
    }

    @Test
    public void shouldCorrectlyEditStudent() {
        //given
        Faculty facultyToEdit = new Faculty(2L, "Testendor", "000FFF");

        Mockito.when(facultyRepository.existsById(1L)).thenReturn(true);
        Mockito.when(facultyRepository.save(facultyToEdit)).thenReturn(facultyToEdit);
        //when
        Faculty result = facultyService.editFaculty(facultyToEdit, 1L);
        //then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2L, result.getId());
        Mockito.verify(facultyRepository, times(1)).existsById(1L);
        Mockito.verify(facultyRepository, times(1)).save(facultyToEdit);
    }

    @Test
    public void testDeleteStudent() {
        //given
        Mockito.doNothing().when(facultyRepository).deleteById(1L);
        //when
        facultyService.deleteFaculty(1L);
        //then
        Mockito.verify(facultyRepository, times(1)).deleteById(1L);
    }
}
