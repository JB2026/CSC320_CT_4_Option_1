import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// A class to get five floating-point values and calculate various data from it.
public class FloatingPointEvaluator {

	public static void main(String[] args) {
		// Initialize properties
		Scanner scnr = new Scanner(System.in);
		ArrayList<Double> userValues = new ArrayList<Double>();
		double total = 0;
		String userInput = "";
		
		// While the user has not entered five values or quit, keep trying to get the next value.
		while (userValues.size() < 5) {
			
			// Prompt the user to enter a floating-point number or q to quit.
			System.out.println("Enter any number and it can include decimals. You can also enter q to quit.");
			userInput = scnr.next();
			
			// Attempt to convert the input to a double and add it to the array. If it fails, check if it is a quit command or inform the user of invalid input.
			try {
				double userNum = Double.parseDouble(userInput);
				userValues.add(userNum);
				total = total + userNum;
			}
			catch (NumberFormatException e) {
				if (userInput.equals("q")) {
					System.out.println("Exiting");
					System.exit(0);
				} else {
					System.out.println("Invalid input. Please try again.\n");
				}
			}
		}
		
		// Sort the user values to be able to get the max and min values.
		Collections.sort(userValues);
		
		// Calculate the max, min, average, and interest on the total at 20%.
		double max = userValues.get(4);
		double min = userValues.get(0);
		double average = total / userValues.size();
		double interest = total * 0.2;
		
		// Output all the computed values to the user.
		System.out.println(String.format("Total: %.2f", total));
		System.out.println(String.format("Average: %.2f", average));
		System.out.println(String.format("Maximum Value: %.2f", max));
		System.out.println(String.format("Minimum Value: %.2f", min));
		System.out.println(String.format("Interest on a total of %.2f is %.2f", total, interest));
		
		// Close the scanner.
		scnr.close();
	}

}
