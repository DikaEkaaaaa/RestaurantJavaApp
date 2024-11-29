package restaurantjavaapp.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import restaurantjavaapp.model.User;

public class ControllerUser {
    private PreparedStatement stat;
    private ResultSet rs;
    private Koneksi db;
    
    public ControllerUser() {
        db = new Koneksi();
        db.config();
    }
    
    public boolean cekLogin(String username, String password) {
        User us = new User();
        us.setUsername(username);
        us.setPassword(password);
        
        boolean status = false;
        try {
            // Secure the query with parameterized PreparedStatement to prevent SQL injection
            String query = "SELECT * FROM tbuser WHERE username = '"+us.getUsername()+"' AND password = '"+us.getPassword()+"';";
            this.stat = db.getCon().prepareStatement(query);
            this.stat.setString(1, us.getUsername());
            this.stat.setString(2, us.getPassword());
            
            this.rs = this.stat.executeQuery();
            
            if (rs.next()) {
                us.setId_level(rs.getInt("id_level"));
                status = true; // Login success if result found
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            // Ensure resources are closed properly
            try {
                if (rs != null) rs.close();
                if (stat != null) stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return status;
    }
}
