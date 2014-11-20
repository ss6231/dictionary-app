package dictionary-app;
import java.util.*;

	public class Dictionary {
		Scanner scannerDict;
		private ArrayList<String> dictionaryArray = new ArrayList<String>();
		private ArrayList<String> wordsInArray = new ArrayList<String>();
		
		/**
		 * This is the Dictionary constructor, which takes the scanner file as an argument
		 * @param scannerDict
		 * 		This is the dictionary file as a scanner
		 * After receiving the scanner, the constructor calls the method readDictionary () automatically to read
		 * 		the file.
		 */
		public Dictionary (Scanner scannerDict) {
			this.scannerDict = scannerDict;
			readDictionary();
		}
		/**
		 * Upon creation of the scanner, this method will automatically read the scanner so long as the file has 
		 * 		some text.
		 * Each line is converted into a string and added to the dictionaryArray 
		 * @return
		 * 		This will return an ArrayList of Strings with each element corresponding to each entry in the 
		 * 		dictionary
		 */
		public ArrayList<String> readDictionary () {
			while (scannerDict.hasNext()) {
				String line = scannerDict.nextLine();
				dictionaryArray.add(line);
			}
			return dictionaryArray;
		}
		/**
		 * prefixBinaryMethod() is a recursive search method to check whether the prefix of the permutation in the
		 * 		Letters class is found in the dictionaryArray.
		 * There are two base cases: (1) when the low index is greater than the high index. This indicates that the
		 * 		search has exhausted and there are no found matches of the prefix in the dictionary. This will 
		 * 		send -1 back to permuteString() method, and cause the next iteration to occur. The other base 
		 * 		is (2) when there is a match: if the entry of the dictionaryArray starts with the prefix, this 
		 * 		will call the wordBinarySearch to check whether the prefix itself is a word found as an entry 
		 * 		in the dictionary.The recursive calls proceed when there is no prefix match in the 
		 * 		dictionaryArray, and will keep iterating through until it hits either of the base cases.
		 * 
		 * @param low
		 * 		This variable begins at the value 0 and will either remain as such or change to mid+1 depending on
		 * 		where the key prefix is location in the dictionaryArray
		 * @param high
		 * 		This variable begins at dictionaryArray.size()-1 (ie: the last index of the dictionary) and will
		 * 		either remain as such or decrease to mid-1
		 * @param key
		 * 		This is the prefix permutation from the Letters class permuteString() method
		 * @return
		 * 		This method will return an integer value to designate a match (at 0) or a positive or negative 
		 * 		number using the compareTo() method
		 */
		public int prefixBinarySearch (int low, int high, String key) {
			if (low > high) {
				return -1;
			}
			int mid = (low+high)/2;
			if (dictionaryArray.get(mid).startsWith(key)) {
				if (wordBinarySearch (low,high,key) == 0) {
					wordsInArray.add(key);
				}
				return 0;
			}
			else if (dictionaryArray.get(mid).compareTo (key) < 0) {
				return prefixBinarySearch (mid+1, high, key);
			}
			else {
				return prefixBinarySearch (low,mid-1, key);
			}
		}
		/**
		 * wordBinarySearch() method will be called from the prefixBinarySearch() method only when the prefix 
		 * 		matches the dictionary entry. If the dictionary entry equals the prefix itself as a whole, 
		 * 		then 0 will be returned to prefixBinarySearch() and from there, the match will be stored into 
		 * 		an ArrayList.The recursive calls will proceed when there is no match. The base cases will proceed 
		 * 		when the search is exhausted or when there is a match. 
		 * 
		 * @param low
		 * 		The low variable begins at the same index from prefixBinarySearch(). low gives the lower bound index
		 * 		of the dictionary entry with the potential match, and low will either remain the same index or
		 * 		increase to mid-1 if the key is greater than the element at low. 
		 * @param high
		 * 		The high variable begins at the same index from prefixBinarySearch(). high gives the upper bound
		 * 		index of the dictionary entry at which the potential match is. It will either remain at the same
		 * 		index or decrease to mid-1 if the key is less than the element at high. 
		 * @param key
		 * 		This variable represents the potential match. From prefixBinarySearch(), we can see that the 
		 * 		dictionary entry startsWith key, but it does not necessarily equal key. wordBinarySearch() takes this
		 * 		potential match and uses the .equals() method to ascertain equality
		 * @return
		 * 		This method will return an integer. We are looking for 0 as a return value to indicate equality. ig
		 * 		not, then the method will be called recursively until the search is exhausted or until a match is 
		 * 		found. 
		 */
	
	public int wordBinarySearch (int low, int high, String key) {
		if (low > high) {
			return -1;
		}
		int mid = (low+high)/2;
		if (dictionaryArray.get(mid).compareTo(key) == 0) {
			return 0;
		}
		else if (dictionaryArray.get(mid).compareTo (key) < 0) {
			return wordBinarySearch (mid+1, high, key);
		}
		else {
			return wordBinarySearch (low,mid-1, key);
		}
	}
	/**
	 * This method will take all the entry matches and remove duplicates as well as sort them in alphabetical order
	 * @param unrefinedArray
	 * 		From the main method, wordsInArray will be passed as an argument, which has stored all the definite
	 * 		matches between the permutations and dictionary entries. In essence, wordsInArray will be stored as the
	 * 		unrefinedArray arrayList.
	 */
	public void refineString (ArrayList<String> unrefinedArray) {
		Collections.sort(unrefinedArray);
		for (int i = 0; i < unrefinedArray.size(); i++) {
			while (i < unrefinedArray.size()-1) {
				if (unrefinedArray.get(i).equals(unrefinedArray.get(i+1))) {
					unrefinedArray.remove(i);
				}
				else {
					i++;
				}
			}
		}	
	}
	/**
	 * dictionaryArray is a private data field that needs a getter method
	 * @return
	 * 		returns the dictionaryArray ArrayList
	 */
	public ArrayList <String> getDictionaryArray () {
		return dictionaryArray;
	}
	
	/**
	 * wordsInArray is a private data field that needs a getter method
	 * @return
	 * 		returns the wordsInArray ArrayList
	 */
	public ArrayList <String> getWordsInArray () {
		return wordsInArray;
	}
}
	
			
