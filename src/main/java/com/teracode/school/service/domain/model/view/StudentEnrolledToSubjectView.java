package com.teracode.school.service.domain.model.view;

import java.util.List;

/**
 * @author Gonzalo Conte
 */
public interface StudentEnrolledToSubjectView {

  String getFirstName();

  String getLastName();

  Long getId();

  List<String> getSubjects();

}
