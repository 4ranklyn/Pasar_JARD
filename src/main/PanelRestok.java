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
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
        
/**
 *
 * @author ryanf
 */

public class PanelRestok extends javax.swing.JLayeredPane {
    
    private javax.swing.JLayeredPane panelRestok = null;
    private boolean addAble = true;
    String filename, dateNow;
    /**
     * Creates new form PanelRestok
     */
    public PanelRestok() {
        initComponents();
        Document docID = Kolom_idBarang.getDocument();
        docID.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(search() && isBaru.isSelected()){
                    addAble = false;
                    warning.setText("ID sudah digunakan");
                }else{
                    addAble = true;
                    warning.setText("");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(search() && isBaru.isSelected()){
                    addAble = false;
                    warning.setText("ID sudah digunakan");
                }else{
                    addAble = true;
                    warning.setText("");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
        
        Document docStok = Kolom_stokBarang.getDocument();
        docStok.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> {
                    String text = Kolom_stokBarang.getText();
                    if (!text.matches("^[0-9]*$")) {
                        Kolom_stokBarang.setText(text.replaceAll("[^0-9]", ""));
                    } 
                    if (text.charAt(0) == '0') {
                        Kolom_stokBarang.setText(Integer.toString(Integer.parseInt(text)));
                    }
                });
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> {
                    String text = Kolom_stokBarang.getText();
                    if (text.isEmpty()) {
                        Kolom_stokBarang.setText("0");
                    }
                });
            }
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
        
