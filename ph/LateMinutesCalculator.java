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
// Concrete Class for Late Minutes Calculation
public class LateMinutesCalculator extends WorkHoursCalculator {
    public LateMinutesCalculator(int employeeId, LocalDate startDate, LocalDate endDate) {
        super(employeeId, startDate, endDate);
    }

    @Override
    public double calculate() {
        return WorkHoursManager.getInstance().calculateTotalLateMinutes(employeeId, startDate, endDate);
    }
}
