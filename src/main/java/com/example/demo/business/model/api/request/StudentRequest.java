package com.example.demo.business.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>Class:</b> StudentRequest.<br/>
 * @author RLR
 * @version 1.0.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class StudentRequest {

  private static final String ONLY_LETTER = "[a-zA-Z]*";
  private static final String REGEXP_GENDER = "(M|F)";
  
  @Schema(
          description = "gender student",
          type = "String",
          pattern = REGEXP_GENDER,
          example = "M",
          required = true
  )
  @NotBlank
  @Pattern(regexp = REGEXP_GENDER)
  private String gender;

  @Schema(
          description = "first name",
          type = "String",
          pattern = REGEXP_GENDER,
          example = "Juan",
          required = true
  )
  @NotBlank
  @Pattern(regexp = ONLY_LETTER)
  @Size(min = 1, max = 20)
  private String firstName;

  @Schema(
          description = "middle name",
          type = "String",
          pattern = REGEXP_GENDER,
          example = "Lopez",
          required = true
  )
  @NotBlank
  @Pattern(regexp = ONLY_LETTER)
  @Size(min = 1, max = 20)
  private String middleName;

  @Schema(
          description = "last name",
          type = "String",
          pattern = REGEXP_GENDER,
          example = "Martinez",
          required = true
  )
  @NotBlank
  @Pattern(regexp = ONLY_LETTER)
  @Size(min = 1, max = 20)
  private String lastName;

  @Schema(
          description = "date of birth",
          type = "String",
          pattern = "[0-9]{2}/[0-9]{2}/[1-9]{4}",
          example = "01/01/2020",
          required = true
  )
  @NotBlank
  @Pattern(regexp = "[0-9]{2}/[0-9]{2}/[0-9]{4}")
  @Size(min = 1, max = 10)
  private String dateOfBirth;

  @Schema(
          description = "other student detail",
          type = "String",
          pattern = "[0-9]{2}/[0-9]{2}/[1-9]{4}",
          example = "",
          required = true
  )
  @NotBlank
  @Pattern(regexp = ONLY_LETTER)
  @Size(min = 1, max = 50)
  private String otherStudentDetail;

}
