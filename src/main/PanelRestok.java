/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
        
/**
 *
 * @author ryanf
 */
public class PanelRestok extends javax.swing.JLayeredPane {
    
    private javax.swing.JLayeredPane panelRestok = null;

    /**
     * Creates new form PanelRestok
     */
    public PanelRestok() {
        initComponents();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date(); //mengakses tanggal terkini
        this.filename = "Laporan " + dateFormat.format(currentDate) + ".txt";
    }
    
    public javax.swing.JLayeredPane getPanelRestok() {
        if (panelRestok == null) {
            panelRestok = new PanelRestok();
        }
        return panelRestok;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Id_barang = new javax.swing.JTextField();
        Nama_barang = new javax.swing.JTextField();
        Stok_f = new javax.swing.JTextField();
        Id_Barang = new javax.swing.JLabel();
        input = new javax.swing.JButton();
        Harga_Barang = new javax.swing.JTextField();
        Nama_Barang = new javax.swing.JLabel();
        Harga_barang = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelStok = new javax.swing.JTable();
        CetakStok = new javax.swing.JButton();
        Stok_l = new javax.swing.JLabel();

        Id_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Id_barangActionPerformed(evt);
            }
        });

        Nama_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nama_barangActionPerformed(evt);
            }
        });

        Stok_f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Stok_fActionPerformed(evt);
            }
        });

        Id_Barang.setText("Id Barang");

        input.setText("Input");
        input.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputMouseClicked(evt);
            }
        });
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        Harga_Barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Harga_BarangActionPerformed(evt);
            }
        });

        Nama_Barang.setText("Nama Barang");

        Harga_barang.setText("Harga per Barang");

        TabelStok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Barang", "Nama Barang", "Stok", "Harga per Barang"
            }
        ));
        jScrollPane1.setViewportView(TabelStok);

        CetakStok.setText("Cetak Laporan");
        CetakStok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CetakStokMouseClicked(evt);
            }
        });
        CetakStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakStokActionPerformed(evt);
            }
        });

        Stok_l.setText("Stok");

        setLayer(Id_barang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Nama_barang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Stok_f, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Id_Barang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(input, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Harga_Barang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Nama_Barang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Harga_barang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(CetakStok, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Stok_l, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CetakStok, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Id_Barang)
                            .addComponent(Id_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(Nama_Barang)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Stok_l)
                            .addComponent(Stok_f, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Harga_Barang, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Harga_barang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(input)
                        .addGap(38, 38, 38)))
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Stok_f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(input))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nama_Barang, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Id_Barang)
                                .addComponent(Stok_l)
                                .addComponent(Harga_barang)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Id_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Harga_Barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CetakStok)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Id_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Id_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Id_barangActionPerformed

    private void Nama_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nama_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nama_barangActionPerformed

    private void Stok_fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Stok_fActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Stok_fActionPerformed

    private void inputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputMouseClicked
        String idBarang = Id_barang.getText();
        String namaBarang = Nama_barang.getText();
        int stokBarang = Integer.parseInt(Stok_f.getText());
        int price = Integer.parseInt(Harga_Barang.getText());
        gudang.barangBaru(idBarang,namaBarang,price,stokBarang);
        
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) TabelStok.getModel();
        model.addRow(new Object[]{idBarang, namaBarang, stokBarang, price});

        TabelStok.setModel(model);
    }//GEN-LAST:event_inputMouseClicked

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputActionPerformed

    private void Harga_BarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Harga_BarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Harga_BarangActionPerformed

    private void CetakStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CetakStokActionPerformed

    private void CetakStokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CetakStokMouseClicked
        try {
           FileWriter fileWriter = new FileWriter(filename, true);
           BufferedWriter writer = new BufferedWriter(fileWriter);

           SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
           long currentTimeMillis = System.currentTimeMillis();
           Date currentTime = new Date(currentTimeMillis);

           writer.write("Catatan Daftar Stok Tanggal : " + filename);
           writer.write(" \nTime -> " + timeFormat.format(currentTime));
           writer.newLine();
           writer.write("------------------------------------------");
           writer.newLine();
           writer.write("         DAFTAR STOK SUPERMARKET        ");
           writer.newLine();
           writer.write("------------------------------------------");
           writer.newLine();

           for (String id : gudang.rak.keySet()) {
               barang it = gudang.rak.get(id);
               writer.write("|Produk: " + it.getName() + "\t\t" + "| Jumlah Stok: " + it.getQty() +
                       "\t\t| " + (it.getQty() <= 0 ? "Kosong\t\t|" : "Tersedia\t\t|"));
               writer.newLine();
               if (it.getQty() <= 0) {
                   writer.write("Keterangan: Produk " + it.getName() + " Telah Sold/Sedang Dalam Pengiriman");
                   writer.newLine();
               } else {
                   writer.write("Keterangan: Produk " + it.getName() + " Tersedia dalam Etalase");
                   writer.newLine();
               }
           }
           writer.close(); // Menutup objek BufferedReader
           fileWriter.close();

           System.out.println("Daftar stok telah dicatat dalam file " + filename);
       } catch (IOException e) {
           // Menampilkan pesan kesalahan jika terjadi eksepsi
           System.out.println("Ada error pada i/o");
       }
    }//GEN-LAST:event_CetakStokMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CetakStok;
    private javax.swing.JTextField Harga_Barang;
    private javax.swing.JLabel Harga_barang;
    private javax.swing.JLabel Id_Barang;
    private javax.swing.JTextField Id_barang;
    private javax.swing.JLabel Nama_Barang;
    private javax.swing.JTextField Nama_barang;
    private javax.swing.JTextField Stok_f;
    private javax.swing.JLabel Stok_l;
    private javax.swing.JTable TabelStok;
    private javax.swing.JButton input;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
