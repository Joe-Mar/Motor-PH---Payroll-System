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
// Abstract Class for Work Hours Calculation (Abstraction)
public abstract class WorkHoursCalculator {
    protected int employeeId;
    protected LocalDate startDate;
    protected LocalDate endDate;

    public WorkHoursCalculator(int employeeId, LocalDate startDate, LocalDate endDate) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public abstract double calculate(); // Abstract method (Polymorphism)
}
