# MotorPH Payroll System

**MO-IT101 | Computer Programming**  
MotorPH Payroll System is a Java-based payroll management tool that reads employee data from a CSV file and calculates net salary based on multiple government-mandated deductions.

---

## Features

- Employee directory from CSV
- Net salary calculation with:
  - SSS Deduction
  - PhilHealth Deduction
  - Pag-IBIG Deduction
  - Withholding Tax
- Salary based on hours worked (160 hours/month)
- OOP principles: Encapsulation, Abstraction, Inheritance, Polymorphism
- JUnit test coverage for all major classes

---

## Technologies Used

- Java (JDK 17)
- Apache NetBeans (Java Ant Project)
- JUnit 4.13.2
- Hamcrest 1.3

---

## How to Run the System

1. Open the project in **NetBeans**
2. Make sure the `employee_data.csv` is located at `src/resources/employee_data.csv`
3. Run the `MotorPH.java` main class
4. Follow the menu to:
   - View employee directory
   - Compute net salary
   - Compute salary based on hours worked

---

## Running the Unit Tests

1. Right-click the project folder in NetBeans
2. Select **Test**
3. Or right-click any `Test` class > **Test File**

All tests are located in:
/test/motorph/

---

## Test Coverage Summary

| Class Tested                     | Test Class                     |
|----------------------------------|--------------------------------|
| Employee.java                    | EmployeeTest.java              |
| EmployeeModelFromFile.java       | EmployeeModelFromFileTest.java |
| PagIbigDeduction.java            | PagIbigDeductionTest.java      |
| PhilHealthDeduction.java         | PhilHealthDeductionTest.java   |
| SSSDeduction.java                | SSSDeductionTest.java          |
| WithholdingTax.java              | WithholdingTaxTest.java        |
| TotalDeductions.java             | TotalDeductionsTest.java       |
| SalaryOnHoursWorked.java         | SalaryOnHoursWorkedTest.java   |

> **All tests passed – 100% Green!**

---

## Group 9 | A1101

- **Cocal, Vincent**
- **Franco, Christian Fasheh**
- **Jardeliza, Larah Mikaela**

---

## License

This project is for educational purposes only.
