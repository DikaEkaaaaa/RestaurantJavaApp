package restaurantjavaapp.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;
import restaurantjavaapp.model.User;

public class ControllerUser {
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    public String sql;
    private User IdLevelSekarang;
    
    public ControllerUser() {
        Koneksi db = new Koneksi();
        db.config();
        this.con = db.con;  
    }
    
    public boolean cekLogin(String username, String password) {
        User us = new User();
        us.setUsername(username);
        us.setPassword(password);
        
        boolean status = false;
        try {
            // Secure the query with parameterized PreparedStatement to prevent SQL injection
            this.sql = "SELECT * FROM tbuser WHERE username = '"+us.getUsername()+"' AND password = '"+us.getPassword()+"'";
            
            // Menyiapkan PreparedStatement
            pst = con.prepareStatement(sql);
            
            // Menjalankan query
            rs = pst.executeQuery();
            
            if (rs.next()) {
                status = true;
                us.setId_level(rs.getInt("id_level"));
                IdLevelSekarang = us;
            }else{
                status = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } 
        return status;
    }

    public User getIdLevelSekarang() {
        return IdLevelSekarang;
    }
    
    
}
