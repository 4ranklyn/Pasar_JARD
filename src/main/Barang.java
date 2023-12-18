/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author ryanf
 */
public class Barang{
    private String namaBarang;
    private int harga;
    private int jumlahStok;

    public Barang(String namaBarang, int harga, int jumlahStok){
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