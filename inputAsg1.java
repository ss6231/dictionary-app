package dictionary-app;
import java.util.*;
public class inputAsg1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create scanner for user's word
		Scanner in = new Scanner (System.in);
		//calls method to check validity of string
		try {
			System.out.println ("Input string that is anywhere between 2 and 10 characters long: ");
			String input = in.nextLine();
			isWordValid(input);
			String input_lower = input.toLowerCase();
		}
		
		//if exception is caught, print message of specific exception 
		catch (IllegalArgumentException ex) {
			System.out.println (ex.getMessage());
		}
	}
	public static void isWordValid (String input) {
		//check length of string, otherwise throw exception
		if ((input.length() < 2) || (input.length() > 10)) {
			throw new IllegalArgumentException ("ERROR: Length of input is invalid");
		}
		//if length is acceptable, check actual contents of string, otherwise throw exception
		else {
			//check ascii value of each letter in string using for loop
			for (int i = 0; i < input.length(); i++) {
				char let = input.charAt(i);
				//string's ascii should fall in between range of letters only
				if ( (65 <= let && let <= 90) || (97<= let && let <= 122)) {
					continue;
				}// end if
				
				//if string's ascii is out of bounds, it is not a letter - throw exception
				else {
					throw new IllegalArgumentException ("ERROR: Input does not consist solely of letters");
				} //end loop's inner else conditional 
			}//end for loop
		}// end outer else conditional
	}//end isInputValid method

}
