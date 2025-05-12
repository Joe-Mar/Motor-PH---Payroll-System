/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages reading employee data from a CSV file.
 */
public class EmployeeDataManager {
    // File path of the employee CSV file
    private static final String FILE_NAME = "C:\\Users\\lasic\\OneDrive\\Documents\\NetBeansProjects\\MOTOR-PH\\build\\classes\\motor\\resources\\employee-data.csv";

    /**
     * Reads employee data from the CSV file and returns a list of Employee objects.
     * 
     * @return A list of employees from the CSV file.
     */
    public static List<Employee> readFromCSV() {
        List<Employee> employeeList = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            reader.readLine(); // Skip the header row

            while ((line = reader.readLine()) != null) {
                // Splits CSV line correctly, even when values are enclosed in quotes
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                // Converts CSV data into an Employee object
                Employee emp = EmployeeCSVParser.parseEmployee(data);
                
                if (emp != null) {
                    employeeList.add(emp);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading employee data: " + e.getMessage());
        }

        return employeeList;
    }
}
