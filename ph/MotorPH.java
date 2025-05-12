/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author lasic
 */
public class MotorPH {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== MotorPH Payroll System =====");
            System.out.println("1. View Employee Details");
            System.out.println("2. View Attendance");
            System.out.println("3. View Work Hours");
            System.out.println("4. Process Payroll");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 5.");
                scanner.next(); // Consume invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewEmployeeDetails(scanner);
                    break;
                case 2:
                    AttendanceService.viewAttendance(scanner);
                    break;
                case 3:
                    WorkHoursService.viewWorkHours(scanner, DATE_FORMATTER);
                    break;
                case 4:
                    processPayroll(scanner);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }

            if (!exit && !askToReturn(scanner)) {
                exit = true;
            }
        }

        scanner.close();
    }

    private static void viewEmployeeDetails(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid Employee ID.");
            scanner.next(); // Consume invalid input
            return;
        }
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        EmployeeService.viewEmployeeDetails(employeeId);
    }

    private static void processPayroll(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid Employee ID.");
            scanner.next(); // Consume invalid input
            return;
        }
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Start Date (MM/dd/yyyy): ");
        String startDate = scanner.nextLine();
        System.out.print("Enter End Date (MM/dd/yyyy): ");
        String endDate = scanner.nextLine();

        PayrollService.processPayroll(employeeId, startDate, endDate);
    }

    private static boolean askToReturn(Scanner scanner) {
        System.out.println("\nWould you like to return to the main menu?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter choice: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Returning to main menu.");
            scanner.next(); // Consume invalid input
            return true;
        }

        int returnChoice = scanner.nextInt();
        return returnChoice == 1;
    }
}




