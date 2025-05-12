/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;


/**
 *
 * @author lasic
 */
import java.util.List;
import java.util.Scanner;

/**
 * Service class for handling attendance-related operations.
 * This class interacts with the user and fetches attendance records.
 */
public class AttendanceService {

    /**
     * Allows the user to view an employee's attendance records by entering their Employee ID.
     * This method is used in the Main class to scan and display attendance records.
     *
     * @param scanner Scanner object to take user input.
     */
    public static void viewAttendance(Scanner scanner) {
        // Prompt the user to enter an Employee ID
        System.out.print("Enter Employee ID: ");
        int searchEmployeeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after integer input

        // Retrieve attendance records for the given Employee ID
        List<AttendanceRecord> attendanceList = AttendanceManager.getAttendanceByEmployeeId(searchEmployeeId);

        // Check if any records exist for the given Employee ID
        if (!attendanceList.isEmpty()) {
            System.out.println("\n===== Attendance Records =====");
            // Loop through and print each attendance record
            for (AttendanceRecord attendance : attendanceList) {
                attendance.printAttendanceDetails();
            }
            System.out.println("==============================");
        } else {
            // Display message if no records are found
            System.out.println("No attendance records found.");
        }
    }
}


