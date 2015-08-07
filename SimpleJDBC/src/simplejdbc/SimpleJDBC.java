package simplejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleJDBC {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
            "jdbc:derby://localhost:1527/MyDB", "simon", "password");) {
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM SIMON.CUSTOMERS");) {
                while (rs.next()) {
                    String name = rs.getString("NAME");
                    String zip = rs.getString("ZIP");
                    System.out.println(name + " is at ZIP " + zip);
                }
                PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO Customers (PK, NAME, ZIP) VALUES (?,?,?)");
                ps.setInt(1, (int)(Math.random() * 10_000));
                ps.setString(2, "Albert");
                ps.setString(3, "12345");
                int count = ps.executeUpdate();
                System.out.println("Updated " + count + " rows");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SimpleJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
