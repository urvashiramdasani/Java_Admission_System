//class for final admission process
package dotClass;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class admission extends sortAllTypes {
	public int counter = 0;
	public String branch [] = new String[5];
	public String name [] = new String[5000];
	public String dob [] = new String [5000];
	public long conums [] = new long [5000];
	public double temp_marks [] = new double [5000];
	public String str = new String();
	public int size [] = new int [5];
	public int seats [] = new int [7];
	// Seats follow the order same as they were displayed in Technology_Branches.txt
	public void getSeats() {
		count=0;
		try {
			File file = new File("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/No_Of_Seats.txt");
			Scanner sc = new Scanner(file);
			while(sc.hasNextInt()) {
				int var = sc.nextInt();
				seats[counter] = var;
				//System.out.println(seats[counter]);
				counter++;
			} 
		}
		catch(IOException e) {
			System.out.println("\tCaught : "+e);
		}
		catch(ArrayIndexOutOfBoundsException aob) {
			System.out.println("\tCaught : "+aob);
		}
	}
	
	public void readPreferences () {
		try {
			File file = new File("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/sorted_Preferences.txt");
			Scanner sc = new Scanner(file);
			for(int i=0;i<5;i++) {
				for(int j=0;j<7;j++) {
					all_pref[i][j] = sc.nextInt();
				}
			}
		}
		catch(IOException e) {
			System.out.println("\tCaught : "+e);
		}
	}
	public void getArraySize() {
		for(int i=0;i<5;i++) {
			int count = 0;
			for(int j=0;j<7;j++){
				if(all_pref[i][j]!=0) count++;
			}
			size[i]=count;
		}
	}
	public void writeSeatsLeft() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/NewSeats.txt"));
			for(int i=0;i<7;i++) {
				bw.write(""+seats[i]);
				bw.newLine();
			}
		}
		catch(IOException e) {
			System.out.println("\tCaught : "+e);
		}
		finally {
			try {
				if(bw!=null) bw.close();
			}
			catch(IOException e) {
				System.out.println("Error Closing Output File...!!!");
			}
		}
	}
	
	public void readsortedNames() {
		BufferedReader br = null;
		String s = new String();
 		try {
			br = new BufferedReader(new FileReader("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/sorted_Names.txt"));
			count=0;
			do {
				s = br.readLine();
				if(!s.equals("stop")) {
					//System.out.println(str);
					name[count] = s;
					count++;
				} 
			} while(!s.equals("stop"));
		}
		catch(IOException e) {
			System.out.println("\tCaught : "+e);
		}
		catch(Exception ignored){
			
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
	
	public void readsortedMarks () {
		double i;
		count=0;
		try {
			File file = new File("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/sorted_Marks.txt");
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
	
	public void readsortedDOB() {
		count=0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/sorted_DOB.txt"));
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
		catch(Exception ignored){

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
	public void readsortedContacts() {
		count=0;
		try {
			File file = new File("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/sorted_Contacts.txt");
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
	
	public void display(int i) {
		System.out.println("\n    Student Profile : ");
		System.out.println("    Name : "+name[i]);
		System.out.println("    Marks : "+temp_marks[i]);
		System.out.println("    Date of Birth : "+dob[i]);
		System.out.println("    Contact Number : "+conums[i]);
		try {
			TimeUnit.SECONDS.sleep(3);
		}
		catch(InterruptedException e)
		{
			System.err.format("IOException : %s%n",e);
		}
	}
	
	public void checkSeats() 
	{
		System.out.println("\n\tPhase II : Admission Starts...");
		//calling all methods
		BufferedWriter br = null;
		try{
		char choice;
		br=new BufferedWriter(new FileWriter("C:/Users/Urvashi/Desktop/OOP Project/TextFiles/finalList.txt",true));
		Scanner sc = new Scanner(System.in);
		//System.out.println(count);
		//for(int i=0;i<5;i++) {
		//	System.out.println(all_pref[i]);
		//}
		for(int i=0;i<5;i++) {
			int ch = 0;
			display(i);
			//System.out.println("hi");
			do {
				if(all_pref[i][ch]==1 && seats[0]>0) {
				System.out.println("\n    Congratulations! You got Admission in Computer Science Branch");
				System.out.println("    ------------------------------------------------------------------");
				int m=0;
					do{
					if(m!=0)
					{
						System.out.print("    Your Input is Wrong... Please Enter Again...");
					}
				System.out.print("    You want to keep this seat? (Enter Y for Yes and N for No) : ");
				choice = sc.next().charAt(0);
				
					if(choice=='y' || choice=='Y') {
						System.out.println("\n    Welcome to Computer Science Department!");
						//branch[i] = "Computer Science"
						seats[0]--;
						flag=1;
						br.write("Name : "+name[i]+"\t");
						br.write("Date of birth : "+dob[i]+"\t");
						br.write("Contact Number : "+conums[i]+"\t");
						br.write("Computer Science");
						br.newLine();
					}
					else if(choice=='n' || choice=='N') {
						if(ch>size[i]) {
							System.out.println("\n    All Seats are Occupied...!!!");
							System.out.println("    Better Luck Next Time...!!!");
							flag=1;
						}
						else {
							System.out.println("    Considering your Next Preference...");
							ch++;
							flag=0;
						}
					}
					else
						m++;
					}
					while(choice!='Y' && choice!='y' && choice !='n' && choice!='N');
						try {
								TimeUnit.SECONDS.sleep(3);
							}
						catch(InterruptedException e)
							{
								System.err.format("IOException : %s%n",e);
							}
				}
				else if(all_pref[i][ch]==1 && seats[0]<=0) {
					if(ch>size[i]) {
						System.out.println("\n    All Seats are Occupied...!!!");
						System.out.println("    Better Luck Next Time...!!!");
						flag=1;
					}
					else {
						System.out.println("\n    Sorry, There are no seats left in Computer Science Department!");
						System.out.println("\n    Considering Your Next Preference...");
						ch++;
						flag=0;
					}
						try {
								TimeUnit.SECONDS.sleep(3);
							}
						catch(InterruptedException e)
							{
								System.err.format("IOException : %s%n",e);  
							}					
				}
				else if(all_pref[i][ch]==2 && seats[1]>0) {
					System.out.println("\n    Congratulations! You got Admission in Electronics and Communication Branch");
					System.out.println("     --------------------------------------------------------------------------------");
					int m=0;
					do{
					if(m!=0)
					{
						System.out.print("    Your Input is Wrong... Please Enter Again...");
					}
					System.out.print("    You want to keep this seat? (Enter Y for Yes and N for No) : ");
						choice = sc.next().charAt(0);
					if(choice=='y' || choice=='Y') {
						System.out.println("\n    Welcome to Electronics and Communication Department!");
						seats[1]--;
						flag=1;
						br.write("Name : "+name[i]+"\t");
						br.write("Date of birth : "+dob[i]+"\t");
						br.write("Contact Number : "+conums[i]+"\t");
						br.write("Electronics And Communiaction");
						br.newLine();
					}
					else if(choice=='n' || choice=='N') {
						if(ch>size[i]) {
							System.out.println("\n    All Seats are Occupied...!!!");
							System.out.println("    Better Luck Next Time...!!!");
							flag=1;
						}
						else {
							System.out.println("\n\n    Considering your Next Preference...");
							ch++;
							flag=0;
						}
					}else
						m++;
					}
					while(choice!='Y' && choice!='y' && choice !='n' && choice!='N');
						try {
								TimeUnit.SECONDS.sleep(3);
							}
						catch(InterruptedException e)
							{
								System.err.format("IOException : %s%n",e);
							}					
				}
				else if(all_pref[i][ch]==2 && seats[1]<=0) {
					if(ch>size[i]) {
						System.out.println("\n    All Seats are Occupied...!!!");
						System.out.println("    Better Luck Next Time...!!!");
						flag=1;
					}
					else {
						System.out.println("\n    Sorry, There are no seats left in Electronics and Communication Department!");
						System.out.println("\n\n    Considering Your Next Preference...");
						ch++;
						flag=0;
					}
						try {
								TimeUnit.SECONDS.sleep(3);
							}
						catch(InterruptedException e)
							{
								System.err.format("IOException : %s%n",e);
							}					
				}
				else if(all_pref[i][ch]==3 && seats[2]>0) {
					System.out.println("\n    Congratulations! You got Admission in Mechanical Branch");
					System.out.println("------------------------------------------------------------");
					int m=0;
					do{
					if(m!=0)
					{
						System.out.print("    Your Input is Wrong... Please Enter Again...");
					}
					System.out.print("    You want to keep this seat? (Enter Y for Yes and N for No): ");
					choice = sc.next().charAt(0);
					if(choice=='y' || choice=='Y') {
						System.out.println("\n    Welcome to Mechanical Department!");
						seats[2]--;
						flag=1;
						br.write("Name : "+name[i]+"\t");
						br.write("Date of birth :"+dob[i]+"\t");
						br.write("Contact Number :"+conums[i]+"\t");
						br.write("Mechanical");	
						br.newLine();
					}
					else if(choice=='n' || choice=='N') {
						if(ch>size[i]) {
							System.out.println("\n    All Seats are Occupied...!!!");
							System.out.println("    Better Luck Next Time...!!!");
							flag=1;
						}
						else {
							System.out.println("\n\n    Considering your Next Preference...");
							ch++;
							flag=0;
						}
					}
					else
						m++;
					}
					while(choice!='Y' && choice!='y' && choice !='n' && choice!='N');
						try {
								TimeUnit.SECONDS.sleep(3);
							}
						catch(InterruptedException e)
							{
								System.err.format("IOException : %s%n",e);
							}					
				}
				else if(all_pref[i][ch]==3 && seats[2]<=0) {
					if(ch>size[i]) {
						System.out.println("\n    All Seats are Occupied...");
						System.out.println("    Better Luck Next Time...");
						flag=1;
					}
					else {
						System.out.println("\n    Sorry, There are no seats left in Mechanical Department!");
						System.out.println("\n\n    Considering Your Next Preference...");
						ch++;
						flag=0;
					}
						try {
								TimeUnit.SECONDS.sleep(3);
							}
						catch(InterruptedException e)
							{
								System.err.format("IOException : %s%n",e);
							}					
				}
				else if(all_pref[i][ch]==4 && seats[3]>0) {
					System.out.println("\n    Congratulations! You got Admission in Electrical Branch");
					System.out.println("------------------------------------------------------------");
					int m=0;
					do{
					if(m!=0)
					{
						System.out.print("    Your Input is Wrong... Please Enter Again...");
					}
					System.out.print("    You want to keep this seat? (Enter Y for Yes and N for No) : ");
					choice = sc.next().charAt(0);
					if(choice=='y' || choice=='Y') {
						System.out.println("\n    Welcome to Electrical Department!");
						seats[3]--;
						flag=1;
						br.write("Name : "+name[i]+"\t");
						br.write("Date of birth : "+dob[i]+"\t");
						br.write("Contact Number : "+conums[i]+"\t");
						br.write("Electrical");
						br.newLine();
					}
					else if(choice=='n' || choice=='N') {
						if(ch>size[i]) {
							System.out.println("\n    All Seats are Occupied...");
							System.out.println("    Better Luck Next Time...");
							flag=1;
						}
						else {
							System.out.println("\n\n    Considering your Next Preference...");
							ch++;
							flag=0;
						}
					}
					else
						m++;
					}
					while(choice!='Y' && choice!='y' && choice !='n' && choice!='N');
						try {
								TimeUnit.SECONDS.sleep(3);
							}
						catch(InterruptedException e)
							{
								System.err.format("IOException : %s%n",e);
							}					
				}
				else if(all_pref[i][ch]==4 && seats[3]<=0) {
					if(ch>size[i]) {
						System.out.println("\n    All Seats are Occupied...");
						System.out.println("    Better Luck Next Time...");
						flag=1;
					}
					else {
						System.out.println("\n    Sorry, There are no seats left in Electrical Department!");
						System.out.println("\n\n    Considering Your Next Preference...");
						ch++;
						flag=0;
					}
						try {
								TimeUnit.SECONDS.sleep(3);
							}
						catch(InterruptedException e)
							{
								System.err.format("IOException : %s%n",e);
							}					
				}
				else if(all_pref[i][ch]==5 && seats[4]>0) {
					System.out.println("\n    Congratulations! You got Admission in Instrumentation and Control Branch");
					System.out.println("------------------------------------------------------------");
					int m=0;
					do{
					if(m!=0)
					{
						System.out.print("    Your Input is Wrong... Please Enter Again...");
					}
					System.out.print("    You want to keep this seat? (Enter Y for Yes and N for No) : ");
					choice = sc.next().charAt(0);
					if(choice=='y' || choice=='Y') {
						System.out.println("\n    Welcome to Instrumentation and Control Department!");
						seats[4]--;
						flag=1;
						br.write("Name : "+name[i]+"\t");
						br.write("Date Of Birth : "+dob[i]+"\t");
						br.write("Contact Number : "+conums[i]+"\t");
						br.write("Instrumentation and Control");
						br.newLine();
					}
					else if(choice=='n' || choice=='N') {
						if(ch>size[i]) {
							System.out.println("\n    All Seats are Occupied..");
							System.out.println("    Better Luck Next Time...");
							flag=1;
						}
						else {
							System.out.println("\n\n    Considering your Next Preference...");
							ch++;
							flag=0;
						}
					}
					else
						m++;
					}
					while(choice!='Y' && choice!='y' && choice !='n' && choice!='N');
						try {
								TimeUnit.SECONDS.sleep(3);
							}
						catch(InterruptedException e)
							{
								System.err.format("IOException : %s%n",e);
							}					
				}
				else if(all_pref[i][ch]==5 && seats[4]<=0) {
					if(ch>size[i]) {
						System.out.println("\n    All Seats are Occupied...!!!");
						System.out.println("    Better Luck Next Time...!!!");
						flag=1;
					}
					else {
						System.out.println("\n    Sorry, There are no seats left in Instrumentation and Control Department!");
						System.out.println("\n\n    Considering Your Next Preference...");
						ch++;
						flag=0;
					}
						try {
								TimeUnit.SECONDS.sleep(3);
							}
						catch(InterruptedException e)
							{
								System.err.format("IOException : %s%n",e);
							}
				}
				else if(all_pref[i][ch]==6 && seats[5]>0) {
					System.out.println("\n    Congratulations! You got Admission in Chemical Branch");
					System.out.println("------------------------------------------------------------");
					int m=0;
					do{
					if(m!=0)
					{
						System.out.print("    Your Input is Wrong... Please Enter Again...");
					}
					System.out.print("    You want to keep this seat? (Enter Y for Yes and N for No) : ");
					choice = sc.next().charAt(0);
					if(choice=='y' || choice=='Y') {
						System.out.println("\n    Welcome to Chemical Department!");
						seats[5]--;
						flag=1;
						br.write("Name : "+name[i]+"\t");
						br.write("Date of birth : "+dob[i]+"\t");
						br.write("Contact Number : "+conums[i]+"\t");
						br.write("Chemical");
						br.newLine();
					}
					else if(choice=='n' || choice=='N') {
						if(ch>size[i]) {
							System.out.println("\n    All Seats are Occupied...!!!");
							System.out.println("    Better Luck Next Time...!!!");
							flag=1;
						}
						else {
							System.out.println("\n\n    Considering your Next Preference...");
							ch++;
							flag=0;
						}
					}
					else
						m++;
					}
					while(choice!='Y' && choice!='y' && choice !='n' && choice!='N');
						try {
								TimeUnit.SECONDS.sleep(3);
							}
						catch(InterruptedException e)
							{
								System.err.format("IOException : %s%n",e);
							}					
				}
				else if(all_pref[i][ch]==6 && seats[5]<=0) {
					if(ch>size[i]) {
						System.out.println("\n    All Seats are Occupied...!!!");
						System.out.println("    Better Luck Next Time...!!!");
						flag=1;
					}
					else {
						System.out.println("\n    Sorry, There are no seats left in Chemical Department!");
						System.out.println("\n\n    Considering Your Next Preference...");
						ch++;
						flag=0;
					}
						try {
								TimeUnit.SECONDS.sleep(3);
							}
						catch(InterruptedException e)
							{
								System.err.format("IOException : %s%n",e);
							}					
				}
				else if(all_pref[i][ch]==7 && seats[6]>0) {
					System.out.println("\n    Congratulations! You got Admission in Civil Branch");
					System.out.println("------------------------------------------------------------");
					int m=0;
					do{
					if(m!=0)
					{
						System.out.print("    Your Input is Wrong... Please Enter Again...");
					}
					System.out.print("    You want to keep this seat? (Enter Y for Yes and N for No) : ");
					choice = sc.next().charAt(0);
					if(choice=='y' || choice=='Y') {
						System.out.println("\n    Welcome To Civil Department     ");
						seats[6]--;
						flag=1;
						br.write("Name : "+name[i]+"\t");
						br.write("Date Of Birth : "+dob[i]+"\t");
						br.write("Contact Number : "+conums[i]+"\t");
						br.write("Civil");
						br.newLine();
					}
					else if(choice=='n' || choice=='N') {
						if(ch>size[i]) {
							System.out.println("\n    All Seats are Occupied...!!!");
							System.out.println("    Better Luck Next Time...!!!");
							flag=1;
						}
						else {
							System.out.println("\n\n    Considering your Next Preference...");
							ch++;
							flag=0;
						}
					}
					else
						m++;
					}
					while(choice!='Y' && choice!='y' && choice !='n' && choice!='N');
						try {
								TimeUnit.SECONDS.sleep(3);
							}
						catch(InterruptedException e)
							{
								System.err.format("IOException : %s%n",e);
							}					
				}
				else if(all_pref[i][ch]==7 && seats[6]<=0) {
					if(ch>size[i]) {
						System.out.println("\n    All Seats are Occupied...!!!");
						System.out.println("    Better Luck Next Time...!!!");
						System.out.println("------------------------------------------------------------");
						flag=1;
					}
					else {
						System.out.println("\n    Sorry, There are no seats left in Civil Department!");
						System.out.println("\n\n    Considering Your Next Preference...");
						ch++;
						flag=0;
					}
						try {
								TimeUnit.SECONDS.sleep(3);
							}
						catch(InterruptedException e)
							{
								System.err.format("IOException : %s%n",e);
							}					
				}
				else if(all_pref[i][ch]==0) {
				break;
				}
			} while(flag==0 && ch<size[i]);
			if(flag==0 && ch>=size[i]) {
				System.out.println("\n    Could Not Find Branch Suitable For You!");
				System.out.println("------------------------------------------------------------");
				br.write("Name : "+name[i]+"\t");
				br.write("Date Of Birth :"+dob[i]+"\t");
				br.write("Contact Number :"+conums[i]+"\t");
				br.write("Admission Cancelled");
				br.newLine();
			}
		}
	}
	catch(IOException e){System.out.println("Caught : "+e);}
	finally{try{if(br!=null)br.close();}catch(IOException e){System.out.println("Error Closing Output File...!!!");}}
	}
}