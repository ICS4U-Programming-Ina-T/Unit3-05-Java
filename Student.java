/**
 * The Student program implements an application
 * that receives information from the user, then
 * properly formats and displays it.
 *
 * @author  Ina Tolo
 * @version 1.0
 * @since   2022-5-5
 */

public class Student {
    /**
     * Property for _firstName.
     */
    private String _firstName;
    /**
     * Property for _midInit.
     */
    private String _midInit;
    /**
     * Property for _lastName.
     */
    private String _lastName;
    /**
     * Property for _grade.
     */
    private int _grade;
    /**
     * Property for _iep.
     */
    private boolean _iep;

    /**
     * Constructor for class.
     *
     * @param firstName passed in
     * @param midInit passed in
     * @param lastName passed in
     * @param grade passed in
     * @param iep passed in
     */
    public Student(String firstName, String midInit,
        String lastName, int grade, boolean iep) {
        this._firstName = firstName;
        this._midInit = midInit;
        this._lastName = lastName;
        this._grade = grade;
        this._iep = iep;
    }

    /**
     * Function that displays student format.
     */
    public void print() {
        System.out.println();
        System.out.println("First name: " + _firstName);
        System.out.println("Last name: " + _midInit);
        System.out.println("Middle initial: " + _lastName + ".");
        System.out.println("Grade: " + _grade);
        System.out.println("IEP: " + _iep);
    }
}
