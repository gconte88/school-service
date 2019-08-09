package com.teracode.school.service.domain.repository;

import java.util.List;

import javax.persistence.Tuple;

import com.teracode.school.service.domain.model.Janitor;
import com.teracode.school.service.domain.type.WorkingAreaType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Gonzalo Conte
 */
@Repository
public interface JanitorRepository extends PersonBaseRepository<Janitor> {

  /**
   * @param workingAreaType
   * @return {@link List} of {@link Tuple} with the fullnames of the janitors
   */
  @Query(value = "select concat(j.firstName, ' ', j.lastName) as janitorFullname "
      + "from Person j "
      + "WHERE j.workingArea = :area AND j.type = 'JANITOR'")
  List<Tuple> findByWorkingArea(@Param("area") WorkingAreaType workingAreaType);

}
