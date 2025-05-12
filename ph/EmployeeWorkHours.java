/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

import java.time.LocalDate;

import java.time.LocalDate;

/**
 * Handles computation of employee work hours, including regular hours, overtime, 
 * late minutes, and corresponding deductions.
 */
public class EmployeeWorkHours {
    public static double getTotalRegularHours(int empId, LocalDate startDate, LocalDate endDate) {
        return WorkHoursManager.computeWorkHours().stream()
                .filter(wh -> wh.getEmployeeId() == empId 
                        && WorkHoursService.isDateInRange(wh.getDate(), startDate, endDate))
                .mapToDouble(WorkHoursRecord::getRegularHours)
                .sum();
    }

    public static double getTotalOvertimeHours(int empId, LocalDate startDate, LocalDate endDate) {
        return WorkHoursManager.computeWorkHours().stream()
                .filter(wh -> wh.getEmployeeId() == empId 
                        && WorkHoursService.isDateInRange(wh.getDate(), startDate, endDate))
                .mapToDouble(WorkHoursRecord::getOvertimeHours)
                .sum();
    }

    public static double getTotalLateMinutes(int empId, LocalDate startDate, LocalDate endDate) {
        return WorkHoursManager.computeWorkHours().stream()
                .filter(wh -> wh.getEmployeeId() == empId 
                        && WorkHoursService.isDateInRange(wh.getDate(), startDate, endDate))
                .mapToDouble(WorkHoursRecord::getLateMinutes)
                .sum();
    }

    public static double getTotalLateDeductions(int employeeId, LocalDate startDate, LocalDate endDate, double hourlyRate) {
        int totalLateMinutes = (int) getTotalLateMinutes(employeeId, startDate, endDate);
        return (hourlyRate / 60) * totalLateMinutes;
    }
}
