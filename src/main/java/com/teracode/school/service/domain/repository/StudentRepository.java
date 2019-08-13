package com.teracode.school.service.domain.repository;

import java.util.LinkedList;
import java.util.List;

import com.teracode.school.service.domain.model.Student;
import com.teracode.school.service.domain.model.view.StudentEnrolledToSubjectView;
import com.teracode.school.service.domain.model.view.StudentFrom19To21View;
import com.teracode.school.service.domain.model.view.StudentLastNameOrderView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Gonzalo Conte
 */
@Repository
public interface StudentRepository extends PersonBaseRepository<Student> {

//  @Query(value = "SELECT id as id, first_name as firstName, last_name as lastName, SUBSTR(last_name, 1, 1) as alpha "
//      + "FROM person "
//      + "where type = 'STUDENT' "
//      + "ORDER BY alpha", nativeQuery = true)
//  LinkedList<StudentLastNameOrderView> getAllStudentsGroupedByLastNameFirstLetter();

//  @Query(value = "select p.id as id, p.first_name as firstName, p.last_name as lastName, GROUP_CONCAT(s.name) as subjects "
//      + "FROM person p "
//      + "inner join STUDENT_SUBJECT ss on ss.student_id = p.id "
//      + "inner join SUBJECT s on ss.subject_id = s.id "
//      + "where p.type = 'STUDENT' GROUP BY p.id", nativeQuery = true)
//  List<StudentEnrolledToSubjectView> getAllStudentsAssignedToSubject();

  @Query(value = "SELECT p.id, p.first_name as firstName, p.last_name as lastName, TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) as age "
      + "from Person p "
      + "WHERE p.type = 'STUDENT' HAVING age BETWEEN 19 AND 21", nativeQuery = true)
  List<StudentFrom19To21View> getAllStudentsBetween19And21Years();
}
