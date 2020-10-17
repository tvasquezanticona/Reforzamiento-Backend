package com.example.demo.business.model.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * <b>Class:</b> Student.<br/>
 * @author RLR
 * @version 1.0.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Student {

  private String gender;
  private String firstName;
  private String middleName;
  private String lastName;
  private String dateOfBirth;
  private String otherStudentDetail;
}
