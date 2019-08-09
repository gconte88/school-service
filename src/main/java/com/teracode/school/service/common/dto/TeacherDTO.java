package com.teracode.school.service.common.dto;

import java.math.BigDecimal;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gonzalo Conte
 */
public class TeacherDTO extends EmployeeDTO {

  private static final long serialVersionUID = 7495680955094244671L;

  @JsonProperty(value = "subjects")
  private Set<SubjectDTO> subjects;

  public TeacherDTO() {

  }

  public TeacherDTO(long id, String firstName, String lastName, BigDecimal salary, Set<SubjectDTO> subjects) {
    super(id, firstName, lastName, salary);
    this.subjects = subjects;
  }

  public Set<SubjectDTO> getSubjects() {
    return subjects;
  }

  public void setSubjects(Set<SubjectDTO> subjects) {
    this.subjects = subjects;
  }
}
