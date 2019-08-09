package com.teracode.school.service.api;

import java.util.*;

import com.teracode.school.service.common.dto.*;
import com.teracode.school.service.common.dto.view.ExpensesReportViewDTO;
import com.teracode.school.service.common.dto.view.StudentFrom19To21ViewDTO;
import com.teracode.school.service.common.request.CreateJanitorRequest;
import com.teracode.school.service.common.request.CreatePrincipalRequest;
import com.teracode.school.service.common.request.CreateStudentRequest;
import com.teracode.school.service.common.request.CreateTeacherRequest;
import com.teracode.school.service.common.dto.view.StudentEnrolledToSubjectViewDTO;
import com.teracode.school.service.common.dto.view.StudentLastNameOrderViewDTO;
import com.teracode.school.service.domain.model.Janitor;
import com.teracode.school.service.domain.model.Student;
import com.teracode.school.service.domain.model.Subject;
import com.teracode.school.service.domain.model.Teacher;
import com.teracode.school.service.domain.model.view.StudentFrom19To21View;
import com.teracode.school.service.domain.type.WorkingAreaType;

/**
 * @author Gonzalo Conte
 */
public interface SchoolService {

  /**
   * Creates a principal.
   *
   * @param request
   * @return {@link PrincipalDTO}
   */
  PrincipalDTO createPrincipal(CreatePrincipalRequest request);

  /**
   * @param id
   * @return {@link PrincipalDTO}
   */
  PrincipalDTO getPrincipal(long id);

  /**
   *
   * @return {@link ExpensesReportViewDTO}
   */
  ExpensesReportViewDTO getTotalExpenses();

  // === TEACHER

  TeacherDTO createTeacher(CreateTeacherRequest request);

  /**
   * @param id
   * @return {@link Teacher}
   */
  TeacherDTO getTeacher(long id);

  // === STUDENT

  /**
   * @param request
   * @return {@link Student}
   */
  StudentDTO createStudent(CreateStudentRequest request);

  /**
   * @param id
   * @return {@link Student}
   */
  StudentDTO getStudent(long id);

  /**
   * Point B
   *
   * @return a {@link LinkedHashMap} with the key as the student's first last name letter and a {@link LinkedList}
   * of {@link StudentLastNameOrderViewDTO} corresponding to that group.
   */
  LinkedHashMap<String, List<StudentLastNameOrderViewDTO>> getAllStudentsGroupByFirstLetterOfLastName();

  /**
   * Point C
   *
   * @return {@link Set} of {@link StudentEnrolledToSubjectViewDTO} that are registered in at least a {@link Subject}.
   * Users cannot be repeated.
   */
  Set<StudentEnrolledToSubjectViewDTO> getAllStudentsEnrolledToSubject();

  /**
   * @return {@link List} of {@link StudentFrom19To21View}  where age is between 19 and 21 years.
   */
  List<StudentFrom19To21ViewDTO> getAllStudentsBetween19And21Years();

  // === JANITOR

  /**
   * Creates a Janitor
   *
   * @param request
   * @return {@link Janitor}
   */
  JanitorDTO createJanitor(CreateJanitorRequest request);

  /**
   * @param id
   * @return {@link Janitor}
   */
  JanitorDTO getJanitor(long id);

  /**
   * Point E
   *
   * @param workingArea
   * @return {@link Set} of {@link String} containing full names of {@link Janitor} in a {@link WorkingAreaType}
   */
  Set<String> getJanitorsFullNameByWorkingArea(WorkingAreaType workingArea);
  // === SUBJECT

  /**
   * @param name
   * @return {@link Subject}
   */
  SubjectDTO createSubject(String name);

  /**
   * @param id
   * @return {@link Subject}
   */
  SubjectDTO getSubject(long id);

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
  void enrollStudentToSubject(long subjectId, long studentId);

}
