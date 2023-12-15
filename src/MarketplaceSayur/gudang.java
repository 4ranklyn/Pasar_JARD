package MarketplaceSayur;

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

        int hargaTotal = Barang.getPrice() * qty;
    }
    
    public static void initialize(){
        barangBaru("S01E01","Indomie", 3500, 100);
        barangBaru("S01E02","Sarimie", 3500, 100);
        barangBaru("S01E03","Mie Sedaap", 3500, 100);
        barangBaru("S01E04","Supermi", 3500, 100);
        barangBaru("S01E05","Mie Sukses", 3500, 100);
        barangBaru("S01E06","Mie Gepeng", 3500, 100);
        barangBaru("S01E07","Gaga 100", 3500, 100);
        barangBaru("S01E08","Mi ABC", 3500, 100);
    }
}
