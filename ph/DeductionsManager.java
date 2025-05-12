/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

/**
 *
 * @author lasic
 */
/**
 * DeductionsManager handles the computation of government-mandated deductions
 * such as SSS, Pag-IBIG, and PhilHealth based on an employee's gross salary.
 */
public class DeductionsManager {

    /**
     * Computes the Social Security System (SSS) contribution.
     * The deduction is 4.5% of the gross salary.
     *
     * @param grossSalary The employee's gross salary.
     * @return The computed SSS contribution.
     */
    public static double computeSSS(double grossSalary) {
        return grossSalary * 0.045; // 4.5% SSS deduction
    }

    /**
     * Computes the Pag-IBIG Fund contribution.
     * The deduction is 2% of the gross salary, but it is capped at a maximum of 100 PHP.
     *
     * @param grossSalary The employee's gross salary.
     * @return The computed Pag-IBIG contribution (max 100 PHP).
     */
    public static double computePagIbig(double grossSalary) {
        return Math.min(grossSalary * 0.02, 100); // 2% Pag-IBIG deduction, max 100 PHP
    }

    /**
     * Computes the PhilHealth contribution.
     * The deduction is 3.5% of the gross salary.
     *
     * @param grossSalary The employee's gross salary.
     * @return The computed PhilHealth contribution.
     */
    public static double computePhilHealth(double grossSalary) {
        return grossSalary * 0.035; // 3.5% PhilHealth deduction
    }
}
