package asg1;
/**
 * @author SanaSheikh
 * N14143085
 * NetID: ss6231
 */
import java.util.*;
import java.io.*;
public class FindWords {

	/**
	 * @param args
	 * 		this is the command line input (dictionary file
	 * 
	 * Will also catch inputs that are too small, large, or do not consist solely of characters with system.exit
	 * Given the correct file and input, this will create a dictionary object and a letters object 
	 *		with corresponding methods.
	 * 
	 *Section 1 (see labeled) asks the user for a string input. It then sends the input to the isWordValid() 
	 *	method to validate the string. If the word is valid, it converts it to lower case since all words in the 
	 *	dictionary are lower case.
	 *
	 *Section2 creates new instances of Dictionary class (takes the scanner file as an arg) and Letters class 
	 *	(takes the dictionary object and the user's string word as args). Then, it calls the methods: 
	 *	(1) permuteString() of the Letters class, (2) refineString() of the Dictionary class, and (3) 
	 *	finally prints out the final array of matching words if there are matches.
	*/
	
	public static void main(String[] args)   {
		if (args.length < 1) {
			System.err.println ("ERROR: You did not enter a file");
			System.exit(1);
		}
		else if (args.length > 1) {
			System.err.println ("ERROR: You have entered too many files");
			System.exit(2);
		}
		if (!new File (args[0]).exists()) {
			System.err.println ("ERROR: File does not exist");
			System.exit(3);
		}
		try {
			Scanner dictScanner = new Scanner (new File (args[0]));
			Scanner in = new Scanner (System.in);
			
			//Section 1
			System.out.println ("Input string between 2 and 10 characters long: ");
			String word = in.nextLine();
			isWordValid (word);
			word = word.toLowerCase();
			
			//Section 2
			System.out.println ("Your word is: " + word);
			Dictionary dictObj = new Dictionary (dictScanner);
			Letters wordObj = new Letters (dictObj,word);
			wordObj.permuteString("",word);
			dictObj.refineString (dictObj.getWordsInArray());
			if (dictObj.getWordsInArray().size() != 0) {
				System.out.println ("\nThe matches are: ");
				for (int i = 0; i < dictObj.getWordsInArray().size(); i++) {
					System.out.println (dictObj.getWordsInArray().get(i));
				}
			}
			else {
				System.out.println ("There are no matches in the dictionary :(");
			}
		}
		catch (Exception ex) {
			System.out.println (ex.toString());
		}
	}

	/**
	 * isWordValid: validates user input by checking ascii value of each individual character
	 * @param word
	 * 	This string word is the user's input
	 * @throws IllegalArgumentException
	 * 	-if input is too short, program will print corresponding error
	 * 	-if input is too long, program will print corresponding error 
	 * 	-if the input is not all letters, program will print corresponding error
	 * 	
	 */
	public static void isWordValid (String word)  {
		if (word.length() < 2) {
			System.err.println ("ERROR: Length of input is less than 2 characters");
			System.exit(1);
		}
		else if (word.length() > 10) {
			System.err.println ("ERROR: Length of input is greater than 10 characters");
			System.exit(2);
		}
		else {
			for (int i = 0; i < word.length(); i++) {
				char let = word.charAt(i);
				
				if ( (65 <= let && let <= 90) || (97<= let && let <= 122)) {
					continue;
				}
				else {
					System.err.println ("ERROR: Input does not consist solely of letters");
					System.exit(3);
				} 
			}
		}	
	}
}
