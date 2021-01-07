package com.example.demo.business.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentDetailResponse {

  @Schema(
          description = "student",
          type = "String",
          example = "Student"
  )
  private final String data;

  @Schema(
          description = "students",
          type = "List<StudentResponse>"
  )
  private final List<StudentResponse> students;

}
