/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantjavaapp.model;

/**
 *
 * @author ASUS
 */
public class MenuMinuman extends Menu {
    private int id_menu;
    private String nama_minuman;
    private int harga_minuman;
    private String status;
    
    public MenuMinuman (int idminuman, int idmenu, String namaminuman, int hargaminuman, String status){
        super(idmenu);
        this.id = idminuman;
        this.nama_minuman = namaminuman;
        this.harga_minuman = hargaminuman;
        this.status = status;
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public String getNama_minuman() {
        return nama_minuman;
    }

    public void setNama_minuman(String nama_minuman) {
        this.nama_minuman = nama_minuman;
    }

    public int getHarga_minuman() {
        return harga_minuman;
    }

    public void setHarga_minuman(int harga_minuman) {
        this.harga_minuman = harga_minuman;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
