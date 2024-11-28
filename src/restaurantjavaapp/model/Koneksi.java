/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantjavaapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class Koneksi {

    public Connection con;
    public Statement stm;

    //method untuk konfigurasi koneksi ke db
    public void config() {
        try {
            String url = "jdbc:mysql://127.0.0.1/db_restoran";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");

            //string connection
            con = DriverManager.getConnection(url, user, pass);

            //mempersiapkan variabel untuk sql statement
            stm = (Statement) con.createStatement();
            System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            System.out.println("Koneksi Gagal" + e);
        }
    }
}
