/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

public class WorkHoursRecord {
    private int employeeId;
    private String date;
    private double regularHours;
    private double overtimeHours;
    private double lateMinutes;
    private double lateDeduction;

    public WorkHoursRecord(int employeeId, String date, double regularHours, double overtimeHours, double lateMinutes, double lateDeduction) {
        this.employeeId = employeeId;
        this.date = date;
        this.regularHours = regularHours;
        this.overtimeHours = overtimeHours;
        this.lateMinutes = lateMinutes;
        this.lateDeduction = lateDeduction;
    }
    
    public int getEmployeeId() { return employeeId; }
    public String getDate() { return date; }
    public double getRegularHours() { return regularHours; }
    public double getOvertimeHours() { return overtimeHours; }
    public double getLateMinutes() { return lateMinutes; }
    public double getLateDeduction() { return lateDeduction; }
}
