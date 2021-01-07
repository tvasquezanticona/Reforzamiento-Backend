package com.example.demo.controller;

import com.example.demo.business.model.api.request.StudentRequest;
import com.example.demo.business.model.api.response.StudentResponse;
import com.example.demo.business.model.business.Student;
import com.example.demo.business.service.StudentService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * <b>Class:</b> StudentServiceImplTest<br/>
 * @author RLR
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

  @Mock
  private StudentService service;

  @Mock
  private StudentApiMapper mapper;

  @InjectMocks
  private StudentController controller;

  @Test
  void whenFindAllThenReturnStudents() {

    Mockito.when(service.findAll())
        .thenReturn(Observable.just(student()));

    Mockito.when(mapper.mapStudentResponse(Mockito.any()))
        .thenReturn(response());

    TestObserver<StudentResponse> testObserver = controller.findAll().test();
    testObserver.awaitTerminalEvent();
    testObserver.assertComplete().assertNoErrors();

  }

  @Test
  void whenSaveStudentThenReturnSuccessful() {

    Mockito.when(mapper.mapStudent(Mockito.any()))
            .thenReturn(student());

    Mockito.when(service.save(Mockito.any()))
        .thenReturn(Completable.complete());

    TestObserver<Void> testObserver = controller.save(request()).test();
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

  private StudentRequest request() {
    return StudentRequest.builder()
        .firstName("Jose")
        .lastName("Gonzales")
        .middleName("Luis")
        .gender("M")
        .dateOfBirth("01/01/2020")
        .otherStudentDetail("Backend")
        .build();
  }

  private StudentResponse response() {
    return StudentResponse.builder()
        .firstName("Jose")
        .lastName("Gonzales")
        .middleName("Luis")
        .gender("M")
        .dateOfBirth("01/01/2020")
        .otherStudentDetail("Backend")
        .build();
  }

}