        isBaru.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (isBaru.isSelected() && search()) {
                    addAble = false;
                    warning.setText("ID sudah digunakan");
                } else {
                    addAble = true;
                    warning.setText("");
                }
            }
        });
        
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) TabelStok.getModel();
        model.addTableModelListener(e -> {
            if (e.getType() == javax.swing.event.TableModelEvent.UPDATE) {
                int column = e.getColumn();
                int row = e.getFirstRow();

                // Check if the updated column is the desired column
                if (column != 0) {
                    String id = model.getValueAt(row, 0).toString();
                    String nama = model.getValueAt(row, 1).toString();
                    int stok = (int) model.getValueAt(row, 2);
                    int harga = (int) model.getValueAt(row, 3);
                    
                    Gudang.rak.get(id).modifyProperties(nama, harga, stok);
                    AccessXML.writeXML();
                }
            }
        });
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date(); //mengakses tanggal terkini
        this.dateNow = dateFormat.format(currentDate);
        this.filename = "Laporan " + dateFormat.format(currentDate) + ".txt";
        for(String id : Gudang.rak.keySet()){
            Barang Barang = Gudang.rak.get(id);
            model.addRow(new Object[]{id, Barang.getName(), Barang.getQty(), Barang.getPrice()});
        }
    }
    
    public boolean search(){
        String id = Kolom_idBarang.getText();
        if(Gudang.rak.get(id)==null){
            Kolom_namaBarang.setText("");
            Kolom_hargaBarang.setText(Integer.toString(0));
            return false;
        }
        Barang Barang = Gudang.rak.get(id);
        Kolom_namaBarang.setText(Barang.getName());
        Kolom_hargaBarang.setText(Integer.toString(Barang.getPrice()));
        return true;
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

        Kolom_idBarang = new javax.swing.JTextField();
        Kolom_namaBarang = new javax.swing.JTextField();
        Kolom_stokBarang = new javax.swing.JTextField();
        Kolom_hargaBarang = new javax.swing.JTextField();
        Label_idBarang = new javax.swing.JLabel();
        input = new javax.swing.JButton();
        Label_namaBarang = new javax.swing.JLabel();
        Label_hargaBarang = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelStok = new javax.swing.JTable();
        CetakStok = new javax.swing.JButton();
        Label_stokBarang = new javax.swing.JLabel();
        isBaru = new javax.swing.JCheckBox();
        warning = new javax.swing.JLabel();

        Kolom_idBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Kolom_idBarangActionPerformed(evt);
            }
        });

        Kolom_namaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Kolom_namaBarangActionPerformed(evt);
            }
        });

        Kolom_stokBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Kolom_stokBarangActionPerformed(evt);
            }
        });

        Kolom_hargaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Kolom_hargaBarangActionPerformed(evt);
            }
        });

        Label_idBarang.setText("Id Barang");

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

        Label_namaBarang.setText("Nama Barang");

        Label_hargaBarang.setText("Harga per Barang");

        TabelStok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Barang", "Nama Barang", "Stok", "Harga per Barang"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        Label_stokBarang.setText("Stok");

        isBaru.setText("barang baru");
        isBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isBaruActionPerformed(evt);
            }
        });

        warning.setText(" ");

        setLayer(Kolom_idBarang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Kolom_namaBarang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Kolom_stokBarang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Kolom_hargaBarang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Label_idBarang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(input, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Label_namaBarang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Label_hargaBarang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(CetakStok, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Label_stokBarang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(isBaru, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(warning, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Label_idBarang)
                            .addComponent(Kolom_idBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(Label_namaBarang)
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Kolom_namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Kolom_stokBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(Label_stokBarang)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Kolom_hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_hargaBarang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isBaru)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(warning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(CetakStok, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Kolom_idBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Label_namaBarang)
                                .addComponent(Label_idBarang))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Label_stokBarang)
                                .addComponent(Label_hargaBarang)))
                        .addGap(38, 38, 38))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Kolom_hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Kolom_stokBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(input)
                        .addComponent(Kolom_namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(isBaru)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(warning)
                    .addComponent(CetakStok))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        Kolom_namaBarang.setEnabled(false);
        Kolom_hargaBarang.setEnabled(false);
    }// </editor-fold>//GEN-END:initComponents

    private void Kolom_idBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Kolom_idBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Kolom_idBarangActionPerformed

    private void Kolom_namaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Kolom_namaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Kolom_namaBarangActionPerformed

    private void Kolom_stokBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Kolom_stokBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Kolom_stokBarangActionPerformed

    private void inputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputMouseClicked
        if(addAble){
            String idBarang = Kolom_idBarang.getText();
            String namaBarang = Kolom_namaBarang.getText();
            int stokBarang = Integer.parseInt(Kolom_stokBarang.getText());
            int hargaBarang = Integer.parseInt(Kolom_hargaBarang.getText());
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) TabelStok.getModel();
            Barang Barang = Gudang.rak.get(idBarang);

            if(Barang != null && stokBarang != 0){
                for(int i = 0; i < TabelStok.getRowCount(); i++){
                    if(model.getValueAt(i, 0).equals(idBarang)){
                        int currentQTY = (int) model.getValueAt(i, 2);
                        model.setValueAt(currentQTY+Integer.parseInt(Kolom_stokBarang.getText()), i, 2);
                        Gudang.rak.get(idBarang).modifyProperties(namaBarang, hargaBarang, currentQTY+Integer.parseInt(Kolom_stokBarang.getText()));
                    }
                }
            }else{
                model.addRow(new Object[]{idBarang, namaBarang, stokBarang, hargaBarang});
                Gudang.barangBaru(idBarang, namaBarang, hargaBarang, stokBarang);
            }
            AccessXML.writeXML();
            TabelStok.setModel(model);
        }
    }//GEN-LAST:event_inputMouseClicked

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputActionPerformed

    private void Kolom_hargaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Kolom_hargaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Kolom_hargaBarangActionPerformed

    private void CetakStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CetakStokActionPerformed

    private void CetakStokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CetakStokMouseClicked
        try {
           String userHome = System.getProperty("user.home");
           String documentsPath = userHome + File.separator + "Documents";
           String filePath = documentsPath + File.separator + filename + ".txt";
           
           FileWriter fw = new FileWriter(filePath, true);
           BufferedWriter w = new BufferedWriter(fw);

           SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
           long currentTimeMillis = System.currentTimeMillis();
           Date currentTime = new Date(currentTimeMillis);

           w.write("Catatan Daftar Stok Tanggal : " + dateNow);
           w.write(" \nTime -> " + dateNow);
           w.newLine();
           w.write("------------------------------------------");
           w.newLine();
           w.write("         DAFTAR STOK SUPERMARKET        ");
           w.newLine();
           w.write("------------------------------------------");
           w.newLine();

           for (String id : Gudang.rak.keySet()) {
               Barang it = Gudang.rak.get(id);
               w.write("|Produk: " + it.getName() + "\t\t" + "| Jumlah Stok: " + it.getQty() +
                       "\t\t| " + (it.getQty() <= 0 ? "Kosong\t\t|" : "Tersedia\t\t|"));
               w.newLine();
               if (it.getQty() <= 0) {
                   w.write("Keterangan: Produk " + it.getName() + " Telah Sold Out/Sedang Dalam Pengiriman");
                   w.newLine();
                   w.newLine();
               } else {
                   w.write("Keterangan: Produk " + it.getName() + " Tersedia dalam Etalase");
                   w.newLine();
                   w.newLine();
               }
           }
           w.close(); // Menutup objek BufferedReader
           fw.close();

           warning.setText("Laporan telah dicatat dalam file \'" + filePath + "\'");
       } catch (IOException e) {
           // Menampilkan pesan kesalahan jika terjadi eksepsi
           System.out.println("Ada error pada i/o");
       }
    }//GEN-LAST:event_CetakStokMouseClicked

    private void isBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isBaruActionPerformed
        if(this.isBaru.isSelected()){
            Kolom_namaBarang.setEnabled(true);
            Kolom_hargaBarang.setEnabled(true);
        }else{
            Kolom_namaBarang.setEnabled(false);
            Kolom_hargaBarang.setEnabled(false);
        }
    }//GEN-LAST:event_isBaruActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CetakStok;
    private javax.swing.JTextField Kolom_hargaBarang;
    private javax.swing.JTextField Kolom_idBarang;
    private javax.swing.JTextField Kolom_namaBarang;
    private javax.swing.JTextField Kolom_stokBarang;
    private javax.swing.JLabel Label_hargaBarang;
    private javax.swing.JLabel Label_idBarang;
    private javax.swing.JLabel Label_namaBarang;
    private javax.swing.JLabel Label_stokBarang;
    private javax.swing.JTable TabelStok;
    private javax.swing.JButton input;
    private javax.swing.JCheckBox isBaru;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel warning;
    // End of variables declaration//GEN-END:variables
}
