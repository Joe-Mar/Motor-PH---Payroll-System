/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;
/**
 * BaseEntity is an abstract class that serves as a blueprint for all employee-related entities.
 * It holds basic employee details and enforces a print method in all subclasses.
 */
public abstract class BaseEntity {
    // Stores the Employee ID
    protected int employeeId;
    // Stores the Employee's Last Name
    protected String lastName;
    // Stores the Employee's First Name
    protected String firstName;

    public BaseEntity(int employeeId, String lastName, String firstName) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;

    public int getEmployeeId() {
        return employeeId;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    /**
     * Abstract method that must be implemented by subclasses.
     * Each entity (like AttendanceRecord) will define its own way of displaying details.
     */
    public abstract void printDetails();
}

