package com.teracode.school.service.domain.model;

import java.math.BigDecimal;

import javax.persistence.*;

import com.teracode.school.service.domain.type.PersonDiscriminatorType;
import com.teracode.school.service.domain.type.WorkingAreaType;

/**
 * @author Gonzalo Conte
 */
@Entity
//@Table(name = "janitor")
@DiscriminatorValue(value= PersonDiscriminatorType.Values.JANITOR)
public class Janitor extends Employee {

  @Column(name = "working_area")
  @Enumerated(EnumType.STRING)
  private WorkingAreaType workingArea;

  public Janitor() {
    //used by hibernate
  }

  public Janitor(String firstName, String lastName, BigDecimal salary, WorkingAreaType workingArea) {
    super(firstName, lastName, salary);
    this.workingArea = workingArea;
  }

  public WorkingAreaType getWorkingArea() {
    return workingArea;
  }

  public void setWorkingArea(WorkingAreaType workingArea) {
    this.workingArea = workingArea;
  }

  @Override
  public Long getId() {
    return super.getId();
  }
}
