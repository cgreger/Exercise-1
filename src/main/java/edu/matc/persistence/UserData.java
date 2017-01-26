package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM users";

        try {
            database.connect();
            connection = database.getConnection();

            logger.info("Connected to the database.");
            logger.error("Error level logging demo...");
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
            logger.info("Disconnected from the database.");
        } catch (SQLException e) {
            logger.error("SQL Exception:", e); //comma e to append to log

        } catch (Exception e) {
            logger.error("SQL Exception:", e);
        }
        return users;
    }

    public List<User> getUsersByLastName(String lastName) {

        List<User> foundUsers = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        PreparedStatement findUsersByLastName = null;
        String sql = "SELECT * FROM users WHERE last_name = ?"; // Search by last name query

        try {

            // Connect to the database
            database.connect();
            connection = database.getConnection();

            // Create a prepared statement to search by last name
            findUsersByLastName = connection.prepareStatement(sql);

            // Bind parameters
            findUsersByLastName.setString(1, lastName);

            // Run the query and get the results
            ResultSet results = findUsersByLastName.executeQuery(); // WHEN DOING PREPARED STMT MAKE SURE QUERY
                                                                    // STRING IS NOT IN THE PARAMETERS!!!
                                                                    // Errors for DAYS.

            // Add each found user to the found users list
            while (results.next()) {
                User employee = createUserFromResults(results);
                foundUsers.add(employee);
            }

            // Disconnect from the database
            database.disconnect();

        } catch (SQLException e) {
            System.out.println("SearchUser.getAllUsers()...SQL Exception: " + e);
        } catch (Exception e) {
            System.out.println("SearchUser.getAllUsers()...Exception: " + e);
        }

        // Return the users list
        return foundUsers;

    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setDateOfBirth(results.getString("date_of_birth"));
        user.setUserid(results.getString("id"));

        return user;
    }

}