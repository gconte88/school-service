package com.teracode.school.service.core;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.teracode.school.service.core.model.ExpensesReportViewModel;
import com.teracode.school.service.domain.model.*;
import com.teracode.school.service.domain.model.view.ExpensesReportView;
import com.teracode.school.service.domain.model.view.StudentEnrolledToSubjectView;
import com.teracode.school.service.domain.model.view.StudentFrom19To21View;
import com.teracode.school.service.domain.model.view.StudentLastNameOrderView;
import com.teracode.school.service.domain.type.WorkingAreaType;


/**
 * @author Gonzalo Conte
 */
public interface SchoolBusinessService {

  // === PRINCIPAL

  /**
   * Creates a principal.
   *
   * @param firstName
   * @param lastName
   * @param salary
   * @return {@link Principal}
   */
  Principal createPrincipal(String firstName, String lastName, BigDecimal salary);

  /**
   * @param id
   * @return {@link Principal}
   */
  Principal getPrincipal(long id);

  /**
   * @return The expenses/salary totals of the Employees of the school
   */
  ExpensesReportViewModel getExpenses();

  // === TEACHER

  Teacher createTeacher(String firstName, String lastName, BigDecimal salary);

  /**
   * @param id
   * @return {@link Teacher}
   */
  Teacher getTeacher(long id);

  // === STUDENT

  /**
   * @param firstName
   * @param lastName
   * @param birthDate
   * @return {@link Student}
   */
  Student createStudent(String firstName, String lastName, Date birthDate);

  /**
   * @param id
   * @return {@link Student}
   */
  Student getStudent(long id);

  /**
   * Point B
   *
   * @return a {@link LinkedList} of {@link StudentLastNameOrderView}
   * corresponding to that group.
   */
  LinkedList<StudentLastNameOrderView> getAllStudentsGroupByFirstLetterOfLastName();

  /**
   * Point C
   *
   * @return {@link List} of {@link Student} that are registered in at least a {@link Subject}. Cannot be repeated.
   */
  List<StudentEnrolledToSubjectView> getAllStudentsEnrolledToSubject();

  /**
   * Point G
   *
   * @return {@link List} of {@link StudentFrom19To21View} where age is between 19 and 21 years.
   */
  List<StudentFrom19To21View> getAllStudentsBetween19And21Years();

  // === JANITOR

  /**
   * Creates a Janitor
   *
   * @param firstName
   * @param lastName
   * @param salary
   * @param workingArea
   * @return {@link Janitor}
   */
  Janitor createJanitor(String firstName, String lastName, BigDecimal salary, WorkingAreaType workingArea);

  /**
   * @param id
   * @return {@link Janitor}
   */
  Janitor getJanitor(long id);

  /**
   * Point E
   *
   * @param workingArea
   * @return {@link Set} of {@link String} containing full names of {@link Janitor} in a {@link WorkingAreaType}
   */
  Set<String> getJanitorsWorkingInArea(WorkingAreaType workingArea);
  // === SUBJECT

  /**
   * @param name
   * @return {@link Subject}
   */
  Subject createSubject(String name);

  /**
   * @param id
   * @return {@link Subject}
   */
  Subject getSubject(long id);

  /**
   * Assigns a {@link Subject} to a {@link Teacher}
   *
   * @param subjectId
   * @param teacherId
   */
  void assignSubjectToTeacher(long subjectId, long teacherId);

  /**
   * Inscribes a {@link Student} into a {@link Subject}
   *
   * @param subjectId
   * @param studentId
   */
  void enrollStudentInSubject(long subjectId, long studentId);

}
