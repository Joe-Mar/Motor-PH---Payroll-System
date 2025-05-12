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
 * Stores and manages an employee's salary and allowances.
 */
public class EmployeeFinancials {
    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double grossSemiMonthlyRate;
    private double hourlyRate;

    /**
     * Constructor to initialize financial details.
     */
    public EmployeeFinancials(double basicSalary, double riceSubsidy, double phoneAllowance, 
                              double clothingAllowance, double grossSemiMonthlyRate, double hourlyRate) {
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;
    }

    // Getters
    public double getBasicSalary() { return basicSalary; }
    public double getRiceSubsidy() { return riceSubsidy; }
    public double getPhoneAllowance() { return phoneAllowance; }
    public double getClothingAllowance() { return clothingAllowance; }
    public double getGrossSemiMonthlyRate() { return grossSemiMonthlyRate; }
    public double getHourlyRate() { return hourlyRate; }

    /**
     * Computes total monthly allowances.
     * 
     * @return Sum of all allowances.
     */
    public double getTotalAllowances() {
        return riceSubsidy + phoneAllowance + clothingAllowance;
    }

    /**
     * Computes prorated total allowances based on workdays.
     * 
     * @param totalWorkDays  The total workdays in a month.
     * @param workDays       The actual days worked.
     * @return Prorated allowance amount.
     */
    public double getProratedTotalAllowance(long totalWorkDays, long workDays) {
        if (totalWorkDays > 0) {
            return (getTotalAllowances() / totalWorkDays) * workDays;
        }
        return 0;
    }

    /**
     * Computes allowance based on payroll type (weekly, semi-monthly, monthly).
     * 
     * @param payrollType The payroll schedule (weekly, semi-monthly, or monthly).
     * @return Computed allowance based on payroll type.
     */
    public double computeAllowance(String payrollType) {
        double divisor = switch (payrollType.toLowerCase()) {
            case "weekly" -> 4.0;
            case "semi-monthly" -> 2.0;
            default -> 1.0; // Monthly by default
        };

        return getTotalAllowances() / divisor;
    }

    /**
     * Prints financial details of the employee.
     */
    public void printFinancialDetails() {
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Rice Subsidy: " + riceSubsidy);
        System.out.println("Phone Allowance: " + phoneAllowance);
        System.out.println("Clothing Allowance: " + clothingAllowance);
        System.out.println("Gross Semi-Monthly Rate: " + grossSemiMonthlyRate);
        System.out.println("Hourly Rate: " + hourlyRate);
    }
}
