// Imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

/** 
* An exception class to be thrown when a negative number is encountered.
* 
* @author  Joshua Borck
*/
class NegativeNumberException extends Exception {
	private static final long serialVersionUID = 1L;
}

/** 
* A class to get five floating-point values and calculate various data from it.
* 
* @author  Joshua Borck
*/
public class FloatingPointEvaluator {
	// Static Strings
	private static String INVALID_INPUT = "Invalid input. Please try again.\n";
	private static String USER_PROMPT = "Enter any positive number and it can include decimals. You can also enter q to quit.";
	private static String EXITING = "Exiting";
	private static String QUIT_VALUE = "q";
	private static String TOTAL_OUTPUT = "Total: %.2f";
	private static String AVERAGE_OUTPUT = "Average: %.2f";
	private static String MAXIMUM_OUTPUT = "Maximum Value: %.2f";
	private static String MINIMUM_OUTPUT = "Minimum Value: %.2f";
	private static String INTEREST_OUTPUT = "Interest on a total of %.2f is %.2f";
	private static String NEGATIVE_NUMBER_OUPUT = "Please use a positive number.";

	public static void main(String[] args) {
		// Initialize properties
		Scanner scnr = new Scanner(System.in);
		ArrayList<Double> userValues = new ArrayList<Double>();
		double total = 0;
		String userInput = "";
		
		// While the user has not entered five values or quit, keep trying to get the next value.
		while (userValues.size() < 5) {
			
			try {
				// Prompt the user to enter a floating-point number or q to quit.
				System.out.println(USER_PROMPT);
				userInput = scnr.next();
				
				// Attempt to convert the input to a double and add it to the array. If it fails, check if it is a quit command or inform the user of invalid input.
				double userNum = Double.parseDouble(userInput);
				
				if (userNum < 0) {
					throw new NegativeNumberException();
				}
				userValues.add(userNum);
				total = total + userNum;
			} catch (NoSuchElementException e) {
				System.out.println(INVALID_INPUT);
			} catch (NegativeNumberException e) {
				System.out.println(NEGATIVE_NUMBER_OUPUT + " " + INVALID_INPUT);
			}catch (NumberFormatException e) {
				if (userInput.equals(QUIT_VALUE)) {
					System.out.println(EXITING);
					System.exit(0);
				} else {
					System.out.println(INVALID_INPUT);
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
		System.out.println(String.format(TOTAL_OUTPUT, total));
		System.out.println(String.format(AVERAGE_OUTPUT, average));
		System.out.println(String.format(MAXIMUM_OUTPUT, max));
		System.out.println(String.format(MINIMUM_OUTPUT, min));
		System.out.println(String.format(INTEREST_OUTPUT, total, interest));
		
		// Close the scanner.
		scnr.close();
	}

}
