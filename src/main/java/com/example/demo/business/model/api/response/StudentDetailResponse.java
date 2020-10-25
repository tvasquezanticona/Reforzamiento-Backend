package com.example.demo.business.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class StudentDetailResponse {

  @Schema(
          description = "student",
          type = "String",
          example = "Student"
  )
  private String data;

  @Schema(
          description = "students",
          type = "List<StudentResponse>"
  )
  private List<StudentResponse> students;

}
