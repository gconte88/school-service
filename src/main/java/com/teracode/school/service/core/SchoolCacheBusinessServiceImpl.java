package com.teracode.school.service.core;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import com.teracode.school.service.core.model.ExpensesReportViewModel;
import com.teracode.school.service.domain.model.*;
import com.teracode.school.service.domain.model.view.StudentEnrolledToSubjectView;
import com.teracode.school.service.domain.model.view.StudentFrom19To21View;
import com.teracode.school.service.domain.model.view.StudentLastNameOrderView;
import com.teracode.school.service.domain.type.WorkingAreaType;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Gonzalo Conte
 */
@Service("SchoolCacheBusinessServiceImpl")
public class SchoolCacheBusinessServiceImpl implements SchoolBusinessService {

  @Resource(name = "SchoolBusinessServiceImpl")
  private SchoolBusinessService schoolBusinessService;


  @CacheEvict(cacheNames = "expenses", allEntries = true)
  @Override
  public Principal createPrincipal(String firstName, String lastName, BigDecimal salary) {
    return schoolBusinessService.createPrincipal(firstName, lastName, salary);
  }

  @Override
  public Principal getPrincipal(long id) {
    return schoolBusinessService.getPrincipal(id);
  }

  @Cacheable(cacheNames = "expenses", key = "#root.methodName")
  @Override
  public ExpensesReportViewModel getExpenses() {
    return schoolBusinessService.getExpenses();
  }

  @CacheEvict(cacheNames = "expenses", allEntries = true)
  @Override
  public Teacher createTeacher(String firstName, String lastName, BigDecimal salary) {
    return schoolBusinessService.createTeacher(firstName, lastName, salary);
  }

  @Override
  public Teacher getTeacher(long id) {
    return schoolBusinessService.getTeacher(id);
  }

  @CacheEvict(cacheNames = "expenses", allEntries = true)
  @Override
  public Student createStudent(String firstName, String lastName, Date birthDate) {
    return schoolBusinessService.createStudent(firstName, lastName, birthDate);
  }

  @Override
  public Student getStudent(long id) {
    return schoolBusinessService.getStudent(id);
  }

  @Override
  public List<StudentLastNameOrderView> getAllStudentsGroupByFirstLetterOfLastName() {
    return schoolBusinessService.getAllStudentsGroupByFirstLetterOfLastName();
  }

  @Override
  public List<StudentEnrolledToSubjectView> getAllStudentsEnrolledToSubject() {
    return schoolBusinessService.getAllStudentsEnrolledToSubject();
  }

  @Override
  public List<StudentFrom19To21View> getAllStudentsBetween19And21Years() {
    return schoolBusinessService.getAllStudentsBetween19And21Years();
  }

  @CacheEvict(cacheNames = "expenses", allEntries = true)
  @Override
  public Janitor createJanitor(String firstName, String lastName, BigDecimal salary, WorkingAreaType workingArea) {
    return schoolBusinessService.createJanitor(firstName, lastName, salary, workingArea);
  }

  @Override
  public Janitor getJanitor(long id) {
    return schoolBusinessService.getJanitor(id);
  }

  @Override
  public Set<String> getJanitorsWorkingInArea(WorkingAreaType workingArea) {
    return schoolBusinessService.getJanitorsWorkingInArea(workingArea);
  }

  @Override
  public Subject createSubject(String name) {
    return schoolBusinessService.createSubject(name);
  }

  @Override
  public Subject getSubject(long id) {
    return schoolBusinessService.getSubject(id);
  }

  @Override
  public void assignSubjectToTeacher(long subjectId, long teacherId) {
    schoolBusinessService.assignSubjectToTeacher(subjectId, teacherId);

  }

  @Override
  public void enrollStudentInSubject(long subjectId, long studentId) {
    schoolBusinessService.enrollStudentInSubject(subjectId, studentId);
  }
}
