package com.teracode.school.service.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.teracode.school.service.domain.type.PersonDiscriminatorType;

/**
 * @author Gonzalo Conte
 */

@Entity
//@Table(name = "employee")
@DiscriminatorValue(value= PersonDiscriminatorType.Values.EMPLOYEE)
public class Employee extends Person {

  @Column(name = "salary")
  private BigDecimal salary;

  public Employee() {
    //used by hibernate
  }

  public Employee(String firstName, String lastName, BigDecimal salary) {
    super(firstName, lastName);
    this.salary = salary;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  @Override
  public Long getId() {
    return super.getId();
  }
}
