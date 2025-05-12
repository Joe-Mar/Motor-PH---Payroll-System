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

    /**
     * Constructor to initialize employee details.
     *
     * @param employeeId Unique ID of the employee.
     * @param lastName   Employee's last name.
     * @param firstName  Employee's first name.
     */
    public BaseEntity(int employeeId, String lastName, String firstName) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    /**
     * Gets the Employee ID.
     *
     * @return Employee ID.
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Gets the Last Name of the Employee.
     *
     * @return Employee's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the First Name of the Employee.
     *
     * @return Employee's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Abstract method that must be implemented by subclasses.
     * Each entity (like AttendanceRecord) will define its own way of displaying details.
     */
    public abstract void printDetails();
}

