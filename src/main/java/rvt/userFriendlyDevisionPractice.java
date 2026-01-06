package rvt;

import java.util.Scanner;

public class userFriendlyDevisionPractice {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {

                System.out.println("Enter the numerator: ");
                
                String numeratorInput  = scanner.nextLine();

                // If the first character is 'q' or 'Q', exit the loop
                if (numeratorInput.charAt(0) == 'q' || numeratorInput.charAt(0) == 'Q') {
                    break;
                }

                // Convert the numerator String into an integer
                int num = Integer.valueOf(numeratorInput);
      
                System.out.println("Enter the divisor");
     
                int num2 = Integer.valueOf(scanner.nextLine());

                System.out.println(num + " / " + num2 + " = " + (num / num2));

            } catch (ArithmeticException e) {
                // This catch runs if the user tries to divide by zero it has to be first because java tends to check speicifc Exception in this case its Arithmetic
                System.out.println("You cant divide by 0");
                
            } catch (Exception e) {
                // This catch runs for all other errors (bad input, etc.)
                System.out.println("You entered bad data.");
                System.out.println("Please try again.");
            }
        }
        scanner.close();
    }
}
