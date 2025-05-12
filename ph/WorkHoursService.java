/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lasic
 */
public class WorkHoursService {
    // Path to the CSV file containing attendance records
    private static final String FILE_NAME = "C:\\Users\\lasic\\OneDrive\\Documents\\NetBeansProjects\\MOTOR-PH\\build\\classes\\motor\\resources\\attendance_data.csv";
    
    // Formatter for handling date formats (MM/dd/yyyy)
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    /**
     * Reads the CSV file containing employee work hours and returns the data as a list of string arrays.
     * Each array represents a row from the file, split by commas.
     *
     * @return A list of string arrays containing attendance data.
     */
    public static List<String[]> readCSV() {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip the header row
                    continue;
                }
                data.add(line.split(","));
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
        return data;
    }

    /**
     * Checks if a given date falls within a specified date range.
     *
     * @param dateStr   The date as a string in MM/dd/yyyy format.
     * @param startDate The start date of the range.
     * @param endDate   The end date of the range.
     * @return true if the date is within the range (inclusive), false otherwise.
     */
    public static boolean isDateInRange(String dateStr, LocalDate startDate, LocalDate endDate) {
        LocalDate date = LocalDate.parse(dateStr, dateFormatter);
        return (date.isEqual(startDate) || date.isAfter(startDate)) && date.isBefore(endDate.plusDays(1));
    }

    /**
     * Prompts the user to input an Employee ID and a date range, then displays the total work hours,
     * regular hours, overtime hours, and late minutes for the given employee within that range.
     *
     * @param scanner        The scanner object for user input.
     * @param DATE_FORMATTER The formatter for date parsing.
     */
    public static void viewWorkHours(Scanner scanner, DateTimeFormatter DATE_FORMATTER) {
        System.out.print("Enter Employee ID: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid Employee ID.");
            scanner.next(); // Consume invalid input
            return;
        }
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Start Date (MM/dd/yyyy): ");
        String startDateStr = scanner.nextLine();
        System.out.print("Enter End Date (MM/dd/yyyy): ");
        String endDateStr = scanner.nextLine();

        try {
            LocalDate startDate = LocalDate.parse(startDateStr, DATE_FORMATTER);
            LocalDate endDate = LocalDate.parse(endDateStr, DATE_FORMATTER);

            // Get work hours calculations from WorkHoursManager
            WorkHoursManager workHoursManager = new WorkHoursManager();
            double totalWorkHours = workHoursManager.calculateTotalWorkHours(employeeId, startDate, endDate);
            double totalRegularHours = workHoursManager.calculateTotalRegularHours(employeeId, startDate, endDate);
            double totalOvertimeHours = workHoursManager.calculateTotalOvertimeHours(employeeId, startDate, endDate);
            double totalLateMinutes = workHoursManager.calculateTotalLateMinutes(employeeId, startDate, endDate);

            // Display the results
            System.out.println("\n=== Work Hours Summary ===");
            System.out.println("Employee ID: " + employeeId);
            System.out.println("Total Work Hours: " + totalWorkHours + " hours");
            System.out.println("Regular Hours: " + totalRegularHours + " hours");
            System.out.println("Overtime Hours: " + totalOvertimeHours + " hours");
            System.out.println("Late Minutes: " + totalLateMinutes + " minutes");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter dates in MM/dd/yyyy format.");
        }
    }
}
