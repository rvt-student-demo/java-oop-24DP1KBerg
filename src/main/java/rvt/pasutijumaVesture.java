package rvt;

import java.io.File;
import java.util.Scanner;

public class pasutijumaVesture {

    public static void main(String[] args) {

        // This variable will store the total sum of all orders
        double totalSum = 0.0;

        // This counter is used for order numbering (#1, #2, ...)
        int orderNumber = 1;

        try {
            // Create a File object that points to the CSV file
            File file = new File("data\\order.csv");

            // Scanner is used to read the file line by line
            Scanner scanner = new Scanner(file);

            // Skip the first line (header row)
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Read each remaining line in the CSV file
            while (scanner.hasNextLine()) {

                // Read one line from the file
                String line = scanner.nextLine();

                // Split the line by commas into an array
                String[] parts = line.split(",");

                // Extract values from the array
                int orderId = Integer.parseInt(parts[0]);
                String customer = parts[1];
                String product = parts[2];
                int quantity = Integer.parseInt(parts[3]);
                double price = Double.parseDouble(parts[4]);

                // Calculate total price for this order
                double orderTotal = quantity * price;

                // Add to the overall total sum
                totalSum += orderTotal;

                // Format and print the order information
                String output = String.format(
                        "Pasutijums #%d: %s pasutija %d x %s (%.2f EUR) -> Kopa: %.2f EUR",
                        orderNumber,
                        customer,
                        quantity,
                        product,
                        price,
                        orderTotal
                );

                System.out.println(output);

                // Increase order number for the next order
                orderNumber++;
            }

            // Close the scanner
            scanner.close();

            // Print the total sum of all orders
            System.out.println();
            System.out.printf("Kopeja pasutijumu summa: %.2f EUR%n", totalSum);

        } catch (Exception e) {
            // Print error message if something goes wrong
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
