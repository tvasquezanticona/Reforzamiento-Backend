package com.example.demo.controller;

import com.example.demo.business.model.api.request.StudentRequest;
import com.example.demo.business.model.api.response.StudentDetailResponse;
import com.example.demo.business.model.api.response.StudentResponse;
import com.example.demo.business.service.StudentService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>Class:</b> StudentController.<br/>
 * @author RLR
 * @version 1.0.0
 */

@RestController
@RequestMapping(path = "${application.api.path}")
@AllArgsConstructor
class StudentController {

  private final StudentService service;

  private final StudentApiMapper mapper;

  @ApiResponses(value = {
          @ApiResponse(
                  responseCode = "201",
                  description = "Create Successful"
          ),
          @ApiResponse(
                  responseCode = "500",
                  description = "Error to Save"
          )
  })
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Completable save(@RequestBody @Valid StudentRequest request) {
    return Single.fromCallable(() -> mapper.mapStudent(request))
            .flatMapCompletable(service::save);
  }

  //  private Student mapStudent(StudentRequest request) {
  //    return Student.builder()
  //            .otherStudentDetail(request.getOtherStudentDetail())
  //            .middleName(request.getMiddleName())
  //            .lastName(request.getLastName())
  //            .gender(request.getGender())
  //            .firstName(request.getFirstName())
  //            .dateOfBirth(LocalDate.now())
  //            .build();
  //  }

  @ApiResponses(value = {
          @ApiResponse(responseCode = "200",
          description = "Show Students",
          content = @Content(array =
            @ArraySchema(schema =
              @Schema(implementation = StudentResponse.class))))
  })
  @GetMapping
  public Observable<StudentResponse> findAll() {
    return service.findAll()
            .map(mapper::mapStudentResponse);
  }

  @ApiResponses(value = {
          @ApiResponse(responseCode = "200",
                  description = "Show Students",
                  content = @Content(
                          schema = @Schema(implementation = StudentDetailResponse.class)))
  })
  @GetMapping(path = "/data")
  public Single<StudentDetailResponse> find() {
    return service.findAll()
            .map(mapper::mapStudentResponse)
            .toList()
            .map(mapper::mapStudentDetailResponse);
  }



  //  private StudentResponse mapStudentResponse(Student student) {
  //    return StudentResponse.builder()
  //            .dateOfBirth(student.getDateOfBirth())
  //            .firstName(student.getFirstName())
  //            .gender(student.getGender())
  //            .lastName(student.getLastName())
  //            .middleName(student.getMiddleName())
  //            .otherStudentDetail(student.getOtherStudentDetail())
  //            .build();
  //  }


}
