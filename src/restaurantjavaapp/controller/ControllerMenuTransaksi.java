package restaurantjavaapp.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import restaurantjavaapp.model.Menu;
import restaurantjavaapp.model.MenuResto;
import restaurantjavaapp.model.MenuTransaksi;

public class ControllerMenuTransaksi {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    public String sql;

    DefaultTableModel dtm = new DefaultTableModel();

    public ControllerMenuTransaksi() {
        Koneksi db = new Koneksi();
        db.config();
        this.con = db.con;
    }

    public DefaultTableModel buatTable() {
        dtm.addColumn("Nama Pelanggan");
        dtm.addColumn("ID Menu");
        dtm.addColumn("Tanggal");
        dtm.addColumn("Nama Masakan");
        dtm.addColumn("Harga");
        dtm.addColumn("Jumlah Beli");
        dtm.addColumn("Total Bayar");
        return dtm;
    }

    public void tampilkanData() {
        try {
            //persipan tabel - clear area dtm
            dtm.getDataVector().removeAllElements();
            dtm.fireTableDataChanged();

            //Query
            this.sql = "SELECT * FROM tbtransaksi";

            //jalankan query
            // Menyiapkan PreparedStatement
            pst = con.prepareStatement(sql);

            // Menjalankan query
            rs = pst.executeQuery();

            //unboxing data ke dalam array/Object
            while (rs.next()) {
                Object[] obj = new Object[11];
                //namanya harus sama dengan yang di db
                obj[0] = rs.getString("nama_pelanggan");
                obj[1] = rs.getString("id_menu");
                obj[2] = rs.getString("tanggal");
                obj[3] = rs.getString("nama_menu");
                obj[4] = rs.getString("harga");
                obj[5] = rs.getString("jumlah_beli");
                obj[6] = rs.getString("total_bayar");

                //masukkan objek ke dtm
                dtm.addRow(obj);
            }
        } catch (Exception e) {
            System.out.println("Gagal Query..." + e);
        }
    }

    public void refreshCombo() {
        try {
            //Query
            this.sql = "SELECT * FROM tbmenuresto + WHERE status='TERSEDIA'";

            //jalankan query
            // Menyiapkan PreparedStatement
            pst = con.prepareStatement(sql);

            // Menjalankan query
            rs = pst.executeQuery();

        } catch (Exception e) {
            System.out.println("Gagal Query..." + e);
        }

    }
    
}
