package com.teracode.school.service.common.dto.view;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gonzalo Conte
 */
public class ExpensesReportViewDTO implements Serializable {
  private static final long serialVersionUID = 4532128985279953123L;

  @JsonProperty(value = "principal_salary")
  private BigDecimal principalSalary;

  @JsonProperty(value = "teachers_salary")
  private BigDecimal teachersSalary;

  @JsonProperty(value = "janitors_salary")
  private BigDecimal janitorsSalary;

  @JsonProperty(value = "total_expenses")
  private BigDecimal totalExpenses;

  @JsonProperty(value = "average_salary")
  private BigDecimal averageSalary;

  @JsonProperty(value = "maximum_salary")
  private BigDecimal maximumSalary;

  @JsonProperty(value = "minimum_salary")
  private BigDecimal minimumSalary;

  public ExpensesReportViewDTO() {
  }

  public ExpensesReportViewDTO(BigDecimal principalSalary, BigDecimal teachersSalary, BigDecimal janitorsSalary,
      BigDecimal totalExpenses, BigDecimal averageSalary, BigDecimal maximumSalary, BigDecimal minimumSalary) {
    this.principalSalary = principalSalary;
    this.teachersSalary = teachersSalary;
    this.janitorsSalary = janitorsSalary;
    this.totalExpenses = totalExpenses;
    this.averageSalary = averageSalary;
    this.maximumSalary = maximumSalary;
    this.minimumSalary = minimumSalary;
  }

  public BigDecimal getPrincipalSalary() {
    return principalSalary;
  }

  public void setPrincipalSalary(BigDecimal principalSalary) {
    this.principalSalary = principalSalary;
  }

  public BigDecimal getTeachersSalary() {
    return teachersSalary;
  }

  public void setTeachersSalary(BigDecimal teachersSalary) {
    this.teachersSalary = teachersSalary;
  }

  public BigDecimal getJanitorsSalary() {
    return janitorsSalary;
  }

  public void setJanitorsSalary(BigDecimal janitorsSalary) {
    this.janitorsSalary = janitorsSalary;
  }

  public BigDecimal getTotalExpenses() {
    return totalExpenses;
  }

  public void setTotalExpenses(BigDecimal totalExpenses) {
    this.totalExpenses = totalExpenses;
  }

  public BigDecimal getAverageSalary() {
    return averageSalary;
  }

  public void setAverageSalary(BigDecimal averageSalary) {
    this.averageSalary = averageSalary;
  }

  public BigDecimal getMaximumSalary() {
    return maximumSalary;
  }

  public void setMaximumSalary(BigDecimal maximumSalary) {
    this.maximumSalary = maximumSalary;
  }

  public BigDecimal getMinimumSalary() {
    return minimumSalary;
  }

  public void setMinimumSalary(BigDecimal minimumSalary) {
    this.minimumSalary = minimumSalary;
  }
}
