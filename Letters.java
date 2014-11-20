package dictionary-app;
import java.util.*;


public class Letters  {
	String word;
	ArrayList <String> permutationArray = new ArrayList <String> ();
	Dictionary dictObj;
	
	/**
	 * This is the Letters class constructor
	 * @param dictObj
	 * 		Allows access to Dictionary class methods and data fields
	 * @param word
	 * 		This is the user's string input 
	 */
	public Letters (Dictionary dictObj, String word) {
		this.word = word;
		this.dictObj = dictObj;
		
	}
	/**
	 * permuteString() creates potential matches based on the prefix of the permutation
	 * The base case is when the suffix's length is 0, and this method has properly iterated through the entire 
	 * 		word.
	 * The iterative case will call the prefixBinarySearch() method, which will add the prefix of size 2 
	 * 		through n to the array of potential words and will only call the recursive case if the prefix is 
	 * 		indeed found in the Dictionary. If not, the method will backtrack to the next letter and its 
	 * 		permutations.
	 * 	
	 * @param beg
	 * 		This is the prefix of the word - at the first iteration, it is a blank string (ie: "")
	 * @param end
	 * 		This is the suffix of the word
	 */
	
	public void permuteString (String beg, String end) {
		if (end.length() == 0) {
			permutationArray.add(beg+end);
		}
		else {
			for (int i = 0; i < end.length(); i++) {
				String newBeg = beg + end.charAt(i);
				if (dictObj.prefixBinarySearch(0, dictObj.getDictionaryArray().size()-1, newBeg) == 0) {
					if (newBeg.length() >= 2) {
						permutationArray.add(newBeg);
					}
					String newEnd = end.substring(0, i) + end.substring(i+1);
					permuteString (newBeg,newEnd);
				}
			}
		}
	}
		
}


