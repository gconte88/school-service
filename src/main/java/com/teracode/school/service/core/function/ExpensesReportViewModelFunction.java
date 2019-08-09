package com.teracode.school.service.core.function;

import java.util.function.Function;

import com.teracode.school.service.core.model.ExpensesReportViewModel;
import com.teracode.school.service.domain.model.view.ExpensesReportView;

/**
 * @author Gonzalo Conte
 */
public class ExpensesReportViewModelFunction implements Function<ExpensesReportView, ExpensesReportViewModel> {

  public static ExpensesReportViewModelFunction INSTANCE = new ExpensesReportViewModelFunction();

  @Override
  public ExpensesReportViewModel apply(ExpensesReportView expensesReportView) {
    return new ExpensesReportViewModel(expensesReportView.getPrincipalSalary(), expensesReportView.getTeachersSalary(),
        expensesReportView.getJanitorsSalary(), expensesReportView.getTotalExpenses(),
        expensesReportView.getAverageSalary(), expensesReportView.getMaximumSalary(),
        expensesReportView.getMinimumSalary());
  }
}
