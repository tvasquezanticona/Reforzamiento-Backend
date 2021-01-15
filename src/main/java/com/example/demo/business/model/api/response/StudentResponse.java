package com.example.demo.business.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * <b>Class:</b> StudentRequest.<br/>
 * @author RLR
 * @version 1.0.0
 */

@NoArgsConstructor
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
  private String dateOfBirth;

  @Schema(
          description = "other student detail",
          example = "",
          type = "String"
  )
  private String otherStudentDetail;
}
