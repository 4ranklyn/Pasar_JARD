/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MarketplaceSayur;

/**
 *
 * @author ryanf
 */
public class barang{
    private String namaBarang;
    private int harga;
    private int jumlahStok;

    public barang(String namaBarang, int harga, int jumlahStok){
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.jumlahStok = jumlahStok;
    }
    public void modifyProperties(String namaBarang, int harga, int jumlahStok){
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.jumlahStok = jumlahStok;
    }
    public String getName(){
        return namaBarang;
    }
    public int getPrice(){
        return harga;
    }
    public int getQty(){
        return jumlahStok;
    }
}