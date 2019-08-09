package com.teracode.school.service.client;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.teracode.school.service.api.SchoolService;
import com.teracode.school.service.common.dto.*;
import com.teracode.school.service.common.dto.view.ExpensesReportViewDTO;
import com.teracode.school.service.common.dto.view.StudentFrom19To21ViewDTO;
import com.teracode.school.service.common.request.CreateJanitorRequest;
import com.teracode.school.service.common.request.CreatePrincipalRequest;
import com.teracode.school.service.common.request.CreateStudentRequest;
import com.teracode.school.service.common.request.CreateTeacherRequest;
import com.teracode.school.service.common.dto.view.StudentEnrolledToSubjectViewDTO;
import com.teracode.school.service.common.dto.view.StudentLastNameOrderViewDTO;
import com.teracode.school.service.domain.type.WorkingAreaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author Gonzalo Conte
 */
public class SchoolServiceClientImpl implements SchoolService {

  public static final String BASE_PATH = "/api/v1";

  //TODO: IMPLEMENT CLIENT!
  @Resource
  private RestTemplate restTemplate;

  @Override
  public PrincipalDTO createPrincipal(CreatePrincipalRequest request) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath(BASE_PATH + "/principal");

    return restTemplate.postForObject(builder.buildAndExpand().toString(), request, PrincipalDTO.class);
  }

  @Override
  public PrincipalDTO getPrincipal(long id) {
    return null;
  }

  @Override
  public ExpensesReportViewDTO getTotalExpenses() {
    return null;
  }

  @Override
  public TeacherDTO createTeacher(CreateTeacherRequest request) {
    return null;
  }

  @Override
  public TeacherDTO getTeacher(long id) {
    return null;
  }

  @Override
  public StudentDTO createStudent(CreateStudentRequest request) {
    return null;
  }

  @Override
  public StudentDTO getStudent(long id) {
    return null;
  }

  @Override
  public Map<String, List<StudentLastNameOrderViewDTO>> getAllStudentsGroupByFirstLetterOfLastName() {
    return null;
  }

  @Override
  public Set<StudentEnrolledToSubjectViewDTO> getAllStudentsEnrolledToSubject() {
    return null;
  }

  @Override
  public List<StudentFrom19To21ViewDTO> getAllStudentsBetween19And21Years() {
    return null;
  }

  @Override
  public JanitorDTO createJanitor(CreateJanitorRequest request) {
    return null;
  }

  @Override
  public JanitorDTO getJanitor(long id) {
    return null;
  }

  @Override
  public Set<String> getJanitorsFullNameByWorkingArea(WorkingAreaType workingArea) {
    return null;
  }

  @Override
  public SubjectDTO createSubject(String name) {
    return null;
  }

  @Override
  public SubjectDTO getSubject(long id) {
    return null;
  }

  @Override
  public void assignSubjectToTeacher(long subjectId, long teacherId) {

  }

  @Override
  public void enrollStudentToSubject(long subjectId, long studentId) {

  }
}
