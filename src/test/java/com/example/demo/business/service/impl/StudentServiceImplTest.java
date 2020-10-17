package com.example.demo.business.service.impl;

import com.example.demo.business.dao.StudentDao;
import com.example.demo.business.model.business.Student;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

/**
 * <b>Class:</b> StudentServiceImplTest<br/>
 * @author RLR
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

  @Mock
  private StudentDao dao;

  @InjectMocks
  private StudentServiceImpl service;

  @Test
  void whenFindAllThenReturnStudents() {

    Mockito.when(dao.findAll())
            .thenReturn(Observable.just(student()));

    TestObserver<Student> testObserver = service.findAll().test();
    testObserver.awaitTerminalEvent();
    testObserver.assertComplete().assertNoErrors();
  }

  @Test
  void whenSaveStudentThenReturnSuccessful() {

    Mockito.when(dao.save(Mockito.any()))
            .thenReturn(Completable.complete());

    TestObserver<Void> testObserver = service.save(student()).test();
    testObserver.awaitTerminalEvent();
    testObserver.assertComplete().assertNoErrors();
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
}
