package com.teracode.school.service.common.dto.view;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gonzalo Conte
 */
public class StudentEnrolledToSubjectViewDTO implements Serializable {
  private static final long serialVersionUID = 1947395127641727934L;

  @JsonProperty(value = "subjects")
  private List<String> subjects;

  @JsonProperty(value = "first_name")
  private String firstName;

  @JsonProperty(value = "last_name")
  private String lastName;

  @JsonProperty(value = "id")
  private long id;

  public StudentEnrolledToSubjectViewDTO() {
  }

  public StudentEnrolledToSubjectViewDTO(List<String> subjects, String firstName, String lastName, long id) {
    this.subjects = subjects;
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
  }

  public List<String> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<String> subjects) {
    this.subjects = subjects;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}

