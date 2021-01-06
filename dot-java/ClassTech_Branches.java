// Class for opening the Technology_Branches.txt

package dotClass;

import java.io.*;
import dotClass.*;

public class ClassTech_Branches {
	public void OpenFile() {
		int i;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/Technology_Branches.txt");
			do {
				i = fin.read();
				if(i!=-1) System.out.print((char) i);
			} while(i!=-1);
		}
		catch(IOException e) {
			System.out.println("I/O Error : "+e);
		}
		finally {
			try {
				if(fin!=null) fin.close();
			}
			catch(IOException e2) {
				System.out.println("Error Closing Input File...!!!");
			}
		}
	}
}