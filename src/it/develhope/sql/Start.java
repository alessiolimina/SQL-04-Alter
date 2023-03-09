package it.develhope.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/** This is a Tester class
 * @author alessiolimina
 */

public class Start {
    public static void main(String[] args) throws SQLException {


        /** Creating a null Connection conn */
        Connection conn = null;

        /** Creating a try/catch statement */
        try {

         /** Getting the connection 'conn' using Driver Manager and 3 parameters
         * @param url is the url of the database newdb
         * @param user is the MySQL developer user
         * @param password is the password used for MySQL developer account
         */
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "***********");

         /** Creating a new 'conn' statement using Statement */
         Statement statement = conn.createStatement();

         /** Using a String addCountry, adding to the table 'students' a new column 'country', of 'varchar' type, max 30 digits long */
         String addCountry = "ALTER TABLE students ADD COLUMN country VARCHAR(30);";

         /** Executing the statement */
         statement.executeUpdate(addCountry);

         /** Using a String addItaly, setting the value 'Italy' in column 'country' for the first 2 students in table, using 'student_id' value as condition */
            String addItaly = "UPDATE students SET country = 'Italy' WHERE student_id < 3;";

         /** Executing the statement */
         statement.executeUpdate(addItaly);

         /** Using a String addGermany, setting the value 'Germany' in column 'country' for the other 2 students in table, using 'student_id' value as condition */
            String addGermany = "UPDATE students SET country = 'Germany' WHERE student_id >= 3;";

         /** Executing the statement */
         statement.executeUpdate(addGermany);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }
}

