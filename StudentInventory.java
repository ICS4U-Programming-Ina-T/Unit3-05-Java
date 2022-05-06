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
        Student aStudent;
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
        int studentGrade;
        boolean studnetIep;
        List<Student> listOfStudents = new ArrayList<Student>();
        int studentNum = 0;
        int elementNum = 0;

        while (newStudentCheckUp != Y || newStudentCheckUp != N) {
            // asks user if they want to enter new studnet
            System.out.print("Do you want to enter a student (Y/N)?: ");
            newStudentCheckLow = userInput.nextLine();

            newStudentCheckUp = newStudentCheckLow.toUpperCase();

            if (Y.equals(newStudentCheckUp)) {
                System.out.print("How many students "
                    + "would you like to enter?: ");
                studentNumString = userInput.nextLine();

                try {
                    studentNum = Integer.parseInt(studentNumString);

                    if (studentNum < 0) {
                        System.out.println(ERROR_MESSAGE);
                        continue;
                    }

                    while (elementNum != studentNum) {
                        // gets users information
                        System.out.print("Enter the first name: ");
                        firstName = userInput.nextLine();

                        System.out.print("Enter the middle initial: ");
                        middleInitial = userInput.nextLine();

                        System.out.print("Enter the last name: ");
                        lastName = userInput.nextLine();

                        System.out.print("Enter the grade: ");
                        studentGradeString = userInput.nextLine();

                        try {
                            studentGrade = Integer.parseInt(
                                studentGradeString);

                            if (studentGrade < 1
                                || studentGrade > MAX_GRADE) {
                                System.out.println(ERROR_MESSAGE);
                                continue;
                            }
                        } catch (IllegalArgumentException exception) {
                            System.out.println(ERROR_MESSAGE);
                        }

                        System.out.print("Enter the IEP "
                            + "status (true/false): ");
                        studentIepString = userInput.nextLine();

                        studentIepStringLow =
                            studentIepString.toLowerCase();

                        try {
                            studnetIep = Boolean.parseBoolean(
                                studentIepStringLow);

                            // create a new student
                            aStudent = new Student(firstName, middleInitial,
                                lastName, studentGrade, studnetIep);

                            // adds student object to the list
                            listOfStudents.add(aStudent);

                            aStudent.print();

                            elementNum++;
                        } catch (IllegalArgumentException
                            exception) {
                            System.out.println(ERROR_MESSAGE);
                        }
                    }
                    break;
                } catch (IllegalArgumentException exception) {
                    System.out.println(ERROR_MESSAGE);
                }
            } else if (N.equals(newStudentCheckUp)) {
                System.out.println("Program closed.");
                break;
            } else {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }
}
