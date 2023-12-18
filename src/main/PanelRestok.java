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
 * @author jassonf
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
        Document docID = Id_barang.getDocument();
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
        
        Document docStok = Stok_barang.getDocument();
        docStok.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> {
                    String text = Stok_barang.getText();
                    if (!text.matches("^[0-9]*$")) {
                        Stok_barang.setText(text.replaceAll("[^0-9]", ""));
                    } 
                    if (text.charAt(0) == '0') {
                        Stok_barang.setText(Integer.toString(Integer.parseInt(text)));
                    }
                });
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> {
                    String text = Stok_barang.getText();
                    if (text.isEmpty()) {
                        Stok_barang.setText("0");
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
            Barang barang = Gudang.rak.get(id);
            model.addRow(new Object[]{id, barang.getName(), barang.getQty(), barang.getPrice()});
        }
    }
    
    public boolean search(){
        String id = Id_barang.getText();
        if(Gudang.rak.get(id)==null){
            Nama_barang.setText("");
            Harga_Barang.setText(Integer.toString(0));
            return false;
        }
        Barang barang = Gudang.rak.get(id);
        Nama_barang.setText(barang.getName());
        Harga_Barang.setText(Integer.toString(barang.getPrice()));
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

        Id_barang = new javax.swing.JTextField();
        Nama_barang = new javax.swing.JTextField();
        Stok_barang = new javax.swing.JTextField();
        Harga_Barang = new javax.swing.JTextField();
        Id_Barang = new javax.swing.JLabel();
        input = new javax.swing.JButton();
        Nama_Barang = new javax.swing.JLabel();
        Harga_barang = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelStok = new javax.swing.JTable();
        CetakStok = new javax.swing.JButton();
        Stok_l = new javax.swing.JLabel();
        isBaru = new javax.swing.JCheckBox();
        warning = new javax.swing.JLabel();

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

        Stok_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Stok_barangActionPerformed(evt);
            }
        });

        Harga_Barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Harga_BarangActionPerformed(evt);
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

        Nama_Barang.setText("Nama Barang");

        Harga_barang.setText("Harga per Barang");

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

        Stok_l.setText("Stok");

        isBaru.setText("barang baru");
        isBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isBaruActionPerformed(evt);
            }
        });

        warning.setText(" ");

        setLayer(Id_barang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Nama_barang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Stok_barang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Harga_Barang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Id_Barang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(input, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Nama_Barang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Harga_barang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(CetakStok, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(Stok_l, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(isBaru, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(warning, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Id_Barang)
                            .addComponent(Id_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(Nama_Barang)
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Stok_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(Stok_l)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Harga_Barang, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Harga_barang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isBaru)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CetakStok, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(warning, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Id_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Nama_Barang)
                                .addComponent(Id_Barang))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Stok_l)
                                .addComponent(Harga_barang)))
                        .addGap(38, 38, 38))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Harga_Barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Stok_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(input)
                        .addComponent(Nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(isBaru)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(CetakStok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(warning)
                .addGap(22, 22, 22))
        );

        Nama_barang.setEnabled(false);
        Harga_Barang.setEnabled(false);
    }// </editor-fold>//GEN-END:initComponents

    private void Id_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Id_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Id_barangActionPerformed

    private void Nama_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nama_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nama_barangActionPerformed

    private void Stok_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Stok_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Stok_barangActionPerformed

    private void inputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputMouseClicked
            String idBarang = Id_barang.getText();
            String namaBarang = Nama_barang.getText();
            int stokBarang = Integer.parseInt(Stok_barang.getText());
            int hargaBarang = Integer.parseInt(Harga_Barang.getText());
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) TabelStok.getModel();
            Barang barang = Gudang.rak.get(idBarang);
        if(addAble){
            if(barang != null && stokBarang != 0){
                for(int i = 0; i < TabelStok.getRowCount(); i++){
                    if(model.getValueAt(i, 0).equals(idBarang)){
                        int currentQTY = (int) model.getValueAt(i, 2);
                        model.setValueAt(currentQTY+Integer.parseInt(Stok_barang.getText()), i, 2);
                        Gudang.rak.get(idBarang).modifyProperties(namaBarang, hargaBarang, currentQTY+Integer.parseInt(Stok_barang.getText()));
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

    private void Harga_BarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Harga_BarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Harga_BarangActionPerformed

    private void CetakStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CetakStokActionPerformed

    private void CetakStokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CetakStokMouseClicked
        try {
           String userHome = System.getProperty("user.home");
           String documentsPath = userHome + File.separator + "Documents";
           String filePath = documentsPath + File.separator + filename;
           
           FileWriter fw = new FileWriter(filePath, true);
           BufferedWriter w = new BufferedWriter(fw);

           SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
           long currentTimeMillis = System.currentTimeMillis();
           Date currentTime = new Date(currentTimeMillis);

           w.write("Catatan Daftar Stok Tanggal : " + dateNow);
           w.write(" \nTime -> " + timeFormat.format(currentTime));
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
           w.newLine();
           w.newLine();
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
            Nama_barang.setEnabled(true);
            Harga_Barang.setEnabled(true);
        }else{
            Nama_barang.setEnabled(false);
            Harga_Barang.setEnabled(false);
        }
    }//GEN-LAST:event_isBaruActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CetakStok;
    private javax.swing.JTextField Harga_Barang;
    private javax.swing.JLabel Harga_barang;
    private javax.swing.JLabel Id_Barang;
    private javax.swing.JTextField Id_barang;
    private javax.swing.JLabel Nama_Barang;
    private javax.swing.JTextField Nama_barang;
    private javax.swing.JTextField Stok_barang;
    private javax.swing.JLabel Stok_l;
    private javax.swing.JTable TabelStok;
    private javax.swing.JButton input;
    private javax.swing.JCheckBox isBaru;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel warning;
    // End of variables declaration//GEN-END:variables
}
