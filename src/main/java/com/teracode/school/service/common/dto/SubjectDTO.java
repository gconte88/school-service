package com.teracode.school.service.common.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gonzalo Conte
 */
public class SubjectDTO implements Serializable {
  private static final long serialVersionUID = -7570021182161331517L;

  @JsonProperty(value = "id")
  private long id;

  @JsonProperty(value = "name")
  private String name;

  public SubjectDTO() {
  }

  public SubjectDTO(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
