package main;

import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ryanf
 */
public class gudang {
    public static HashMap<String, barang> rak = new HashMap<String, barang>();
    
    public static void barangBaru(String id, String namaBarang, int harga, int qty){
        
        barang Barang = new barang(namaBarang, harga, qty);
        rak.put(id, Barang);
    }
}
