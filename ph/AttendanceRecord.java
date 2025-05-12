/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

/**
 * Represents an attendance record for an employee.
 * This class extends BaseEntity, which contains common employee details.
 */
public class AttendanceRecord extends BaseEntity {
    private String date;       // The date of attendance (e.g., "2025-03-23").
    private String logInTime;  // The time the employee logged in (e.g., "08:05 AM").
    private String logOutTime; // The time the employee logged out (e.g., "05:10 PM").

    public AttendanceRecord(int employeeId, String lastName, String firstName, String date, String logInTime, String logOutTime) {
        super(employeeId, lastName, firstName); // Calls the constructor of the BaseEntity class.
        this.date = date;
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
    }

    public String getDate() {
        return date;
    }
    public String getLogin() {
        return logInTime;
    }
    public String getLogout() {
        return logOutTime;
    }

    public void printAttendanceDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Last Name: " + lastName);
        System.out.println("First Name: " + firstName);
        System.out.println("Date: " + date);
        System.out.println("Log In: " + logInTime);
        System.out.println("Log Out: " + logOutTime);
        System.out.println("----------------------------------");
    }
    @Override
    public void printDetails() {
        printAttendanceDetails();
    }
}
