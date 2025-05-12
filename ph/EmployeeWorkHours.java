/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

import java.time.LocalDate;

/**
 *
 * @author lasic
 */
import java.time.LocalDate;

/**
 * Handles computation of employee work hours, including regular hours, overtime, 
 * late minutes, and corresponding deductions.
 */
public class EmployeeWorkHours {

    /**
     * Calculates the total regular hours worked by an employee within a given date range.
     * 
     * @param empId      The employee's ID.
     * @param startDate  The start date of the period.
     * @param endDate    The end date of the period.
     * @return The total regular hours worked.
     */
    public static double getTotalRegularHours(int empId, LocalDate startDate, LocalDate endDate) {
        return WorkHoursManager.computeWorkHours().stream()
                .filter(wh -> wh.getEmployeeId() == empId 
                        && WorkHoursService.isDateInRange(wh.getDate(), startDate, endDate))
                .mapToDouble(WorkHoursRecord::getRegularHours)
                .sum();
    }

    /**
     * Calculates the total overtime hours worked by an employee within a given date range.
     * 
     * @param empId      The employee's ID.
     * @param startDate  The start date of the period.
     * @param endDate    The end date of the period.
     * @return The total overtime hours worked.
     */
    public static double getTotalOvertimeHours(int empId, LocalDate startDate, LocalDate endDate) {
        return WorkHoursManager.computeWorkHours().stream()
                .filter(wh -> wh.getEmployeeId() == empId 
                        && WorkHoursService.isDateInRange(wh.getDate(), startDate, endDate))
                .mapToDouble(WorkHoursRecord::getOvertimeHours)
                .sum();
    }

    /**
     * Calculates the total late minutes of an employee within a given date range.
     * 
     * @param empId      The employee's ID.
     * @param startDate  The start date of the period.
     * @param endDate    The end date of the period.
     * @return The total late minutes.
     */
    public static double getTotalLateMinutes(int empId, LocalDate startDate, LocalDate endDate) {
        return WorkHoursManager.computeWorkHours().stream()
                .filter(wh -> wh.getEmployeeId() == empId 
                        && WorkHoursService.isDateInRange(wh.getDate(), startDate, endDate))
                .mapToDouble(WorkHoursRecord::getLateMinutes)
                .sum();
    }

    /**
     * Calculates the total late deductions based on an employee's late minutes.
     * 
     * @param employeeId  The employee's ID.
     * @param startDate   The start date of the period.
     * @param endDate     The end date of the period.
     * @param hourlyRate  The employee's hourly rate.
     * @return The total late deduction amount.
     */
    public static double getTotalLateDeductions(int employeeId, LocalDate startDate, LocalDate endDate, double hourlyRate) {
        int totalLateMinutes = (int) getTotalLateMinutes(employeeId, startDate, endDate);
        return (hourlyRate / 60) * totalLateMinutes;
    }
}
