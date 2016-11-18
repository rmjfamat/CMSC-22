import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainStudent {


    public static void main(String[] args) {

    	List<Student> myList = new ArrayList<Student>();
    	Student student = null;
    	BufferedReader br = null;
    	
        String studentNumber = null;
        String firstName = null;
        String lastName = null;
        String course = null;
        char middleInitial = 'a';
        int yearLevel = 0;
        int count = 0;
        
        
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("testing.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
            	
            	count++;      
                if(count == 1){
                	studentNumber = sCurrentLine;
                }
                if(count == 2){
                	firstName = sCurrentLine;
                }
                if(count == 3){
                	middleInitial = sCurrentLine.charAt(0);
                }
                if(count == 4){
                	lastName = sCurrentLine;
                }
                if(count == 5){
                	course = sCurrentLine;
                }
                if(count == 6){
                	yearLevel = Integer.parseInt(sCurrentLine);
                	count = 0;
                	student = new Student(studentNumber, firstName, middleInitial, lastName, course, yearLevel);
                	myList.add(student);
                }
            }

        } catch (IOException m) {
            m.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        int choice;
		do{
			System.out.println("\t\tMenu\n\t1. Register Student\n\t2. Search Student\n\t3. Delete Student\n\t4. Save Student\n\t5. Exit");
			choice = new Scanner(System.in).nextInt();
			
	        switch (choice) {
	        
		        case 1: {
		        	        	
		        	System.out.println("Student Number:");
		        	String isStudentNumber = new Scanner(System.in).nextLine();
		        	
		        	System.out.println("First Name:");
		        	String isFirstName = new Scanner(System.in).nextLine();
		        	
		        	System.out.println("Middle Initial:");
		        	char isMiddleInitial = new Scanner(System.in).next(".").charAt(0);
		        	
		        	System.out.println("Last Name:");
		        	String isLastName = new Scanner(System.in).nextLine();
		        	
		        	System.out.println("Degree Program:");
		        	String isCourse = new Scanner(System.in).nextLine();
		        	
		        	System.out.println("Year Level:");
		        	int isYearLevel = new Scanner(System.in).nextInt();
		        	
		        	student = new Student(isStudentNumber, isFirstName, isMiddleInitial, isLastName, isCourse, isYearLevel);
		        	myList.add(student);
		        	System.out.println("\nSTUDENT ADDED!");
		        	break;
		        }
		        
		        case 2: {
		        	
		        	System.out.println("Search Student:");
		        	String searchStudentNumber = new Scanner(System.in).nextLine();
		        	
		        	 for(Student s: myList) {
		                 if(s.getStudentNumber().equals(searchStudentNumber)){
		                	 System.out.println(s);
		                	 break;
		                 }                 
		             }
		        	 break; 
		        }
		        
		        case 3: {
		        	System.out.println("Delete Student:");
		        	String deleteStudent = new Scanner(System.in).nextLine();
		        	for(Student s: myList) {
		                if(s.getStudentNumber().equals(deleteStudent)){
		               	 myList.remove(s);
		               	 break;
		                }
		            }
		        	      	
		        	System.out.println("\nSTUDENT DELETED!");
		        	break;
		        	
		        }
		        
		        case 4: {
		        	try {
		                File file = new File("testing.txt");
		                if (!file.exists()) {
		                    file.createNewFile();
		                }
	
		                FileWriter fw = new FileWriter(file);
		                BufferedWriter bw = new BufferedWriter(fw);
		                for(Student s: myList) {
		                	bw.write(s.getStudentNumber());
		                	bw.newLine();
		                	bw.write(s.getFirstName());
		                	bw.newLine();
		                	bw.write(s.getMiddleInitial());
		                	bw.newLine();
		                	bw.write(s.getLastName());
		                	bw.newLine();
		                	bw.write(s.getCourse());
		                	bw.newLine();
		                	bw.write(s.getYearLevel() + "");
		                	bw.newLine();
			             }
		                bw.close();
	
		                System.out.println("Done");
	
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        	break;
		        	
		        }
		        
		        case 5: {
		        	System.out.println("Exit!");
		        	break;
		        }
	        }
		}while(choice != 5);
		
    }
}