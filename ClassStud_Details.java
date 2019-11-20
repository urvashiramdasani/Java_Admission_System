// class to take details of student
package dotClass;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.*;

//user defined exceptions created
class MarksException extends Exception {
	public String toString() {
		return "Out Of Range Of 1-100...!!!";
	}
}
class NameException extends Exception {
	public String toString() {
		return "Invalid Name... Contains Digits or Special Characters...!!!";
	}
}
class NumException extends Exception {
	public String toString() {
		return "Insufficient Digits in Contact Number...!!!";
	}
}

public class ClassStud_Details extends MobileNumberValidation {
	public String stud_name;
	public double marks;
	public long  coNum;
	public int flag=0;
	public String date;
	
	public void registration() {
		System.out.println("\n\tPhase I : Registration Begins!!!");
		System.out.println("\tAll Students Fill Up Your Details...\n");
	}
	public void getdata() {
		// Code for taking details of student
		Scanner sc = new Scanner(System.in);
		String stud_name;
		double marks;
		long  coNum;
		BufferedWriter writer1 = null;
		BufferedWriter writer2 = null;
		BufferedWriter writer3 = null;
		BufferedWriter writer4 = null;
		try {
			int checkpo = 0;
			do {
				System.out.print("\tEnter Your Name : ");
				stud_name=sc.nextLine();
				String regx = "[a-zA-Z]+\\.?";
				Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(stud_name);
				if(!matcher.find()) {
					try {
						throw new NameException();
					}
					catch(NameException ne) {
						System.out.println("\tCaught : "+ne);
						System.out.println("\tEnter Again...");
						checkpo=1;
					}
					catch(Exception e) {
						System.out.println("\tCaught : "+e);
						checkpo=1;
					}
				}
				else checkpo=0;
			} while(checkpo==1);
			do {
				System.out.print("\tEnter Your Date of Birth in MM/dd/yyyy Format : ");
				date = sc.next();
				checkpo=0;
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");  //parsing date from user
				sdf.setLenient(false); //used to avoid exception
				try {
					Date d = sdf.parse(date);
					checkpo=0;
				}
				catch(Exception e) {
					System.out.println("\tInvalid Date Of Birth...!!!");
					checkpo=1;
				}
			}while(checkpo==1);
			do {
				System.out.print("\tEnter Your Marks (Out of 100) of Nirma Common Entrance Test (NCET) : ");
				marks=sc.nextDouble();
				checkpo=0;
				if(marks<0 || marks>100) {
					try {
						throw new MarksException();
					}
					catch (MarksException me) {
						System.out.println("\tCaught : "+me);
						System.out.println("\tEnter Again...");
						checkpo=1;
					}	
					catch(Exception e) {
						System.out.println("\tCaught : "+e);
						checkpo=1;
					}
				}
				else checkpo=0;
			}while(checkpo==1);
			do {
				System.out.print("\tEnter Your Contact Number : ");
				coNum=sc.nextLong();
				checkpo=0;
				String mobNumber = String.valueOf(coNum);
				if(isValid(mobNumber)==false) {
					try {
						throw new NumException();
					}
					catch (NumException ne) {
						System.out.println("\tCaught : "+ne);
						System.out.println("\tEnter Again...");
						checkpo=1;
					}
					catch(Exception e) {
						System.out.println("\tCaught : "+e);
						checkpo=1;
					}
				}
				else checkpo=0;
			} while(checkpo==1);
			
			//write stu_name to a file 
			writer1 = new BufferedWriter(new FileWriter("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/Stud_name.txt",true));
			writer1.write(stud_name);
			writer1.newLine();
			
			//write date to a file 
			writer4 = new BufferedWriter(new FileWriter("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/Stud_DOB.txt",true));
			writer4.write(date);
			writer4.newLine();
			
			//write marks to a file
			writer2 = new BufferedWriter(new FileWriter("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/Stud_marks.txt",true));
			writer2.write(""+marks);
			writer2.newLine();
			
			//write coNum to a file
			writer3 = new BufferedWriter(new FileWriter("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/Stud_contact.txt",true));
			writer3.write(""+coNum);
			writer3.newLine();
		}
		catch (IOException e) {
			System.out.println("\tCaught : "+e);
		}
		finally {
			try {
				if(writer1!=null) writer1.close();
				if(writer2!=null) writer2.close();
				if(writer3!=null) writer3.close();
				if(writer4!=null) writer4.close();
			}
			catch(IOException e){
				System.out.println("Error Closing Output File...!!!");
			}
		}
	}
}