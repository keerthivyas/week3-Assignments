package week3;

import java.util.LinkedHashSet;
import java.util.Set;

public class PayPal {

	private static final boolean False = false;

	public static void main(String[] args) {
		
		String str = "Paypal India";
		char[] arr = str.toCharArray();  // Convert it into a character array
		Set<Character> charSet = new LinkedHashSet<Character>();     //Declare a Set as charSet for Character
		Set<Character> dupCharSet = new LinkedHashSet<Character>(charSet);  // Declare a Set as dupCharSet for duplicate Character

		// Iterate character array and add it into charSet
		for (int i = 0; i < arr.length; i++) {
			
			boolean flag = charSet.add(arr[i]);   // Set won't store dupilcate values so it will return false 
			
			// if the character is already in the charSet then, add it to the dupCharSet
			if (flag==False) {
				
				dupCharSet.add(arr[i]);
			}
			
		}
		
		System.out.println("Character without dupicate values");
		System.out.println(charSet);
		
		System.out.println("Dupicate character values");
		System.out.println(dupCharSet);
		
		charSet.removeAll(dupCharSet);   // Check the dupCharSet elements and remove those in the charSet
		
		System.out.println("After Removing duplicates in CharSet");
		System.out.println(charSet);
		//System.out.println(dupCharSet);
		
		System.out.println("Printing each character after removing duplicates");
		
		for (Character eachChar : charSet) {    // Iterate using charSet
			
			if ( eachChar != ' ') {              // Check the iterator variable isn't equals to an empty space
				
				System.out.println(eachChar);        //print each character for charSet
				
			} 
			
		}
		
		

	}

}
