package dao;

import entities.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAO {
    private static final CustomerDAO self = new CustomerDAO();
    private Connection connection;
    {
        try {
            connection = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/MyDB", "simon", "password");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
    public static CustomerDAO get() {
        return self;
    }
    
    public Customer findByPk(int pk) {
        try (Statement st= connection.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM Customers WHERE PK = " + pk)) {
            if (rs.next()) {
                String name = rs.getString("NAME");
                String zip = rs.getString("ZIP");
                return new Customer(pk, name, zip);
            }
            throw new NoSuchElementException("No customer PK " + pk);
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new RuntimeException("DB broke");
    }
}
