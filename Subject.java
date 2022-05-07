/**
 * The Subject program implements an application
 * that receives information from the user, then
 * properly formats and displays it.
 *
 * @author  Ina Tolo
 * @version 1.0
 * @since   2022-5-5
 */

public class Subject {
    /**
     * Property for _bestSubject.
     */
    private String _bestSubject;
    /**
     * Property for _worstSubject.
     */
    private String _worstSubject;

    /**
     * Constructor for class.
     *
     * @param bestSubject passed in
     * @param worstSubject passed in
     */
    public Subject(String bestSubject, String worstSubject) {
        this._bestSubject = bestSubject;
        this._worstSubject = worstSubject;
    }

    /**
     * Function that formats and displays student subjects.
     */
    public void print() {
        System.out.println("Best subject: " + _bestSubject);
        System.out.println("Worst subject: " + _worstSubject);
    }
}
