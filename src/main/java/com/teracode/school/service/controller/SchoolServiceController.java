package com.teracode.school.service.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.teracode.school.service.api.SchoolService;
import com.teracode.school.service.common.dto.*;
import com.teracode.school.service.common.dto.view.ExpensesReportViewDTO;
import com.teracode.school.service.common.dto.view.StudentEnrolledToSubjectViewDTO;
import com.teracode.school.service.common.dto.view.StudentFrom19To21ViewDTO;
import com.teracode.school.service.common.dto.view.StudentLastNameOrderViewDTO;
import com.teracode.school.service.common.request.CreateJanitorRequest;
import com.teracode.school.service.common.request.CreatePrincipalRequest;
import com.teracode.school.service.common.request.CreateStudentRequest;
import com.teracode.school.service.common.request.CreateTeacherRequest;
import com.teracode.school.service.controller.function.*;
import com.teracode.school.service.controller.function.view.ExpensesReportViewFunction;
import com.teracode.school.service.core.SchoolBusinessService;
import com.teracode.school.service.domain.type.WorkingAreaType;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gonzalo Conte
 */
@RestController
@RequestMapping(value = "/api/v1/school", produces = MediaType.APPLICATION_JSON_VALUE)
public class SchoolServiceController implements SchoolService {

  @Resource(name = "SchoolCacheBusinessServiceImpl")
  private SchoolBusinessService schoolBusinessService;

  @PostMapping(value = "/principal")
  @Override
  public PrincipalDTO createPrincipal(@RequestBody CreatePrincipalRequest request) {

    return PrincipalFunction.INSTANCE.apply(
        this.schoolBusinessService.createPrincipal(request.getFirstName(), request.getLastName(), request.getSalary()));
  }

  @GetMapping(value = "/principal/{id}")
  @Override
  public PrincipalDTO getPrincipal(@PathVariable long id) {
    return PrincipalFunction.INSTANCE.apply(this.schoolBusinessService.getPrincipal(1));
  }

  @GetMapping(value = "/expenses")
  @Override
  public ExpensesReportViewDTO getTotalExpenses() {
    return ExpensesReportViewFunction.INSTANCE.apply(this.schoolBusinessService.getExpenses());
  }

  @GetMapping(value = "/expenses/no-cache")
  public ExpensesReportViewDTO getTotalExpensesNoCache() {
    return ExpensesReportViewFunction.INSTANCE.apply(this.schoolBusinessService.getExpenses());
  }

  @PostMapping(value = "/teacher")
  @Override
  public TeacherDTO createTeacher(@RequestBody CreateTeacherRequest request) {
    return TeacherFunction.INSTANCE.apply(
        this.schoolBusinessService.createTeacher(request.getFirstName(), request.getLastName(), request.getSalary()));
  }

  @GetMapping(value = "/teacher/{id}")
  @ResponseBody
  @Override
  public TeacherDTO getTeacher(@PathVariable long id) {
    return TeacherFunction.INSTANCE.apply(this.schoolBusinessService.getTeacher(id));
  }

  @PostMapping(value = "/student")
  @Override
  public StudentDTO createStudent(@RequestBody CreateStudentRequest request) {
    return StudentFunction.INSTANCE.apply(this.schoolBusinessService
        .createStudent(request.getFirstName(), request.getLastName(), request.getBirthDate()));
  }

  @GetMapping(value = "/student/{id}")
  @Override
  public StudentDTO getStudent(@PathVariable long id) {
    return StudentFunction.INSTANCE.apply(this.schoolBusinessService.getStudent(id));
  }

  @GetMapping(value = "/student/order-by-last-name")
  @Override
  public Map<String, List<StudentLastNameOrderViewDTO>> getAllStudentsGroupByFirstLetterOfLastName() {

    Map<String, List<StudentLastNameOrderViewDTO>> allStudentsGroupByFirstLetterOfLastName =
        this.schoolBusinessService.getAllStudentsGroupByFirstLetterOfLastName().stream().map(
            studentView -> new StudentLastNameOrderViewDTO(studentView.getAlpha(), studentView.getFirstName(),
                studentView.getLastName(), studentView.getId()))
            .collect(Collectors.groupingBy(StudentLastNameOrderViewDTO::getAlpha));

    return allStudentsGroupByFirstLetterOfLastName;
  }

  @GetMapping(value = "/student/assigned")
  @Override
  public Set<StudentEnrolledToSubjectViewDTO> getAllStudentsEnrolledToSubject() {
    return this.schoolBusinessService.getAllStudentsEnrolledToSubject().stream()
        .map(studentEnrolledToSubjectView -> new StudentEnrolledToSubjectViewDTO(studentEnrolledToSubjectView.getSubjects(),
            studentEnrolledToSubjectView.getFirstName(), studentEnrolledToSubjectView.getLastName(),
            studentEnrolledToSubjectView.getId())).collect(Collectors.toSet());
  }

  @GetMapping(value = "/student/age/19-21")
  @Override
  public List<StudentFrom19To21ViewDTO> getAllStudentsBetween19And21Years() {
    return this.schoolBusinessService.getAllStudentsBetween19And21Years().stream().map(
        studentFrom19To21View -> new StudentFrom19To21ViewDTO(studentFrom19To21View.getId(),
            studentFrom19To21View.getFirstName(), studentFrom19To21View.getLastName(), studentFrom19To21View.getAge()))
        .collect(Collectors.toList());
  }

  @PostMapping(value = "/janitor")
  @Override
  public JanitorDTO createJanitor(@RequestBody CreateJanitorRequest request) {
    return JanitorFunction.INSTANCE.apply(this.schoolBusinessService
        .createJanitor(request.getFirstName(), request.getLastName(), request.getSalary(),
            WorkingAreaType.valueOf(request.getWorkingArea())));
  }

  @GetMapping(value = "/janitor/{id}")
  @Override
  public JanitorDTO getJanitor(@PathVariable long id) {
    return JanitorFunction.INSTANCE.apply(this.schoolBusinessService.getJanitor(id));
  }

  @GetMapping(value = "/janitor/working-in/{workingArea}")
  @Override
  public Set<String> getJanitorsFullNameByWorkingArea(@PathVariable WorkingAreaType workingArea) {
    return this.schoolBusinessService.getJanitorsWorkingInArea(workingArea);
  }

  @PostMapping(value = "/subject/create/{name}")
  @Override
  public SubjectDTO createSubject(@PathVariable String name) {
    return SubjectFuncion.INSTANCE.apply(this.schoolBusinessService.createSubject(name));
  }

  @GetMapping(value = "/subject/{id}")
  @Override
  public SubjectDTO getSubject(@PathVariable long id) {
    return SubjectFuncion.INSTANCE.apply(this.schoolBusinessService.getSubject(id));
  }

  @PutMapping(value = "/subject/{subjectId}/assign/teacher/{teacherId}")
  @Override
  public void assignSubjectToTeacher(@PathVariable long subjectId, @PathVariable long teacherId) {
    this.schoolBusinessService.assignSubjectToTeacher(subjectId, teacherId);
  }

  @PutMapping(value = "/subject/{subjectId}/enroll/student/{studentId}")
  @Override
  public void enrollStudentToSubject(@PathVariable long subjectId, @PathVariable long studentId) {
    this.schoolBusinessService.enrollStudentInSubject(subjectId, studentId);
  }
}
