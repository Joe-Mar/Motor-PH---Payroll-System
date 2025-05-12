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
public class WorkHours {
    public static List<WorkHoursRecord> getAllWorkHours() {
        return WorkHoursManager.computeWorkHours();
    }
    //Method For  Getting TotalRegularHours
    public static double getTotalRegularHours(int empId, LocalDate startDate, LocalDate endDate) {
        return EmployeeWorkHours.getTotalRegularHours(empId, startDate, endDate);
    }
    //Method for Getting OverTime Hours
    public static double getTotalOvertimeHours(int empId, LocalDate startDate, LocalDate endDate) {
        return EmployeeWorkHours.getTotalOvertimeHours(empId, startDate, endDate);
    }
    //Method For Getting Late Minutes
    public static double getTotalLateMinutes(int empId, LocalDate startDate, LocalDate endDate) {
        return EmployeeWorkHours.getTotalLateMinutes(empId, startDate, endDate);
    }
    //Method For Getting Late Deduction
    public static double getTotalLateDeductions(int empId, LocalDate startDate, LocalDate endDate, double hourlyRate) {
        return EmployeeWorkHours.getTotalLateDeductions(empId, startDate, endDate, hourlyRate);
    }
}



