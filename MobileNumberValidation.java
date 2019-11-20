//class for validating the entered mobile number
package dotClass;

import java.util.*;
import java.util.regex.*;

class MobileNumberValidation {
	public static boolean isValid(String s) {
		// Conditions for a valid mobile number 
		// 1. starts with 0 or 91 // 2. second number is between 6-9 // 3. contains 9 digits
		Pattern p = Pattern.compile("(0/91)?[6-9][0-9]{9}"); //used to compare the regex with the string
		Matcher m = p.matcher(s); //used to check for multiple occurences in a regex
		return (m.find() && m.group().equals(s)); 
	}										 
}