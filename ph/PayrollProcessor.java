/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;
// Use for Calculation of Gross Salary and Net Salary
public class PayrollProcessor {

    private static final double OVERTIME_RATE = 1.25; //OT Rate
    private static final int WORK_DAYS_PER_MONTH = 22; // Monthly Number of Working Days
    private static final int WORK_HOURS_PER_DAY = 8; // Total Shift-Hours Per Day
    
    //How to Calculate Gross Salary
    public static double calculateGrossSalary(EmployeeFinancials financials, double totalRegularHours) {
    double hourlyRate = financials.getBasicSalary() / WORK_DAYS_PER_MONTH / WORK_HOURS_PER_DAY;
    return (totalRegularHours * hourlyRate);
}
    //How to Calculate Overtime
    public static double calculateOvertimePay(EmployeeFinancials financials, double totalOvertimeHours) {
        double hourlyRate = financials.getBasicSalary() / WORK_DAYS_PER_MONTH / WORK_HOURS_PER_DAY;
        return totalOvertimeHours * hourlyRate * OVERTIME_RATE;
    }
    //How to Calculate LateDeduction
    public static double calculateLateDeduction(EmployeeFinancials financials, double totalLateMinutes) {
        double hourlyRate = financials.getBasicSalary() / WORK_DAYS_PER_MONTH / WORK_HOURS_PER_DAY;
        return (hourlyRate / 60) * totalLateMinutes;
    }
    //How to Calculate NetSalary
    public static double calculateNetSalary(double grossSalary, double deductions) {
        return grossSalary - deductions;
    }

}



