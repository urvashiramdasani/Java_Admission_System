//main class that will call all classes and open all files
package Main_dotClass;		// javac -d . *.java

import java.io.*;
import java.util.*;
import dotClass.*;

class Main
{
	public static void main(String args[]) 
	{
		BufferedWriter bw1 = null;
		BufferedWriter bw2 = null;
		BufferedWriter bw3 = null;
		BufferedWriter bw4 = null;
		try {
			Scanner sc = new Scanner(System.in);
			bw1 = new BufferedWriter(new FileWriter("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/Stud_name.txt",true));
			bw2 = new BufferedWriter(new FileWriter("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/Stud_DOB.txt",true));
			bw3 = new BufferedWriter(new FileWriter("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/sorted_Names.txt",true));
			bw4 = new BufferedWriter(new FileWriter("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/sorted_DOB.txt",true));
		
			// Code for welcome page
			Welcome wc=new Welcome();
			wc.PrintBorder();
			wc.PrintHeading();
			wc.PrintBorder();
		
			//code for taking student details
			//code for taking student preferences
			// Code for institute of technology page
			ClassStud_Details sd[] = new ClassStud_Details[5];
			Class_Preferences cp[] = new Class_Preferences[5];
			ClassTech_Branches ct = new ClassTech_Branches();
			ClassStud_Details csd = new ClassStud_Details();
			csd.registration();
			for(int i=0;i<5;i++) {
				System.out.println("\tFor Student : "+(i+1)+"\n\n");
				sd[i] = new ClassStud_Details();
				sd[i].getdata();
				ct.OpenFile();
				cp[i] = new Class_Preferences();
				cp[i].getPreferences();
				cp[i].writePreferences();
			}
			bw1.write("stop");
			bw2.write("stop");
		
			//code for reading data
		
			//code for sorting all types
			sortAllTypes sal = new sortAllTypes();
			sal.readName();
			sal.readMarks();
			sal.readDOB();
			sal.readContact();
			sal.readPref();
			sal.sort();
			sal.overWrite();
			bw3.write("stop");
			bw4.write("stop");
		
			//code for final admission process
			admission adm = new admission();
			adm.getSeats();
			adm.readPreferences();
			adm.getArraySize();
			adm.readsortedNames();
			adm.readsortedMarks();
			adm.readsortedDOB();
			adm.readsortedContacts();
			adm.checkSeats();
			adm.writeSeatsLeft();
		}
		catch(IOException e) {
			System.out.println("\tCaught : "+e);
		}
		finally {
			try {
				if(bw1!=null) bw1.close();
				if(bw2!=null) bw2.close();
				if(bw3!=null) bw3.close();
				if(bw4!=null) bw4.close();
			}
			catch(IOException e) {
				System.out.println("Error Closing Output Files...!!!");
			}
		}
	}
}