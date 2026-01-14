package rvt;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class todo {

    public static void main(String[] args) {
        

        try {

            // Create a File object that points to the CSV file
            File file = new File("data\\todo.csv");
            Scanner input = new Scanner(System.in);

            int number = 1;

            //Cheks how many lines are already in the file and if there is a line it add +1 the int number so that it can know the sorting later
            if (file.exists()) {
                Scanner filescanner = new Scanner(file);
                if (filescanner.hasNextLine()) {
                    String line = filescanner.nextLine();
                    if (!line.isEmpty()) {
                        number++;
                    }
                }
                
            }

            
        }

        catch (Exception e){
            // Print error message if something goes wrong
            System.out.println("Error reading file: " + e.getMessage());
        }

    }
    
}
