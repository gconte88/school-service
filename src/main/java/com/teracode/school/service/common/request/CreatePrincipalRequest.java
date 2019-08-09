package com.teracode.school.service.common.request;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gonzalo Conte
 */
public class CreatePrincipalRequest implements Serializable {
  private static final long serialVersionUID = 971597766643358358L;

  @JsonProperty(value = "first_name")
  private String firstName;

  @JsonProperty(value = "last_name")
  private String lastName;

  @JsonProperty(value = "salary")
  private BigDecimal salary;

  public CreatePrincipalRequest() {
  }

  public CreatePrincipalRequest(String firstName, String lastName, BigDecimal salary) {
    this.firstName = firstName;
    this.lastName = lastName;
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

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }
}
