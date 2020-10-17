package com.example.demo.business.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * <b>Class:</b> StudentRequest.<br/>
 * @author RLR
 * @version 1.0.0
 */

@AllArgsConstructor
@Builder
@Getter
public class StudentResponse {

  @Schema(
          description = "gender student",
          type = "String",
          example = "M"
  )
  private String gender;

  @Schema(
          description = "first name",
          type = "String",
          example = "Juan"
  )
  private String firstName;

  @Schema(
          description = "middle name",
          example = "Lopez",
          type = "String"
  )
  private String middleName;

  @Schema(
          description = "last name",
          example = "Martinez",
          type = "String"
  )
  private String lastName;

  @Schema(
          description = "date of birth",
          example = "01/01/2020",
          type = "String"
  )
  private LocalDate dateOfBirth;

  @Schema(
          description = "other student detail",
          example = "",
          type = "String"
  )
  private String otherStudentDetail;
}
