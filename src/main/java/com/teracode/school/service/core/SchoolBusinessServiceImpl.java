package com.teracode.school.service.core;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.persistence.Tuple;
import javax.transaction.Transactional;

import com.google.common.base.Preconditions;
import com.teracode.school.service.core.function.ExpensesReportViewModelFunction;
import com.teracode.school.service.core.model.ExpensesReportViewModel;
import com.teracode.school.service.domain.model.*;
import com.teracode.school.service.domain.model.view.StudentFrom19To21View;
import com.teracode.school.service.domain.repository.*;
import com.teracode.school.service.domain.type.WorkingAreaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author Gonzalo Conte
 */
@Service("SchoolBusinessServiceImpl")
public class SchoolBusinessServiceImpl implements SchoolBusinessService {

  public static final String JANITOR_FULLNAME_ALIAS = "janitorFullname";
  @Resource
  private PrincipalRepository principalRepository;

  @Resource
  private TeacherRepository teacherRepository;

  @Resource
  private StudentRepository studentRepository;

  @Resource
  private JanitorRepository janitorRepository;

  @Resource
  private SubjectRepository subjectRepository;

  @Transactional
  @Override
  public Principal createPrincipal(String firstName, String lastName, BigDecimal salary) {

    Preconditions.checkArgument(this.principalRepository.count() == 0, "school.service.error.pricipal.already.created");

    Preconditions.checkArgument(!StringUtils.isEmpty(firstName), "school.service.error.principal.firstName.required");
    Preconditions.checkArgument(!StringUtils.isEmpty(lastName), "school.service.error.principal.lastName.required");
    Preconditions.checkArgument(validateSalary(salary), "school.service.error.principal.salary.invalid");

    Principal principal = new Principal(firstName, lastName, salary);

    principal = this.principalRepository.save(principal);

    return principal;
  }

  @Override
  public Principal getPrincipal(long id) {
    return this.principalRepository.getOne(id);
  }

  @Override
  public ExpensesReportViewModel getExpenses() {
    return ExpensesReportViewModelFunction.INSTANCE.apply(this.principalRepository.getExpenses());
  }

  @Transactional
  @Override
  public Teacher createTeacher(String firstName, String lastName, BigDecimal salary) {
    Preconditions.checkArgument(!StringUtils.isEmpty(firstName), "school.service.error.teacher.firstName.required");
    Preconditions.checkArgument(!StringUtils.isEmpty(lastName), "school.service.error.teacher.lastName.required");
    Preconditions.checkArgument(validateSalary(salary), "school.service.error.teacher.salary.invalid");

    Teacher teacher = new Teacher(firstName, lastName, salary);

    teacher = this.teacherRepository.save(teacher);

    return teacher;
  }

  @Override
  public Teacher getTeacher(long id) {
    return this.teacherRepository.getOne(id);
  }

  @Transactional
  @Override
  public Student createStudent(String firstName, String lastName, Date birthDate) {
    Preconditions.checkArgument(!StringUtils.isEmpty(firstName), "school.service.error.student.firstName.required");
    Preconditions.checkArgument(!StringUtils.isEmpty(lastName), "school.service.error.student.lastName.required");
    Preconditions.checkArgument(birthDate != null, "school.service.error.student.birthdate.required");

    Student student = new Student(firstName, lastName, birthDate);

    student = this.studentRepository.save(student);

    return student;
  }

  @Override
  public Student getStudent(long id) {
    return this.studentRepository.getOne(id);
  }

  @Override
  public List<Student> getAllStudentsGroupByFirstLetterOfLastName() {
    return this.studentRepository.findAll();
  }

  @Override
  public List<Student> getAllStudentsEnrolledToSubject() {
    return this.studentRepository.findAll();
  }

  @Override
  public List<StudentFrom19To21View> getAllStudentsBetween19And21Years() {
    return this.studentRepository.getAllStudentsBetween19And21Years();
  }

  @Transactional
  @Override
  public Janitor createJanitor(String firstName, String lastName, BigDecimal salary, WorkingAreaType workingArea) {

    Preconditions.checkArgument(!StringUtils.isEmpty(firstName), "school.service.error.janitor.firstName.required");
    Preconditions.checkArgument(!StringUtils.isEmpty(lastName), "school.service.error.janitor.lastName.required");
    Preconditions.checkArgument(validateSalary(salary), "school.service.error.janitor.salary.invalid");

    Janitor janitor = new Janitor(firstName, lastName, salary, workingArea);

    janitor = this.janitorRepository.save(janitor);

    return janitor;
  }

  @Override
  public Janitor getJanitor(long id) {
    return this.janitorRepository.getOne(id);
  }

  @Override
  public Set<String> getJanitorsWorkingInArea(WorkingAreaType workingArea) {
    List<Tuple> byWorkingArea = this.janitorRepository.findByWorkingArea(workingArea);
    return byWorkingArea.stream().map(tuple -> (String) tuple.get(JANITOR_FULLNAME_ALIAS)).collect(Collectors.toSet());
  }

  @Transactional
  @Override
  public Subject createSubject(String name) {

    Subject subject = new Subject(name);

    subject = this.subjectRepository.save(subject);

    return subject;
  }

  @Override
  public Subject getSubject(long id) {
    return this.subjectRepository.getOne(id);
  }

  @Transactional
  @Override
  public void assignSubjectToTeacher(long subjectId, long teacherId) {

    Subject subject = this.getSubject(subjectId);

    Teacher teacher = this.getTeacher(teacherId);

    teacher.addSubject(subject);

    this.teacherRepository.save(teacher);
  }

  @Transactional
  @Override
  public void enrollStudentInSubject(long subjectId, long studentId) {

    Subject subject = this.getSubject(subjectId);

    Student student = this.getStudent(studentId);

    student.addSubject(subject);

    this.studentRepository.save(student);

  }

  // === private methods

  /**
   * @param salary
   * @return true if the salary is not null and greater than 0
   */
  private boolean validateSalary(BigDecimal salary) {
    return salary != null && BigDecimal.ZERO.compareTo(salary) <= 0;
  }

}