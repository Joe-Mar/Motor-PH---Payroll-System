/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

/**
 *
 * @author lasic
 */
public class SalaryCalculator {
    //Method to Use for  Deduction Calculation with GrossSalary
    public static double computeDeductions(double grossSalary) {
        double sss = DeductionsManager.computeSSS(grossSalary);
        double pagIbig = DeductionsManager.computePagIbig(grossSalary);
        double philHealth = DeductionsManager.computePhilHealth(grossSalary);
        return sss + pagIbig + philHealth;
    }
}
