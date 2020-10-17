package com.example.demo.business.dao.impl;

import com.example.demo.business.dao.repository.StudentRepository;
import com.example.demo.business.model.business.Student;
import com.example.demo.business.model.entity.StudentEntity;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * <b>Class:</b> StudentDaoImplTest<br/>
 * @author RLR
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class StudentDaoImplTest {

  @Mock
  private StudentRepository repository;

  @Mock
  private StudentMapper mapper;

  @InjectMocks
  private StudentDaoImpl dao;

  @Test
  void whenFindAllThenReturnStudents() {

    Mockito.when(repository.findAll())
            .thenReturn(Arrays.asList(studentEntity()));

    Mockito.when(mapper.mapStudent(Mockito.any()))
            .thenReturn(student());

    TestObserver<Student> testObserver = dao.findAll().test();
    testObserver.awaitTerminalEvent();
    testObserver.assertComplete().assertNoErrors();
  }

  @Test
  void whenSaveStudentThenReturnSuccessful() {

    Mockito.when(mapper.mapStudentEntity(Mockito.any()))
            .thenReturn(studentEntity());

    Mockito.when(repository.save(Mockito.any()))
            .thenReturn(Completable.complete());

    TestObserver<Void> testObserver = dao.save(student()).test();
    testObserver.awaitTerminalEvent();
  }

  private Student student() {
    return Student.builder()
            .firstName("Jose")
            .lastName("Gonzales")
            .middleName("Luis")
            .gender("M")
            .otherStudentDetail("Backend")
            .dateOfBirth("01/01/2020")
            .build();
  }

  private StudentEntity studentEntity() {
    return StudentEntity.builder()
            .firstName("Jose")
            .lastName("Gonzales")
            .middleName("Luis")
            .gender("M")
            .otherStudentDetail("Backend")
            .dateOfBirth("01/01/2020")
            .build();
  }
}
