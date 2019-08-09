package com.teracode.school.service.common.dto.view;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gonzalo Conte
 */
public class StudentLastNameOrderViewDTO implements Serializable {
  private static final long serialVersionUID = 1947395127641727934L;

  @JsonProperty(value = "alpha")
  private String alpha;

  @JsonProperty(value = "first_name")
  private String firstName;

  @JsonProperty(value = "last_name")
  private String lastName;

  @JsonProperty(value = "id")
  private long id;

  public StudentLastNameOrderViewDTO() {
  }

  public StudentLastNameOrderViewDTO(String alpha, String firstName, String lastName, long id) {
    this.alpha = alpha;
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
  }

  public String getAlpha() {
    return alpha;
  }

  public void setAlpha(String alpha) {
    this.alpha = alpha;
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

