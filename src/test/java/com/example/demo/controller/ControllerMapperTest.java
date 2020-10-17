package com.example.demo.controller;

import com.example.demo.business.model.api.request.StudentRequest;
import com.example.demo.business.model.api.response.StudentResponse;
import com.example.demo.business.model.business.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * <b>Class:</b> StudentMapperTest<br/>
 * @author RLR
 * @version 1.0.0
 */
class ControllerMapperTest {

  private ControllerMapper controllerMapper;

  @BeforeEach
  void init() {
    controllerMapper = new ControllerMapper();
  }

  @Test
  void whenMapperEntityThenReturnStudent() {
    StudentRequest request = studentRequest();

    Student student = controllerMapper.mapStudent(request);

    Student studentExpected = student();

    Assertions.assertEquals(studentExpected.getFirstName(), student.getFirstName());
    Assertions.assertEquals(studentExpected.getGender(), student.getGender());
    Assertions.assertEquals(studentExpected.getLastName(), student.getLastName());
    Assertions.assertEquals(studentExpected.getMiddleName(), student.getMiddleName());
    Assertions.assertEquals(studentExpected.getOtherStudentDetail(), student.getOtherStudentDetail());
    Assertions.assertEquals(studentExpected.getDateOfBirth(), student.getDateOfBirth());
  }

  @Test
  void whenMapperStudentThenReturnEntity() {
    Student student = student();

    StudentResponse response = controllerMapper.mapStudentResponse(student);

    StudentResponse studentExpected = studentResponse();

    Assertions.assertEquals(studentExpected.getFirstName(), response.getFirstName());
    Assertions.assertEquals(studentExpected.getGender(), response.getGender());
    Assertions.assertEquals(studentExpected.getLastName(), response.getLastName());
    Assertions.assertEquals(studentExpected.getMiddleName(), response.getMiddleName());
    Assertions.assertEquals(studentExpected.getOtherStudentDetail(), response.getOtherStudentDetail());
    Assertions.assertEquals(studentExpected.getDateOfBirth(), response.getDateOfBirth());
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

  private StudentRequest studentRequest() {
    return StudentRequest.builder()
            .firstName("Jose")
            .lastName("Gonzales")
            .middleName("Luis")
            .gender("M")
            .otherStudentDetail("Backend")
            .dateOfBirth("01/01/2020")
            .build();
  }

  private StudentResponse studentResponse() {
    return StudentResponse.builder()
            .firstName("Jose")
            .lastName("Gonzales")
            .middleName("Luis")
            .gender("M")
            .otherStudentDetail("Backend")
            .dateOfBirth("01/01/2020")
            .build();
  }
}
