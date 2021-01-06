//class for performing sorting of records
package dotClass;

import java.util.*;
import java.io.*;

public class sortAllTypes extends ClassStud_Details {
	public String name [] = new String[50];
	public String dob [] = new String [50];
	public int all_pref [][] = new int [5][7];
	public long conums [] = new long [50];
	public double temp_marks [] = new double [50];
	public int count=0;
	public int temp_pref [] = new int [7];
	public String str = new String();
	
	// method to sort student data
	public void sort() {
		for(int j=0;j<count;j++) {
			int d=j;
			while(d>0 && temp_marks[d]>temp_marks[d-1]) {
				//sorting marks
				double temp = temp_marks[d];
				temp_marks[d] = temp_marks[d-1];
				temp_marks[d-1] = temp;
				
				//sorting names
				String temp_str = name[d];
				name[d] = name[d-1];
				name[d-1] = temp_str;
				
				//sorting DOB
				String DOB = dob[d];
				dob[d] = dob[d-1];
				dob[d-1] = DOB;
				
				//sorting contacts
				long number = conums[d];
				conums[d] = conums[d-1];
				conums[d-1] = number;
				
				//sorting preferences
				temp_pref = all_pref[d];
				all_pref[d] = all_pref[d-1];
				all_pref[d-1] = temp_pref;
				d--;
			}
		}
	}
	
	//method to overwrite sorted data to file
	public void overWrite() {
		BufferedWriter bw1 = null;		// while working with BufferedWriter, always close it 
		BufferedWriter bw2 = null;		//otherwise it will not write file
		BufferedWriter bw3 = null;
		BufferedWriter bw4 = null;
		BufferedWriter bw5 = null;
		try {
			bw1 = new BufferedWriter(new FileWriter("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/sorted_Names.txt",true));
			bw2 = new BufferedWriter(new FileWriter("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/sorted_DOB.txt",true));
			bw3 = new BufferedWriter(new FileWriter("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/sorted_Marks.txt",true));
			bw4 = new BufferedWriter(new FileWriter("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/sorted_Contacts.txt",true));
			bw5 = new BufferedWriter(new FileWriter("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/sorted_Preferences.txt",true));
			for(int i=0;i<5;i++) {
				bw1.write(name[i]);
				bw1.newLine();
				bw2.write(dob[i]);
				bw2.newLine();
				bw3.write(""+temp_marks[i]);
				bw3.newLine();
				bw4.write(""+conums[i]);
				bw4.newLine();
			}
			for(int i=0;i<5;i++) {
				for(int j=0;j<7;j++) {
					//System.out.println(all_pref[i][j]);
					bw5.write(""+all_pref[i][j]);
					bw5.newLine();
				}
			}
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
				if(bw5!=null) bw5.close();
			}
			catch(IOException e) {
				System.out.println("Error Closing Output Files...!!!");
			}
		}
	}
	
	//methods to read student data
	public void readName() {
		BufferedReader br = null;
 		try {
			br = new BufferedReader(new FileReader("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/Stud_name.txt"));
			count=0;
			do {
				str = br.readLine();
				if(!str.equals("stop")) {
					//System.out.println(str);
					name[count] = str;
					count++;
				} 
			} while(!str.equals("stop"));
		}
		catch(IOException e) {
			System.out.println("\tCaught : "+e);
		}
		catch(Exception ignored) {
			
		}
		finally {
			try {
				if(br!= null) br.close();
			}
			catch(IOException e) {
				System.out.println("Error Closing Input File...!!!");
			}
		}
	}
	
	public void readMarks () {
		double i;
		count=0;
		try {
			File file = new File("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/Stud_marks.txt");
			Scanner sc = new Scanner(file);
			do{
				i = sc.nextDouble();
				//System.out.println(i);
				temp_marks[count] = i;
				count++;
			}while(sc.hasNextDouble());
		}
		catch(IOException e) {
			System.out.println("\tCaught : "+e);
		}
	}
	
	public void readDOB() {
		count=0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/Stud_DOB.txt"));
			do {
				str = br.readLine();
				if(!str.equals("stop")) {
					//System.out.println(str);
					dob[count] = str;
					count++;
				}
			}while(!str.equals("stop"));
		}
		catch(IOException e){
			System.out.println("\tCaught : "+e);
		}
		catch(Exception ignored) {
			
		}
		finally {
			try {
				if(br!= null) br.close();
			}
			catch(IOException e) {
				System.out.println("Error Closing Input File...!!!");
			}
		}
	}
	
	public void readContact() {
		count=0;
		try {
			File file = new File("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/Stud_contact.txt");
			Scanner sc = new Scanner(file);
			do{
				long co_num = sc.nextLong();
				//System.out.println(co_num);
				conums[count] = co_num;
				count++;
			}while(sc.hasNextLong());
		}
		catch(IOException e){
			System.out.println("\tCaught : "+e);
		}
	}
	public void readPref() {
		try {
			File file = new File("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/Preferences.txt");
			Scanner sc = new Scanner(file);
			for(int i=0;i<5;i++) {
				for(int j=0;j<7;j++) {
					int temp = sc.nextInt();
					//System.out.println(temp);
					all_pref[i][j] = temp;
				}
			}
		}
		catch(IOException e) {
			System.out.println("\tCaught : "+e);
		}
	}
}