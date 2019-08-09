package com.teracode.school.service.common.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gonzalo Conte
 */
public class JanitorDTO extends EmployeeDTO {
  private static final long serialVersionUID = 7067062874319668618L;

  @JsonProperty(value = "working_area")
  private String workingArea;

  public JanitorDTO() {
  }

  public JanitorDTO(long id, String firstName, String lastName, BigDecimal salary, String workingArea) {
    super(id, firstName, lastName, salary);
    this.workingArea = workingArea;
  }

  public String getWorkingArea() {
    return workingArea;
  }

  public void setWorkingArea(String workingArea) {
    this.workingArea = workingArea;
  }
}
