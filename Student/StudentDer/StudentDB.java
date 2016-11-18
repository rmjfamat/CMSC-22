
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDB {

	List<Student> myList = new ArrayList<Student>();
	Student student = null;
	FileOutputStream fileOut = null;
	ObjectOutputStream out = null;
	FileInputStream fileIn = null;
	ObjectInputStream in = null;
	int choice = 0;
	boolean b = false;
	
	public static void main(String[] args){
		StudentDB studentdb = new StudentDB();
		studentdb.run();
	}
	
	public void run(){
		try {

			fileIn = new FileInputStream("studentdb.txt");
			try {
				in = new ObjectInputStream(fileIn);
				if (in.read() == -1) {
					myList = (List<Student>) in.readObject();
				}

			} catch (EOFException e) {

			}

		} catch (IOException | ClassNotFoundException ce) {
			ce.printStackTrace();
		}

		do {
			System.out.println(
					"\t\tMenu\n\t1. Register Student\n\t2. Search Student\n\t3. Delete Student\n\t4. Save Student\n\t5. Exit\n");
			choice = new Scanner(System.in).nextInt();

			switch (choice) {

			case 1: {

				System.out.println("Student Number:");
				String isStudentNumber = new Scanner(System.in).nextLine();
				check(myList, isStudentNumber);

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

				System.out.println("Crush Name:");
				String isCrushName = new Scanner(System.in).nextLine();

				System.out.println("Favorite Subject Course Code:");
				String isCourseCode = new Scanner(System.in).nextLine();

				System.out.println("Favorite Subject Course Code Description:");
				String isCourseCodeDes = new Scanner(System.in).nextLine();

				student = new Student(isStudentNumber, isFirstName, isMiddleInitial, isLastName, isCourse, isYearLevel,
						isCrushName, new Course(isCourseCode, isCourseCodeDes));
				myList.add(student);
				System.out.println("\nSTUDENT ADDED!");
				break;
			}

			case 2: {

				System.out.println("Search Student:");
				String searchStudentNumber = new Scanner(System.in).nextLine();

				for (Student s : myList) {
					if (s.getStudentNumber().equals(searchStudentNumber)) {
						System.out.println("Student Number: " + s.getStudentNumber() + "\n" + "Name: " + s.getLastName()
								+ ", " + s.getFirstName() + " " + s.getMiddleInitial() + "." + "\n" + "Program: "
								+ s.getCourse() + "\n" + "Year Level: " + s.getYearLevel() + "\n" + "Crush Name:"
								+ s.getCrushName() + "\n" + "Favorite Subject Course Code:" + s.getFavSubject() + "\n");

						b = true;
						break;
					}
				}
				if (b == false) {
					System.out.println("Student does not exist!\n");
				}

				break;
			}

			case 3: {
				System.out.println("Delete Student:");
				String deleteStudent = new Scanner(System.in).nextLine();
				for (Student s : myList) {
					if (s.getStudentNumber().equals(deleteStudent)) {
						myList.remove(s);
						System.out.println("\nStudent " + s.getStudentNumber() + " deleted!\n");
						b = true;
						break;
					}
				}
				if (b == false) {
					System.out.println("Cannot remove student. No such student found.\n");
				}
				break;

			}

			case 4: {
				try {

					fileOut = new FileOutputStream("studentdb.txt");
					out = new ObjectOutputStream(fileOut);

					out.writeObject(myList);
					out.close();
					fileOut.close();

					System.out.println("Saved!\n");

				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			}

			case 5: {
				System.out.println("Exit!");
				break;
			}
			default:
				throw new IllegalArgumentException("Invalid input!\n");
			}
		} while (choice != 5);
	}
	
	
	private static void check(List<Student> myList, String studentNumber) {
		for (Student s : myList) {
			if (s.getStudentNumber().equals(studentNumber)) {
				throw new IllegalArgumentException("Student already exist!");
			}
		}
	}

}