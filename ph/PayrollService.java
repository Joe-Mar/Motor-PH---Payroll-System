/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author lasic
 */
public class PayrollService {

    // Method for processing payroll with date range
    public static void processPayroll(int employeeId, String startDate, String endDate) {
        Employee employee = EmployeeService.getEmployeeByEmployeeId(employeeId);
        if (employee == null) {
            System.out.println("Error: Employee not found.");
            return;
        }

        // Use DateTimeFormatter for correct date parsing
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        try {
            LocalDate start = LocalDate.parse(startDate, formatter);
            LocalDate end = LocalDate.parse(endDate, formatter);
            WorkHoursManager workHoursManager = new WorkHoursManager();

            // Determine payroll type
            boolean isWeekly = false;
            boolean isSemiMonthly = true; // Assuming semi-monthly for now

            // Get work hours
            double totalRegularHours = workHoursManager.calculateTotalRegularHours(employeeId, start, end);
            double totalLateMinutes = workHoursManager.calculateTotalLateMinutes(employeeId, start, end);
            double totalOvertimeHours = workHoursManager.calculateTotalOvertimeHours(employeeId, start, end);

            // Semi-monthly basic salary (45000 for half of the month)
            double semiMonthlySalary = employee.getFinancials().getBasicSalary() / 2;

            // Overtime Pay Calculation
            double overtimePay = PayrollProcessor.calculateOvertimePay(employee.getFinancials(), totalOvertimeHours);

            // 🔹 FIXED: Gross Income should be Basic Semi-Monthly Salary + Overtime Pay
            double grossIncome = semiMonthlySalary + overtimePay;

            // 🔹 FIXED: Late Deduction Formula
            double hourlyRate = semiMonthlySalary / totalRegularHours;
            double lateDeduction = (hourlyRate / 60) * totalLateMinutes;

            // Government Deductions & Tax Computation
            GovernmentDeduction deductions = new GovernmentDeduction(grossIncome);
            double totalDeductions = deductions.getTotalDeductions() + lateDeduction;
            double taxDeduction = TaxComputation.computeTax(grossIncome - totalDeductions);
            totalDeductions += taxDeduction;

            // 🔹 FIXED: Prorated Allowances for Semi-Monthly
            double proratedRiceSubsidy = employee.getFinancials().getRiceSubsidy() / 2;
            double proratedPhoneAllowance = employee.getFinancials().getPhoneAllowance() / 2;
            double proratedClothingAllowance = employee.getFinancials().getClothingAllowance() / 2;

            // Net Salary Calculation
            double netSalary = PayrollProcessor.calculateNetSalary(
                grossIncome + proratedRiceSubsidy + proratedPhoneAllowance + proratedClothingAllowance, 
                totalDeductions
            );

            // Generate Payroll Slip
            PayrollSlipGenerator.generatePayrollSlip(employee, startDate, endDate, totalRegularHours, totalOvertimeHours,
                overtimePay, grossIncome, totalLateMinutes, lateDeduction, 
                proratedRiceSubsidy, proratedPhoneAllowance, proratedClothingAllowance, 
                deductions, taxDeduction, totalDeductions, netSalary);
        } catch (DateTimeParseException e) {
            System.err.println("Error: Invalid date format. Expected MM/dd/yyyy but got: " + startDate + " or " + endDate);
        }
    }
}




