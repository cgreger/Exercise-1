package edu.matc.entity;

// Add instance variable for the date of birth
// Add a calculation for the user's age. Age should not be stored, it should be calculated only.

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.joda.time.*;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
public class User {

    private String firstName;
    private String lastName;
    private String userid;
    private String dateOfBirth;


    /**
     * Instantiates a new User.
     */
    public User() {}

    /**
     * Instantiates a new User.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param userid      the userid
     * @param dateOfBirth the date of birth
     */
    public User(String firstName, String lastName, String userid, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userid = userid;
        this.dateOfBirth = dateOfBirth;
    }

    public int calculateUserAge() {

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.parse(dateOfBirth);
        Period diff = new Period(birthday, today);

        int age = diff.getYears();

        return age;

    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * Gets dateOfBirth.
     *
     * @return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets dateOfBirth.
     *
     * @param dateOfBirth the dateOfBirth
     */
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userid='" + userid + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }


}