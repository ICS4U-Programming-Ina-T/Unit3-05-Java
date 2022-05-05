import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * The Main program implements an application that
 * gets input from the user, then uses an object to
 * perform commands in a Stack.
 *
 * @author  Ina Tolo
 * @version 1.0
 * @since   2022-5-5
 */

public class StudentInventory {
    /**
     * Constant for yes response.
     */
    private static final String Y = "Y";
    /**
     * Constant for no response.
     */
    private static final String N = "N";
    /**
     * Constant for error response.
     */
    private static final String ERROR_MESSAGE = "Not a valid option.\n";

    /**
     * Empty constructor.
     */
    public StudentInventory() { }

    public static void main(String[] args) {
        // declaring variables
        Student aStudent;
        Scanner sc = new Scanner(System.in);
        String newStudentCheckLow = "";
        String newStudentCheckUp = "";
        String firstName = "";
        String middleInitial = "";
        String lastName = "";
        int studentGrade;
        boolean studnetIEP;
        List<Student> listOfStudents = new ArrayList<Student>();
        int studentNum = 0;
        int elementNum = 0;
        
        while (newStudentCheckUp != Y || newStudentCheckUp != N) {
            // asks user if they want to enter new studnet
            System.out.print("Do you want to enter a student (y/n)?: ");
            newStudentCheckLow = sc.nextLine();
            
            newStudentCheckUp = newStudentCheckLow.toUpperCase();
            
            if (newStudentCheckUp == Y) {
                System.out.print("How many student would you like to enter?: ");
                studentNum = sc.nextInt();

                while (elementNum <= studentNum) {
                    System.out.print("Enter the first name: ");
                    firstName = sc.nextLine();

                    System.out.print("Enter the middle initial: ");
                    middleInitial = sc.nextLine();

                    System.out.print("Enter the last name: ");
                    lastName = sc.nextLine();

                    System.out.print("Enter the grade: ");
                    studentGrade = sc.nextInt();

                    System.out.print("Enter the IEP status (y/n): ");
                    studnetIEP = sc.nextBoolean();

                    // create a new student
                    aStudent = new Student (firstName, middleInitial, lastName, studentGrade, studnetIEP);

                    listOfStudents.add(aStudent);
                    
                    aStudent.print();

                    elementNum++;
                }
            } else if (newStudentCheckUp == N) {
                System.out.println("Program closed.");
            } else {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }
}
