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
public class Gudang {
    public static HashMap<String, Barang> rak = new HashMap<String, Barang>();
    
    public static void barangBaru(String id, String namaBarang, int harga, int qty){
        
        Barang Barang = new Barang(namaBarang, harga, qty);
        rak.put(id, Barang);
    }
}
