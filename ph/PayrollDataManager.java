/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author lasic
 */
 public class PayrollDataManager {
    public static void processPayrollForAllEmployees(List<Employee> employees) {
        WorkHoursManager workHoursManager = new WorkHoursManager(); // Create an instance of WorkHoursManager
        LocalDate today = LocalDate.now(); // Use the Date Formatter

        for (Employee employee : employees) {
            double totalHours = workHoursManager.calculateTotalWorkHours(0, today, today);
            double grossSalary = PayrollProcessor.calculateGrossSalary(employee.getFinancials(), totalHours);
            double deductions = SalaryCalculator.computeDeductions(grossSalary);
            double netSalary = PayrollProcessor.calculateNetSalary(grossSalary, deductions);

            System.out.printf("Payroll Processed: ID: %d | Name: %s %s | Gross: %.2f | Deductions: %.2f | Net: %.2f\n",
                    employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), grossSalary, deductions, netSalary);
        }
    }
}

