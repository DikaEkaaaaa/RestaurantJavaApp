/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantjavaapp.model;


public class MenuMasakan extends Menu {
    private int id_masakan;
    private String nama_masakan;
    private int harga_masakan;
    private String status;
    
    public MenuMasakan (int idmasakan, int idmenu, String namamasakan, int hargamasakan, String status){
        super(idmenu);
        this.id_masakan = idmasakan;
        this.nama_masakan = namamasakan;
        this.harga_masakan = hargamasakan;
        this.status = status;
    }

    public int getId_masakan() {
        return id_masakan;
    }

    public void setId_masakan(int id_masakan) {
        this.id_masakan = id_masakan;
    }

    public String getNama_masakan() {
        return nama_masakan;
    }

    public void setNama_masakan(String nama_masakan) {
        this.nama_masakan = nama_masakan;
    }

    public int getHarga_masakan() {
        return harga_masakan;
    }

    public void setHarga_masakan(int harga_masakan) {
        this.harga_masakan = harga_masakan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}