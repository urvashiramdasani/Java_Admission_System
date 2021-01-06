//class for taking student preferences
package dotClass;

import java.util.*;
import java.io.*;

class NegativePreferencesException extends Exception {
	public String toString() {
		return "Invalid Preferences...!!!";
	}
}
class InvalidCharacterException extends Exception {
	public String toString() {
		return "Invalid Character...!!!";
	}
}

public class Class_Preferences {
	int pre [] = new int [7];
	char ch='y';
	int count = 0;
	Scanner sc = new Scanner(System.in);
	
	public void getPreferences() {
		System.out.println("\n    Enter your Preferences for the addmission in ITNU  ");
		System.out.print("    You can enter maximum of 7 Preferences...  ");
		try {
			do {
				try {
					System.out.print("\n    Enter your "+(count+1)+" preference : ");
					int temp = sc.nextInt();
					if(temp<=0 || temp>7) throw new NegativePreferencesException();
					pre[count] = temp;
					count++;
				} 
				catch(NegativePreferencesException npe) {
					System.out.println("\tCaught : "+npe);
				}
				System.out.print("    Enter Y to Enter and N to Exit : ");
				ch = sc.next().charAt(0);
				if(count>=7 && (ch=='y' || ch=='Y')) throw new ArrayIndexOutOfBoundsException();
				if(ch!='n' && ch!='N' && ch!='y' && ch!='Y') throw new InvalidCharacterException();
			}while(ch=='y' || ch=='Y');
		}
		catch(ArrayIndexOutOfBoundsException aob) {
			System.out.println("\tCaught : "+aob);
		}
		catch(InvalidCharacterException ice) {
			System.out.println("\tCaught : "+ice);
		}
	}
	
	public void writePreferences() {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/Preferences.txt",true));
			for(int i=0;i<pre.length;i++) {
				writer.write(""+pre[i]);
				writer.newLine();
			}
		}
		catch(IOException e) {
			System.out.println("\tCaught : "+e);
		}
		finally {
			try {
				if(writer!= null) writer.close();
			}
			catch(IOException e) {
				System.out.println("Error Closing Output File...!!!");
			}
		}
	}
}