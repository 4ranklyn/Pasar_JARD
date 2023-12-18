/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main;

/**
 *
 * @author ryanf
 */

import java.awt.Color;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.SwingUtilities;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalTime;
import java.io.File;

public class PanelPenjualan extends javax.swing.JLayeredPane {
    
    private javax.swing.JLayeredPane panelPenjualan = null;

    /**
     * Creates new form PanelPenjualan
     */
    public PanelPenjualan() {
        initComponents();
        KolomHarga.setText("0");
        Document kolomIDdoc = kolomIdBarang.getDocument();
        kolomIDdoc.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
        
        Document kolomQTYdoc = KolomQTY.getDocument();
        kolomQTYdoc.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> {
                    String text = KolomQTY.getText();
                    if (!text.matches("^[0-9]*$")) {
                        KolomQTY.setText(text.replaceAll("[^0-9]", ""));
                    }
                    if (text.isEmpty()) {
                        KolomQTY.setText("0");
                    } else if (text.charAt(0) == '0') {
                        KolomQTY.setText(Integer.toString(Integer.parseInt(text)));
                    }
                    KolomTotalHarga.setText(Integer.toString(Integer.parseInt(KolomHarga.getText()) * Integer.parseInt(KolomQTY.getText())));
                });
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> {
                    String text = KolomQTY.getText();
                    if (text.isEmpty()) {
                        KolomQTY.setText("0");
                    }
                    KolomTotalHarga.setText(Integer.toString(Integer.parseInt(KolomHarga.getText()) * Integer.parseInt(KolomQTY.getText())));
                });
            }
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
        
        Document kolomBayardoc = KolomBayar.getDocument();
        kolomBayardoc.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> {
                    String text = KolomBayar.getText();
                    if (!text.matches("^[0-9]*$")) {
                        KolomBayar.setText(text.replaceAll("[^0-9]", ""));
                    }
                    if (text.isEmpty()) {
                        KolomBayar.setText("0");
                    } else if (text.charAt(0) == '0') {
                        KolomBayar.setText(Integer.toString(Integer.parseInt(text)));
                    }
                    KolomKembali.setText(Integer.toString(Integer.parseInt(KolomBayar.getText()) - Integer.parseInt(KolomSubtotal.getText())));
                });
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> {
                    String text = KolomBayar.getText();
                    if (text.isEmpty()) {
                        KolomBayar.setText("0");
                    }
                    KolomKembali.setText(Integer.toString(Integer.parseInt(KolomBayar.getText()) - Integer.parseInt(KolomSubtotal.getText())));
                });
            }
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
        
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) isiKeranjang.getModel();
        model.addTableModelListener(e -> {
            if (e.getType() == javax.swing.event.TableModelEvent.UPDATE) {
                int column = e.getColumn();
                int row = e.getFirstRow();

                if(column == 3){
                    model.getValueAt(row, column);

                    int newQTY = (int) model.getValueAt(row, column);
                    int currentTotal = (int) model.getValueAt(row, 4);
                    int price = (int) model.getValueAt(row, 2);
                    model.setValueAt(newQTY*price, row, 4);

                    int deltaPrice = newQTY*price - currentTotal;
                    int currentSubtotal = Integer.parseInt(KolomSubtotal.getText());
                    KolomSubtotal.setText(Integer.toString(currentSubtotal+deltaPrice));
                }
            }
        });
    }
    
    public javax.swing.JLayeredPane getPanelPenjualan() {
        if (panelPenjualan == null) {
            panelPenjualan = new PanelPenjualan();
        }
        return panelPenjualan;
    }
    
    public void search(){
        String id = kolomIdBarang.getText();
        if(Gudang.rak.get(id)==null){
            KolomNamaBarang.setText("");
            KolomHarga.setText(Integer.toString(0));
            return;
        }
        Barang Barang = Gudang.rak.get(id);
        KolomNamaBarang.setText(Barang.getName());
        KolomHarga.setText(Integer.toString(Barang.getPrice()));
        KolomTotalHarga.setText(Integer.toString(Integer.parseInt(KolomHarga.getText()) * Integer.parseInt(KolomQTY.getText())));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_idbarang = new javax.swing.JLabel();
        kolomIdBarang = new javax.swing.JTextField();
        label_namabarang = new javax.swing.JLabel();
        KolomNamaBarang = new javax.swing.JTextField();
        label_harga = new javax.swing.JLabel();
        KolomHarga = new javax.swing.JTextField();
        label_qty = new javax.swing.JLabel();
        KolomQTY = new javax.swing.JTextField();
        label_totalharga = new javax.swing.JLabel();
        KolomTotalHarga = new javax.swing.JTextField();
        tombolTambahkan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        isiKeranjang = new javax.swing.JTable();
        KolomSubtotal = new javax.swing.JTextField();
        label_subtotal = new javax.swing.JLabel();
        KolomBayar = new javax.swing.JTextField();
        label_bayar = new javax.swing.JLabel();
        KolomKembali = new javax.swing.JTextField();
        label_kembalian = new javax.swing.JLabel();
        tombol_printstruk = new javax.swing.JButton();
        label_konfirmasi = new javax.swing.JLabel();
        tombolClear = new javax.swing.JButton();

        setBackground(new java.awt.Color(30, 30, 30));

        label_idbarang.setText("ID barang");

        kolomIdBarang.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        kolomIdBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolomIdBarangActionPerformed(evt);
            }
        });
        kolomIdBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kolomIdBarangKeyTyped(evt);
            }
        });

        label_namabarang.setText("Nama Barang");

        KolomNamaBarang.setBackground(new java.awt.Color(30, 30, 30));
        KolomNamaBarang.setForeground(new java.awt.Color(255, 255, 255));
        KolomNamaBarang.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        KolomNamaBarang.setEnabled(false);
        KolomNamaBarang.setHighlighter(null);
        KolomNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KolomNamaBarangActionPerformed(evt);
            }
        });

        label_harga.setText("Harga");

        KolomHarga.setEnabled(false);
        KolomHarga.setHighlighter(null);
        KolomHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KolomHargaActionPerformed(evt);
            }
        });
        KolomHarga.setEditable(false);

        label_qty.setText("QTY");

        KolomQTY.setText("0");
        KolomQTY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KolomQTYActionPerformed(evt);
            }
        });

        label_totalharga.setText("Total");

        KolomTotalHarga.setEnabled(false);
        KolomTotalHarga.setHighlighter(null);

        tombolTambahkan.setText("Input");
        tombolTambahkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tombolTambahkanMouseClicked(evt);
            }
        });
        tombolTambahkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolTambahkanActionPerformed(evt);
            }
        });

        isiKeranjang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Barang", "Nama Barang", "Harga satuan", "QTY", "Harga total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        isiKeranjang.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                isiKeranjangPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(isiKeranjang);

        KolomSubtotal.setBackground(new java.awt.Color(30, 30, 30));
        KolomSubtotal.setEnabled(false);

        label_subtotal.setText("Subtotal");

        label_bayar.setText("Bayar");

        KolomKembali.setEnabled(false);

        label_kembalian.setText("Kembali");

        tombol_printstruk.setText("Print struk");
        tombol_printstruk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tombol_printstrukMouseClicked(evt);
            }
        });
        tombol_printstruk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_printstrukActionPerformed(evt);
            }
        });

        label_konfirmasi.setText(" ");

        tombolClear.setText("Hapus Keranjang");
        tombolClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tombolClearMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tombolClearMousePressed(evt);
            }
        });
        tombolClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolClearActionPerformed(evt);
            }
        });

        setLayer(label_idbarang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(kolomIdBarang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(label_namabarang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(KolomNamaBarang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(label_harga, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(KolomHarga, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(label_qty, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(KolomQTY, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(label_totalharga, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(KolomTotalHarga, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(tombolTambahkan, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(KolomSubtotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(label_subtotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(KolomBayar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(label_bayar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(KolomKembali, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(label_kembalian, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(tombol_printstruk, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(label_konfirmasi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(tombolClear, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label_namabarang)
                                        .addGap(65, 65, 65)
                                        .addComponent(label_harga))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label_idbarang)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(kolomIdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(46, 46, 46)
                                .addComponent(label_qty))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(KolomNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KolomHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KolomQTY, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(label_totalharga))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(KolomTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tombolTambahkan, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tombolClear)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(label_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(82, 82, 82)
                                    .addComponent(label_bayar)
                                    .addGap(100, 100, 100)
                                    .addComponent(label_kembalian)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(KolomKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(tombol_printstruk))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_konfirmasi, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(KolomSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(KolomBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_idbarang)
                    .addComponent(kolomIdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolClear))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_namabarang)
                    .addComponent(label_harga)
                    .addComponent(label_qty)
                    .addComponent(label_totalharga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KolomNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KolomQTY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KolomHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KolomTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolTambahkan))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_subtotal)
                    .addComponent(label_bayar)
                    .addComponent(label_kembalian))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KolomSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KolomBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KolomKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombol_printstruk))
                .addGap(18, 18, 18)
                .addComponent(label_konfirmasi)
                .addGap(35, 35, 35))
        );

        KolomNamaBarang.setEditable(false);
        KolomNamaBarang.setDisabledTextColor(new Color(0, 0, 0));
        KolomHarga.setDisabledTextColor(new Color(0, 0, 0));
        KolomTotalHarga.setEditable(false);
        KolomTotalHarga.setDisabledTextColor(new Color(0, 0, 0));
        KolomSubtotal.setDisabledTextColor(new Color(0, 0, 0));
        KolomKembali.setDisabledTextColor(new Color(0, 0, 0));
    }// </editor-fold>//GEN-END:initComponents

    private void tombolTambahkanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tombolTambahkanMouseClicked
        String id = kolomIdBarang.getText();
        int qty = Integer.parseInt(KolomQTY.getText());
        Barang Barang = Gudang.rak.get(id);
        if(Barang != null && qty != 0){
            boolean addNew = true;
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) isiKeranjang.getModel();
            int subtotal = 0;
            for(int i = 0; i < isiKeranjang.getRowCount(); i++){//For each row
                if(model.getValueAt(i, 0).equals(id)){//Search the model
                    int currentQTY = (int) model.getValueAt(i, 3);
                    int currentTotal = (int) model.getValueAt(i, 4);
                    model.setValueAt(currentQTY+Integer.parseInt(KolomQTY.getText()), i, 3);
                    model.setValueAt(currentTotal+qty*Barang.getPrice(), i, 4);
                    addNew = false;
                }
                subtotal+=(int) model.getValueAt(i, 4);
            }
            if(addNew){
                model.addRow(new Object[]{id, Barang.getName(), Barang.getPrice(), qty, Integer.parseInt(KolomTotalHarga.getText())}); 
                subtotal+=Integer.parseInt(KolomTotalHarga.getText());
            }
            KolomSubtotal.setText(Integer.toString(subtotal));
        }
    }//GEN-LAST:event_tombolTambahkanMouseClicked

    private void kolomIdBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolomIdBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kolomIdBarangActionPerformed

    private void KolomNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KolomNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KolomNamaBarangActionPerformed

    private void KolomHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KolomHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KolomHargaActionPerformed
    
    private void kolomIdBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kolomIdBarangKeyTyped

    }//GEN-LAST:event_kolomIdBarangKeyTyped

    private void KolomQTYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KolomQTYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KolomQTYActionPerformed

    private void tombolTambahkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolTambahkanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tombolTambahkanActionPerformed

    private void tombol_printstrukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_printstrukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tombol_printstrukActionPerformed

    private void tombol_printstrukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tombol_printstrukMouseClicked
        if(Integer.parseInt(KolomKembali.getText()) >= 0){
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String strDate = formatter.format(date);
            String time = LocalTime.now().getHour() + "." + LocalTime.now().getMinute() + "." + LocalTime.now().getSecond();

            PanelDashboard dashboard = PanelDashboard.getDashboard();
            dashboard.incrementTotalTransaksi();
            int newUangKas = Integer.parseInt(KolomSubtotal.getText()) + dashboard.getUangKas();
            dashboard.setUangKas(newUangKas);

            String userHome = System.getProperty("user.home");
            String documentsPath = userHome + File.separator + "Documents";
            String filePath = documentsPath + File.separator + strDate + "_" + time + ".txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write("================= TOKO JARD ==================\n");
                writer.write("----------------------------------------------\n")    ;
                writer.write("Tanggal\t: " + strDate + '\n');
                writer.write("Waktu\t: " + LocalTime.now() + '\n');
                writer.write("----------------------------------------------\n");

                javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) isiKeranjang.getModel();
                for(int i = 0; i < isiKeranjang.getRowCount(); i++){//For each row

                    Barang it = Gudang.rak.get(model.getValueAt(i, 0));
                    it.modifyProperties(it.getName(), it.getPrice(), it.getQty()-(int)model.getValueAt(i, 3));

                    writer.write(String.format("%-15s%-15s\n", model.getValueAt(i, 0), model.getValueAt(i, 1)));
                    writer.write(String.format("  %-3sPCS x\t %-15s = %-15s\n", model.getValueAt(i, 3), "Rp" + model.getValueAt(i, 2) + ",00", "Rp" + model.getValueAt(i, 4) + ",00"));
                }
                model.setRowCount(0);
                AccessXML.writeXML();
                writer.write(String.format("\nSUBTOTAL  : %-15s", ("Rp" + KolomSubtotal.getText() + ",00")));
                writer.write(String.format("\nTUNAI     : %-15s", ("Rp" + KolomBayar.getText() + ",00")));
                writer.write(String.format("\nKEMBALIAN : %-15s\n", ("Rp" + KolomKembali.getText() + ",00")));
                writer.write("\n================= TERIMA KASIH ===============");
                label_konfirmasi.setText("Struk pembayaran disimpan di "+filePath);
            } catch (IOException e) {
                System.out.println("An error occurred");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_tombol_printstrukMouseClicked

    private void isiKeranjangPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_isiKeranjangPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_isiKeranjangPropertyChange

    private void tombolClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tombolClearMouseClicked
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) isiKeranjang.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_tombolClearMouseClicked

    private void tombolClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tombolClearActionPerformed

    private void tombolClearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tombolClearMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tombolClearMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField KolomBayar;
    private javax.swing.JTextField KolomHarga;
    private javax.swing.JTextField KolomKembali;
    private javax.swing.JTextField KolomNamaBarang;
    private javax.swing.JTextField KolomQTY;
    private javax.swing.JTextField KolomSubtotal;
    private javax.swing.JTextField KolomTotalHarga;
    private javax.swing.JTable isiKeranjang;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kolomIdBarang;
    private javax.swing.JLabel label_bayar;
    private javax.swing.JLabel label_harga;
    private javax.swing.JLabel label_idbarang;
    private javax.swing.JLabel label_kembalian;
    private javax.swing.JLabel label_konfirmasi;
    private javax.swing.JLabel label_namabarang;
    private javax.swing.JLabel label_qty;
    private javax.swing.JLabel label_subtotal;
    private javax.swing.JLabel label_totalharga;
    private javax.swing.JButton tombolClear;
    private javax.swing.JButton tombolTambahkan;
    private javax.swing.JButton tombol_printstruk;
    // End of variables declaration//GEN-END:variables
}
