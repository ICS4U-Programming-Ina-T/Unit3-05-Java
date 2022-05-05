/**
 * The Main program implements an application that
 * gets input from the user, then uses an object to
 * perform commands in a Stack.
 *
 * @author  Ina Tolo
 * @version 1.0
 * @since   2022-5-5
 */

public class Student {
    // properties
    String _firstName;
    String _midInit;
    String _lastName;
    int _grade;
    boolean _iep;

    /**
     * Constructor for class.
     */
    public Student (String firstName, String midInit,  String lastName, int grade, boolean IEP) {
        this._firstName = firstName;
        this._midInit = midInit;
        this._lastName = lastName;
        this._grade = grade;
        this._iep = IEP;
    }

    public void print () {
        // displays student format
        System.out.println("First name: " + _firstName);
        System.out.println("Last name: " + _midInit);
        System.out.println("Middle initial: " + _lastName);
        System.out.println("Grade: " + _grade);
        System.out.println("IEP: " + _iep);
    }
}
