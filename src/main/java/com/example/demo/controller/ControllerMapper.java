package com.example.demo.controller;

import com.example.demo.business.model.api.request.StudentRequest;
import com.example.demo.business.model.api.response.StudentResponse;
import com.example.demo.business.model.business.Student;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * <b>Class:</b> StudentApiMapper.<br/>
 * @author RLR
 * @version 1.0.0
 */

@Component
class ControllerMapper {

  public Student mapStudent(StudentRequest request) {
    return Student.builder()
        .otherStudentDetail(request.getOtherStudentDetail())
        .middleName(request.getMiddleName())
        .lastName(request.getLastName())
        .gender(request.getGender())
        .firstName(request.getFirstName())
        .dateOfBirth(request.getDateOfBirth())
        .build();
  }

  public StudentResponse mapStudentResponse(Student student) {
    return StudentResponse.builder()
        .dateOfBirth(student.getDateOfBirth())
        .firstName(student.getFirstName())
        .gender(student.getGender())
        .lastName(student.getLastName())
        .middleName(student.getMiddleName())
        .otherStudentDetail(student.getOtherStudentDetail())
        .build();
  }

}
