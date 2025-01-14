package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositories.FacultyRepository;

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
    public void shouldCorrectlyAddFaculty() {
        //given
        Faculty facultyToAdd = new Faculty(1, "Testendor", "000FFF");
        facultyService.addFaculty(facultyToAdd);
        //when
        Faculty facultyBeingAdded = new Faculty(facultyToAdd.getId(), facultyToAdd.getName(), facultyToAdd.getColour());

        //then
        Assertions.assertEquals(facultyToAdd, facultyBeingAdded);
    }

    @Test
    public void shouldCorrectlyFindFaculty() {
        //given
        Faculty facultyToFind = new Faculty(1, "Testendor", "000FFF");
        facultyService.addFaculty(facultyToFind);
        //when
        Faculty facultyBeingFound = new Faculty(facultyToFind.getId(), facultyToFind.getName(), facultyToFind.getColour());
        //then
        Assertions.assertEquals(facultyToFind, facultyBeingFound);
    }

    @Test
    public void shouldCorrectlyEditFaculty() {
        //given
        Faculty facultyToEdit = new Faculty(1, "Testendor", "000FFF");
        facultyService.addFaculty(facultyToEdit);
        facultyService.editFaculty(facultyToEdit, 2);
        //when
        Faculty studentBeingEdited = new Faculty(facultyToEdit.getId(), facultyToEdit.getName(), facultyToEdit.getColour());
        //then
        Assertions.assertEquals(facultyToEdit, studentBeingEdited);
    }

    @Test
    public void shouldCorrectlyDeleteFaculty() {
        //given
        Faculty facultyToDelete = new Faculty(1, "Testendor", "000FFF");
        facultyService.addFaculty(facultyToDelete);
        //when
        Faculty studentBeingDeleted = new Faculty(facultyToDelete.getId(), facultyToDelete.getName(), facultyToDelete.getColour());
        //then
        Assertions.assertEquals(facultyToDelete, studentBeingDeleted);
    }
}
