/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;
/**
 * DeductionsManager handles the computation of government-mandated deductions
 * such as SSS, Pag-IBIG, and PhilHealth based on an employee's gross salary.
 */
public class DeductionsManager {
    public static double computeSSS(double grossSalary) {
        return grossSalary * 0.045; // 4.5% SSS deduction
    }

    public static double computePagIbig(double grossSalary) {
        return Math.min(grossSalary * 0.02, 100); // 2% Pag-IBIG deduction, max 100 PHP
    }

    public static double computePhilHealth(double grossSalary) {
        return grossSalary * 0.035; // 3.5% PhilHealth deduction
    }
}
