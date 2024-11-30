package restaurantjavaapp.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import restaurantjavaapp.model.Menu;
import restaurantjavaapp.model.MenuResto;

public class ControllerMenuResto {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    public String sql;

    DefaultTableModel dtm = new DefaultTableModel();

    public ControllerMenuResto() {
        Koneksi db = new Koneksi();
        db.config();
        this.con = db.con;
    }

    public DefaultTableModel buatTabel() {
        dtm.addColumn("ID MENU");
        dtm.addColumn("NAMA");
        dtm.addColumn("HARGA");
        dtm.addColumn("STATUS");
        dtm.addColumn("KATEGORI");
        return dtm;
    }

    public void tampilkanData() {
        try {
            //persipan tabel - clear area dtm
            dtm.getDataVector().removeAllElements();
            dtm.fireTableDataChanged();

            //Query
            this.sql = "SELECT * FROM tbmenuresto";

            //jalankan query
            // Menyiapkan PreparedStatement
            pst = con.prepareStatement(sql);

            // Menjalankan query
            rs = pst.executeQuery();

            //unboxing data ke dalam array/Object
            while (rs.next()) {
                Object[] obj = new Object[5];
                //namanya harus sama dengan yang di db
                obj[0] = rs.getString("id_menu");
                obj[1] = rs.getString("nama");
                obj[2] = rs.getString("harga");
                obj[3] = rs.getString("status");
                obj[4] = rs.getString("kategori");

                //masukkan objek ke dtm
                dtm.addRow(obj);
            }
        } catch (Exception e) {
            System.out.println("Gagal Query..." + e);
        }
    }
    
public boolean tambahData(String a, int b, String c, String d) {
    MenuResto mnr = new MenuResto();
    mnr.setNama(a);
    mnr.setHarga(b);
    mnr.setStatus(c);
    mnr.setKategori(d);

    try {
        String sqlMenu = "INSERT INTO tbmenu (id_menu) VALUES (DEFAULT)";
        pst = con.prepareStatement(sqlMenu, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.executeUpdate();

        ResultSet generatedKeys = pst.getGeneratedKeys();
        int idMenu = 0;
        if (generatedKeys.next()) {
            idMenu = generatedKeys.getInt(1);
        } else {
            throw new Exception("Gagal mendapatkan id_menu otomatis dari tbmenu.");
        }

        this.sql = "INSERT INTO tbmenuresto(id_menu, nama, harga, status, kategori) "
                 + "VALUES(" + idMenu + ", '" + mnr.getNama() + "', " + mnr.getHarga() 
                 + ", '" + mnr.getStatus() + "', '" + mnr.getKategori() + "')";
        pst = con.prepareStatement(sql);
        pst.executeUpdate();

        return true;
    } catch (Exception e) {
        System.out.println("Gagal menambahkan data: " + e.getMessage());
        return false;
    }
}



//    public boolean ubahData(int a, String b, int c, String d, String e){
//        MenuResto mr = new MenuResto();
//        mr.setId_menuresto(a);
//        mr.setNama(b);
//        mr.setHarga(c);
//        mr.setStatus(d);
//        mr.setKategori(e);
//        
//        try {
//            this.sql = "UPDATE tbmenuresto SET"
//                    + "nama='"+mr.getNama()+"', "
//                    + "harga='"+mr.getHarga()+"', "
//                    + "status='"+mr.getStatus()+"', "
//                    + "kategori="+ mr.getKategori() +""
//                    + "WHERE id=" + mr.getId_menuresto() + "";
//            this.pst.executeUpdate(sql);
//            return true;
//        } catch (Exception ex) {
//            return false;
//        }
//    }
    public boolean ubahData(int a, String b, int c, String d, String e) {
        MenuResto mr = new MenuResto();
        mr.setId_menuresto(a);
        mr.setNama(b);
        mr.setHarga(c);
        mr.setStatus(d);
        mr.setKategori(e);

        try {
            // Pastikan query memiliki spasi yang benar
            this.sql = "UPDATE tbmenuresto SET "
                    + "nama = '" + mr.getNama() + "', "
                    + "harga = '" + mr.getHarga() + "', "
                    + "status = '" + mr.getStatus() + "', "
                    + "kategori = '" + mr.getKategori() + "' "
                    + "WHERE id_menu = " + mr.getId_menuresto();

            // Menjalankan query
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            return true;
        } catch (Exception err) {
            System.out.println("Gagal mengubah data: " + err.getMessage());
            return false;
        }
    }
    
    public boolean hapusData(int a){
        Menu mn = new Menu();
        mn.setId(a);
        
        try {
            this.sql = "DELETE FROM tbmenu WHERE "
                    + "id_menu="+mn.getId()+"";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            return true;
        } catch (Exception e){
            System.out.println("Gagal mengubah data: " + e.getMessage());
            return false;
        }
    }
}
