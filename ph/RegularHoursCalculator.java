/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

import java.time.LocalDate;

// Concrete Class for Regular Hours Calculation
public class RegularHoursCalculator extends WorkHoursCalculator {
    public RegularHoursCalculator(int employeeId, LocalDate startDate, LocalDate endDate) {
        super(employeeId, startDate, endDate);
    }

    @Override
    public double calculate() {
        return WorkHoursManager.getInstance().calculateTotalRegularHours(employeeId, startDate, endDate);
    }
}

