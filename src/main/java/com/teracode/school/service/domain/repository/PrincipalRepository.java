package com.teracode.school.service.domain.repository;

import com.teracode.school.service.domain.model.Principal;
import com.teracode.school.service.domain.model.view.ExpensesReportView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Gonzalo Conte
 */
@Repository
public interface PrincipalRepository extends PersonBaseRepository<Principal>  {

  @Query(value = "SELECT  SUM(p.salary) as totalExpenses, ROUND(AVG(p.salary),2) as averageSalary, MIN(p.salary) as minimumSalary, "
             + "MAX(p.salary) as maximumSalary, SUM(j.salary) "
             + "as janitorsSalary, SUM(t.salary) as teachersSalary, "
             + " SUM(ppal.salary) as principalSalary "
             + "FROM PERSON as p "
             + "LEFT JOIN PERSON as j ON j.type = 'JANITOR' and j.id = p.id "
             + "LEFT JOIN PERSON AS t ON t.type = 'TEACHER' and t.id = p.id "
             + "LEFT JOIN PERSON AS ppal ON ppal.type = 'PRINCIPAL'and ppal.id = p.id", nativeQuery = true)
  ExpensesReportView getExpenses();


}
