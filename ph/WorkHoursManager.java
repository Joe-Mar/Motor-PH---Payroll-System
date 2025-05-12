/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkHoursManager {
    // Singleton Instance
    private static WorkHoursManager instance;

    // Date & Time Formatter
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");

    // Extended Method of EmployeeWorkHours Class
    private EmployeeWorkHours employeeWorkHours;

    // Private Constructor (to enforce Singleton)
    WorkHoursManager() {
        this.employeeWorkHours = new EmployeeWorkHours();
    }

    // Singleton getInstance Method
    public static WorkHoursManager getInstance() {
        if (instance == null) {
            instance = new WorkHoursManager();
        }
        return instance;
    }

    public static List<WorkHoursRecord> computeWorkHours() {
        List<WorkHoursRecord> workHoursList = new ArrayList<>();
        List<String[]> data = WorkHoursService.readCSV();

        for (String[] row : data) {
            try {
                int empId = Integer.parseInt(row[0]);
                LocalDate date = LocalDate.parse(row[3], dateFormatter);
                LocalTime login = LocalTime.parse(row[4], timeFormatter);
                LocalTime logout = LocalTime.parse(row[5], timeFormatter);

                int shiftHour = (login.getMinute() > 10) ? login.getHour() : Math.max(8, login.getHour());
                LocalTime shiftStart = LocalTime.of(shiftHour, 0);

                long lateMinutes = login.isAfter(shiftStart.plusMinutes(10)) ? Duration.between(shiftStart, login).toMinutes() : 0;
                double totalWorkHours = (double) Duration.between(login, logout).toMinutes() / 60;
                double regularHours = Math.min(8, totalWorkHours);
                double overtimeHours = Math.max(0, totalWorkHours - 8);

                double hourlyRate = 100; // Placeholder
                double lateDeduction = (hourlyRate / 60) * lateMinutes;

                workHoursList.add(new WorkHoursRecord(empId, row[3], regularHours, overtimeHours, lateMinutes, lateDeduction));

            } catch (Exception e) {
                System.out.println("Skipping invalid record: " + Arrays.toString(row) + " - Error: " + e.getMessage());
            }
        }
        return workHoursList;
    }
//CalculateTotalRedularHours Method
    public double calculateTotalRegularHours(int employeeId, LocalDate startDate, LocalDate endDate) {
        return employeeWorkHours.getTotalRegularHours(employeeId, startDate, endDate);
    }
//ClaculteTotalLateMinutes Method
    public double calculateTotalLateMinutes(int employeeId, LocalDate startDate, LocalDate endDate) {
        return employeeWorkHours.getTotalLateMinutes(employeeId, startDate, endDate);
    }
//CalculateTotalOverTime Method
    public double calculateTotalOvertimeHours(int employeeId, LocalDate startDate, LocalDate endDate) {
        return employeeWorkHours.getTotalOvertimeHours(employeeId, startDate, endDate);
    }
//CalculateTotalWorkHours Method
    public double calculateTotalWorkHours(int employeeId, LocalDate startDate, LocalDate endDate) {
        double regularHours = employeeWorkHours.getTotalRegularHours(employeeId, startDate, endDate);
        double overtimeHours = employeeWorkHours.getTotalOvertimeHours(employeeId, startDate, endDate);
        return regularHours + overtimeHours;
    }
}

