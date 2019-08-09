package com.teracode.school.service.client;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

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
import com.teracode.school.service.domain.type.WorkingAreaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author Gonzalo Conte
 */
public class SchoolServiceClientImpl implements SchoolService {

  public static final String BASE_PATH = "/api/v1";

  @Resource
  private RestTemplate restTemplate;

  @Override
  public PrincipalDTO createPrincipal(CreatePrincipalRequest request) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath(BASE_PATH + "/principal");
    return restTemplate.postForObject(builder.buildAndExpand().toString(), request, PrincipalDTO.class);
  }

  @Override
  public PrincipalDTO getPrincipal(long id) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath(BASE_PATH + "/principal/{id}");
    return restTemplate.getForObject(builder.buildAndExpand(id).toString(), PrincipalDTO.class);
  }

  @Override
  public ExpensesReportViewDTO getTotalExpenses() {
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath(BASE_PATH + "/expenses");
    return restTemplate.getForObject(builder.buildAndExpand().toString(), ExpensesReportViewDTO.class);
  }

  @Override
  public TeacherDTO createTeacher(CreateTeacherRequest request) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath(BASE_PATH + "/teacher");
    return restTemplate.postForObject(builder.buildAndExpand().toString(), request, TeacherDTO.class);
  }

  @Override
  public TeacherDTO getTeacher(long id) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath(BASE_PATH + "/teacher/{id}");
    return restTemplate.getForObject(builder.buildAndExpand(id).toString(), TeacherDTO.class);
  }

  @Override
  public StudentDTO createStudent(CreateStudentRequest request) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath(BASE_PATH + "/student");
    return restTemplate.postForObject(builder.buildAndExpand().toString(), request, StudentDTO.class);
  }

  @Override
  public StudentDTO getStudent(long id) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath(BASE_PATH + "/student/{id}");
    return restTemplate.getForObject(builder.buildAndExpand(id).toString(), StudentDTO.class);
  }

  @Override
  public LinkedHashMap<String, List<StudentLastNameOrderViewDTO>> getAllStudentsGroupByFirstLetterOfLastName() {
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath(BASE_PATH + "/student/order-by-last-name");
    return restTemplate.getForObject(builder.buildAndExpand().toString(), LinkedHashMap.class);
  }

  @Override
  public Set<StudentEnrolledToSubjectViewDTO> getAllStudentsEnrolledToSubject() {
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath(BASE_PATH + "/student/assigned");
    return restTemplate.getForObject(builder.buildAndExpand().toString(), Set.class);
  }

  @Override
  public List<StudentFrom19To21ViewDTO> getAllStudentsBetween19And21Years() {
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath(BASE_PATH + "/student/age/19-21");
    return restTemplate.getForObject(builder.buildAndExpand().toString(), List.class);
  }

  @Override
  public JanitorDTO createJanitor(CreateJanitorRequest request) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath(BASE_PATH + "/janitor");
    return restTemplate.postForObject(builder.buildAndExpand().toString(), request, JanitorDTO.class);
  }

  @Override
  public JanitorDTO getJanitor(long id) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath(BASE_PATH + "/janitor/{id}");
    return restTemplate.getForObject(builder.buildAndExpand(id).toString(), JanitorDTO.class);
  }

  @Override
  public Set<String> getJanitorsFullNameByWorkingArea(WorkingAreaType workingArea) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath(BASE_PATH + "/janitor/working-in/{workingArea}");
    return restTemplate.getForObject(builder.buildAndExpand(workingArea).toString(), Set.class);
  }

  @Override
  public SubjectDTO createSubject(String name) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath(BASE_PATH + "/subject/create/{name}");
    return restTemplate.postForObject(builder.buildAndExpand(name).toString(), null, SubjectDTO.class);

  }

  @Override
  public SubjectDTO getSubject(long id) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath(BASE_PATH + "/subject/{id}");
    return restTemplate.getForObject(builder.buildAndExpand(id).toString(), SubjectDTO.class);
  }

  @Override
  public void assignSubjectToTeacher(long subjectId, long teacherId) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromPath(BASE_PATH + "/subject/{subjectId}/teacher/{teacherId}");

    restTemplate.put(builder.buildAndExpand(subjectId, teacherId).toString(), null);
  }

  @Override
  public void enrollStudentToSubject(long subjectId, long studentId) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromPath(BASE_PATH + "/subject/{subjectId}/student/{teacherId}");

    restTemplate.put(builder.buildAndExpand(subjectId, studentId).toString(), null);

  }
}
