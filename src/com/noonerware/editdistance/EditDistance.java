package com.noonerware.editdistance;

public class EditDistance {

	public static void main(String[] args) {
		String word1 = "foo";
		String word2 = "fobaro";
		
		EditDistance thisClass = new EditDistance();
		
		int result = thisClass.calculateNumberOfOperationsRequired(word1, word2);
		System.out.println(String.format("The number of operations required to change %s to %s is %d", word1, word2, result));
	}

	int calculateNumberOfOperationsRequired(String word1, String word2) {
		
		if ((null == word1) || (null == word2)) {
			throw new IllegalArgumentException("Neither word may be null");
		}
		
		if (word1.equals(word2)) {
			return 0;
		}
		
		int lengthOfWord1 = word1.length();
		int lengthOfWord2 = word2.length();
		
		if (lengthOfWord1 == 0) {
			//
			//  Word1 is an empty string.  Word2 is NOT an empty string.  Insert all of the characters from Word2.
			//
			return lengthOfWord2;
		}
		else if (lengthOfWord2 == 0) {
			//
			//  Word2 is an empty string.  Word1 is NOT an empty string. Delete all the characters from Word1.
			//
			return lengthOfWord1;
		}
		
		int counter = 0;
		
		int minValueOfTheTwoLenghts = Math.min(lengthOfWord1, lengthOfWord2);
		for (int i = 0; i < minValueOfTheTwoLenghts; i++) {
			char word1Char = word1.charAt(i);
			char word2Char = word2.charAt(i);
			
			if (word1Char == word2Char) {
				//
				// Same character.  Nothing to do.
				//
				continue;
			}
			else {
				//
				// Replace word1's character with word2's character
				//
				counter++;
			}
		}
		
		if (lengthOfWord1 == lengthOfWord2) {
			//
			// Words of the same length.  We've already counter the number of characters that need to be changed.
			// There is no need to insert or delete any characters.  We're done
			//
		}
		else if (lengthOfWord1 > lengthOfWord2) {
			//
			// Word1 is longer.  These are extra characters that need to be removed.
			//
			counter += (lengthOfWord1 - lengthOfWord2);
		}
		else {
			//
			// Word2 is longer.  These are extra characters that need to be inserted.
			//
			counter += (lengthOfWord2 - lengthOfWord1);
		}
		return counter;
	}

}
