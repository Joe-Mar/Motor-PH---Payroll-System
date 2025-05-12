/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

import java.time.LocalDate;
// Concrete Class for Overtime Hours Calculation
public class OvertimeHoursCalculator extends WorkHoursCalculator {
    public OvertimeHoursCalculator(int employeeId, LocalDate startDate, LocalDate endDate) {
        super(employeeId, startDate, endDate);
    }

    @Override
    public double calculate() {
        return WorkHoursManager.getInstance().calculateTotalOvertimeHours(employeeId, startDate, endDate);
    }
}
