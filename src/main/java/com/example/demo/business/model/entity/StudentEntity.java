package com.example.demo.business.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <b>Class:</b> StudentEntity.<br/>
 * @author RLR
 * @version 1.0.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
@Entity
@Table(name = "Student")
public class StudentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "gender", nullable = false, length = 1)
  private String gender;

  @Column(name = "firstName", nullable = false, length = 20)
  private String firstName;

  @Column(name = "middleName", nullable = false, length = 20)
  private String middleName;

  @Column(name = "lastName", nullable = false, length = 20)
  private String lastName;

  @Column(name = "dateOfBirth", nullable = false)
  private LocalDate dateOfBirth;

  @Column(name = "otherStudentDetail", nullable = false, length = 50)
  private String otherStudentDetail;

}
