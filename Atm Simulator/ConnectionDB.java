package ATM_Simulator;

import java.sql.*;

public class ConnectionDB 
{
    public Connection c;  // Use a different name instead of "Connection" to avoid confusion
    public Statement s;

    public ConnectionDB() 
    {
        try 
        {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/AtmSimulator", "root", "Hello");

            // Create a statement
            s = c.createStatement();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}
