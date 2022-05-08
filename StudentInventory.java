import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The StudentInventory program implements an application
 * that gets input from the user, stores it in an object,
 * then uses a separate class to properly print it.
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
     * Constant for max grade.
     */
    private static final int MAX_GRADE = 12;
    /**
     * Constant for true as a string.
     */
    private static final String TRUE = "true";
    /**
     * Constant for false as a string.
     */
    private static final String FALSE = "false";

    /**
     * Empty constructor.
     */
    public StudentInventory() { }

    /**
     * Main entry into program.
     *
     * @param args nothing passed in
     */
    public static void main(String[] args) {
        // declaring variables
        Scanner userInput = new Scanner(System.in);
        String newStudentCheckLow = "";
        String newStudentCheckUp = "";
        String studentNumString = "";
        String studentGradeString = "";
        String studentIepString = "";
        String studentIepStringLow = "";
        String firstName = "";
        String middleInitial = "";
        String lastName = "";
        String bestSubject = "";
        String worstSubject = "";
        int studentGrade = 0;
        boolean studentIep = false;
        List<Student> listOfStudents = new ArrayList<Student>();
        List<Subject> listofSubjectHistory = new ArrayList<Subject>();
        int studentNum = -1;
        int elementNum = 0;

        // create a new student
        Student aStudent = new Student(firstName, middleInitial,
            lastName, studentGrade, studentIep);

        // create a new subject history
        Subject aSubject = new Subject(bestSubject, worstSubject);

        while (newStudentCheckUp != Y || newStudentCheckUp != N) {
            // asks user if they want to enter new studnet
            System.out.print("Do you want to enter a student (Y/N)?: ");
            newStudentCheckLow = userInput.nextLine();

            newStudentCheckUp = newStudentCheckLow.toUpperCase();

            // checks if user wants to add a student
            if (Y.equals(newStudentCheckUp)) {
                while (studentNum < 0) {
                    System.out.print("How many students "
                        + "would you like to enter?: ");
                    studentNumString = userInput.nextLine();

                    try {
                        studentNum = Integer.parseInt(studentNumString);

                        // checks for negative input
                        if (studentNum < 0) {
                            System.out.println(ERROR_MESSAGE);
                            continue;
                        }

                        while (elementNum != studentNum) {
                            System.out.println();
                            // gets users information
                            System.out.print("Enter the first name: ");
                            firstName = userInput.nextLine();

                            System.out.print("Enter the middle initial: ");
                            middleInitial = userInput.nextLine();

                            System.out.print("Enter the last name: ");
                            lastName = userInput.nextLine();

                            while (studentGrade < 1
                                || studentGrade > MAX_GRADE) {
                                System.out.print("Enter the grade: ");
                                studentGradeString = userInput.nextLine();

                                try {
                                    studentGrade = Integer.parseInt(
                                        studentGradeString);

                                    // checks if student grade is within valid range
                                    if (studentGrade < 1
                                        || studentGrade > MAX_GRADE) {
                                        System.out.println(ERROR_MESSAGE);
                                        continue;
                                    } else {
                                        break;
                                    }
                                } catch (IllegalArgumentException exception) {
                                    System.out.println(ERROR_MESSAGE);
                                }
                            }

                            while (studentIepStringLow != TRUE
                                || studentIepStringLow != FALSE) {
                                // gets input for IEP status
                                System.out.print("Enter the IEP "
                                    + "status (true/false): ");
                                studentIepString = userInput.nextLine();

                                studentIepStringLow =
                                    studentIepString.toLowerCase();

                                // checks if input can be accepted,
                                // the converts to boolean value
                                if (TRUE.equals(studentIepStringLow)
                                    || FALSE.equals(studentIepStringLow)) {
                                    studentIep = Boolean.parseBoolean(
                                        studentIepStringLow);
                                    break;
                                } else {
                                    System.out.println(ERROR_MESSAGE);
                                    continue;
                                }
                            }

                            // gets input about best and worst subjects
                            System.out.print("Enter the student's"
                                + " best subject: ");
                            bestSubject = userInput.nextLine();

                            System.out.print("Enter the student's "
                                + "worst subject: ");
                            worstSubject = userInput.nextLine();

                            aStudent = new Student(firstName, middleInitial,
                                lastName, studentGrade, studentIep);

                            // adds student object to list
                            listOfStudents.add(aStudent);

                            aSubject = new Subject(bestSubject, worstSubject);

                            // adds subject object to list
                            listofSubjectHistory.add(aSubject);
                            
                            // resets student grade
                            studentGrade = -1;
                            
                            // increments counter
                            elementNum++;
                        }
                        int stuLength = listOfStudents.size();

                        System.out.println("\n---------------------------"
                            + "---------------------\n");
                        System.out.println("There are " + stuLength
                            + " students in the student list.");
                        System.out.println("The students are:");

                        // calls function to print information
                        for (int counter = 0; counter
                            < listOfStudents.size(); counter++) {
                            listOfStudents.get(counter).print();
                            listofSubjectHistory.get(counter).print();
                        }
                    } catch (IllegalArgumentException exception) {
                        System.out.println(ERROR_MESSAGE);
                    }
                }
                break;
            } else if (N.equals(newStudentCheckUp)) {
                System.out.println("Program closed.");
                break;
            } else {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }
}
