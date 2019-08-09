package com.teracode.school.service.common.dto;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gonzalo Conte
 */
public class StudentDTO extends PersonDTO {
  private static final long serialVersionUID = 2598352072172627195L;

  @JsonProperty(value = "subjects")
  private Set<SubjectDTO> subjects;

  @JsonProperty(value = "birth_date")
  private Date birthDate;

  public StudentDTO(long id, String firstName, String lastName, Set<SubjectDTO> subjects, Date birthDate) {
    super(id, firstName, lastName);
    this.subjects = subjects;
    this.birthDate = birthDate;
  }

  public Set<SubjectDTO> getSubjects() {
    return subjects;
  }

  public void setSubjects(Set<SubjectDTO> subjects) {
    this.subjects = subjects;
  }

  public Date getBirthDate() {
    return birthDate;
  }
}
