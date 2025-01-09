package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Faculty;

public class FacultyServiceImplTest {

    private FacultyService facultyService;

    @BeforeEach
    public void clear() {
        facultyService = new FacultyServiceImpl();
    }

    @Test
    public void shouldCorrectlyAddFaculty() {
        //given
        Faculty facultyToAdd = new Faculty(1, "Testendor", "000FFF");
        //when
        Faculty facultyBeingAdded = facultyService.addFaculty(facultyToAdd);
        //then
        Assertions.assertEquals(facultyToAdd, facultyBeingAdded);
    }

    @Test
    public void shouldCorrectlyFindFaculty() {
        //given
        Faculty facultyToFind = new Faculty(1, "Testendor", "000FFF");
        facultyService.addFaculty(facultyToFind);
        //when

        Faculty studentBeingFound = new Faculty(facultyToFind.getId(), facultyToFind.getName(), facultyToFind.getColour());
        //then
        Assertions.assertEquals(facultyToFind, studentBeingFound);
    }

    @Test
    public void shouldCorrectlyEditFaculty() {
        //given
        Faculty studentToEdit = new Faculty(1, "Testendor", "000FFF");
        facultyService.addFaculty(studentToEdit);
        facultyService.editFaculty(studentToEdit, 2);
        //when
        Faculty studentBeingEdited = new Faculty(studentToEdit.getId(), studentToEdit.getName(), studentToEdit.getColour());
        //then
        Assertions.assertEquals(studentToEdit, studentBeingEdited);
    }

    @Test
    public void shouldCorrectlyDeleteFaculty() {
        //given
        Faculty studentToDelete = new Faculty(1, "Testendor", "000FFF");
        facultyService.addFaculty(studentToDelete);
        //when
        Faculty studentBeingDeleted = new Faculty(studentToDelete.getId(), studentToDelete.getName(), studentToDelete.getColour());
        //then
        Assertions.assertEquals(studentToDelete, studentBeingDeleted);
    }
}
