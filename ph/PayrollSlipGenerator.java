/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

/**
 *
 * @author lasic
 */
public class PayrollSlipGenerator {
    //This is How MainClass Generate/Print the Payslip
    public static void generatePayrollSlip(Employee employee, String startDate, String endDate,
                                           double totalRegularHours, double totalOvertimeHours, double overtimePay,
                                           double grossIncome, double totalLateMinutes, double lateDeduction,
                                           double proratedRiceSubsidy, double proratedPhoneAllowance, 
                                           double proratedClothingAllowance, GovernmentDeduction deductions,
                                           double taxDeduction, double totalDeductions, double netSalary) {
        System.out.println("\n====================================");
        System.out.println("        MOTORPH PAYSLIP");
        System.out.println("====================================");
        System.out.println("Period Start: " + startDate);
        System.out.println("Period End: " + endDate);
        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Employee Name: " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("====================================");
        
        System.out.println("\nEARNINGS:");
        System.out.printf("Monthly Rate (Basic Pay): %.2f\n", employee.getFinancials().getBasicSalary());
        System.out.printf("Total Regular Hours: %.2f\n", totalRegularHours);
        System.out.printf("Total Overtime Hours: %.2f\n", totalOvertimeHours);
        System.out.printf("Overtime Pay: %.2f\n", overtimePay);
        System.out.printf("Gross Income: %.2f\n", grossIncome);
        
        System.out.println("====================================");
        System.out.println("LATE DETAILS:");
        System.out.printf("Total Late Minutes: %.2f\n", totalLateMinutes);
        System.out.printf("Late Deduction: %.2f\n\n", lateDeduction);
        
        System.out.println("====================================");
        System.out.println("BENEFITS:");
        System.out.printf("Rice Subsidy: %.2f\n", proratedRiceSubsidy);
        System.out.printf("Phone Allowance: %.2f\n", proratedPhoneAllowance);
        System.out.printf("Clothing Allowance: %.2f\n", proratedClothingAllowance);
        double totalAllowances = proratedRiceSubsidy + proratedPhoneAllowance + proratedClothingAllowance;
        System.out.printf("Total Benefits: %.2f\n\n", totalAllowances);
        
        System.out.println("====================================");
        System.out.println("DEDUCTIONS:");
        System.out.printf("SSS: %.2f\n", deductions.getSSS());
        System.out.printf("Pag-IBIG: %.2f\n", deductions.getPagIbig());
        System.out.printf("PhilHealth: %.2f\n", deductions.getPhilHealth());
        System.out.printf("Tax: %.2f\n", taxDeduction);
        System.out.printf("Total Deductions: %.2f\n", totalDeductions);
        
        System.out.println("====================================");
        System.out.printf("NET SALARY (Take Home Pay): %.2f\n", netSalary);
        System.out.println("====================================");
    }
}








