package com.teracode.school.service.common.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gonzalo Conte
 */
public class EmployeeDTO extends PersonDTO {

  private static final long serialVersionUID = -8446824742774217377L;

  @JsonProperty(value = "salary")
  private BigDecimal salary;

  public EmployeeDTO() {

  }

  public EmployeeDTO(long id, String firstName, String lastName, BigDecimal salary) {
    super(id, firstName, lastName);
    this.salary = salary;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }
}
