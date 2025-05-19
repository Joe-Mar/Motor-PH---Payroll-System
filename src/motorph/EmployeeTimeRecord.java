/*
 * Programmer: A1101 GROUP 9 | Cocal, V., Franco, C., Jardeliza, L.
 * Date: March 2025
 * Project: MotorPH Payroll System
 */

package motorph;

public class EmployeeTimeRecord extends Employee {
/* 
 * OOP PRINCIPLE: INHERITANCE
 * EmployeeTimeRecord is a child class of Employee, inheriting its properties and methods.
 */

    private int timeIn;
    private int timeOut;
    /* 
     * OOP PRINCIPLE: ENCAPSULATION
     * The private access modifier ensures that these attributes cannot be accessed directly from outside the class.
     */
    
    // GETTER METHOD for timeIn
    public int getTimeIn() {
        return timeIn; // returns the value of timeIn
    }

    // SETTER METHOD for timeIn 
    public void setTimeIn(int timeIn) {
        this.timeIn = timeIn; // assigns the passed value to timeIn
    }

    // GETTER METHOD for timeOut
    public int getTimeOut() {
        return timeOut; // returns the value of timeOut
    }

    // SETTER METHOD for timeOut
    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut; // assigns the passed value to timeOut
    }
    /* 
     * OOP PRINCIPLE: ENCAPSULATION
     * Provides controlled access to private variables without exposing it directly.
     */

}
