package com.example.demo.controller;

import com.example.demo.business.model.api.request.StudentRequest;
import com.example.demo.business.model.api.response.StudentDetailResponse;
import com.example.demo.business.model.api.response.StudentResponse;
import com.example.demo.business.model.business.Student;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * <b>Class:</b> StudentApiMapper.<br/>
 * @author RLR
 * @version 1.0.0
 */

@Component
class StudentApiMapper {

  /**
   * convert values from StudentRequest to Student.
   * @param request of type {@link StudentRequest}
   * @return {@link Student}
   */
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

  /**
   * convert values from Student to StudentResponse.
   * @param student of type {@link Student}
   * @return {@link StudentResponse}
   */
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

  /**
   * convert values from StudentResponses to StudentDetailResponses.
   * @param responses of type {@link List} {@link StudentResponse}
   * @return {@link StudentDetailResponse}
   */
  public StudentDetailResponse mapStudentDetailResponse(
          List<StudentResponse> responses) {

    return new StudentDetailResponse("Student", responses);
  }

}
