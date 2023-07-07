
package stack.app;

/**
 *
 * @author fawad
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            // Establish a connection to the MySQL database
            String url = "jdbc:mysql://localhost:3306/store?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String username = "fawad";
            String password = "fawad321.";
            connection = DriverManager.getConnection(url, username, password);
            
            System.out.println("Connected to the database.");
            
            // Create a statement object
            statement = connection.createStatement();
            
            // Execute the query and retrieve the result set
            String selectQuery = "SELECT * FROM users";
            resultSet = statement.executeQuery(selectQuery);
            
            // Process the result set
            System.out.println("Users:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }
        } catch (SQLException e) {
            System.err.println("Error executing the query: " + e.getMessage());
        } finally {
            // Close the result set, statement, and connection
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
