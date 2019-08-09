package com.teracode.school.service.common.request;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gonzalo Conte
 */
public class CreateJanitorRequest implements Serializable {
  private static final long serialVersionUID = -233528365085064479L;

  @JsonProperty(value = "first_name")
  private String firstName;

  @JsonProperty(value = "last_name")
  private String lastName;

  @JsonProperty(value = "working_area")
  private String workingArea;

  @JsonProperty(value = "salary")
  private BigDecimal salary;

  public CreateJanitorRequest() {
  }

  public CreateJanitorRequest(String firstName, String lastName, String workingArea, BigDecimal salary) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.workingArea = workingArea;
    this.salary = salary;
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

  public String getWorkingArea() {
    return workingArea;
  }

  public void setWorkingArea(String workingArea) {
    this.workingArea = workingArea;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }
}
