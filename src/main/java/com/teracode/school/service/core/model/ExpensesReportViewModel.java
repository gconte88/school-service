package com.teracode.school.service.core.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * //TODO: Its only used for serialization, find a better way to save a view in redis!!!
 * @author Gonzalo Conte
 */
public class ExpensesReportViewModel implements Serializable{

  private static final long serialVersionUID = -3356618074626154010L;

  private BigDecimal principalSalary;

  private BigDecimal teachersSalary;

  private BigDecimal janitorsSalary;

  private BigDecimal totalExpenses;

  private BigDecimal averageSalary;

  private BigDecimal maximumSalary;

  private BigDecimal minimumSalary;

  public ExpensesReportViewModel() {
  }

  public ExpensesReportViewModel(BigDecimal principalSalary, BigDecimal teachersSalary, BigDecimal janitorsSalary,
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
