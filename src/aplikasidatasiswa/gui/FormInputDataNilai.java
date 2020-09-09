/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasidatasiswa.gui;

import aplikasidatasiswa.controller.Koneksi;
import aplikasidatasiswa.dao.NilaiDao;
import aplikasidatasiswa.model.tb_guru;
import aplikasidatasiswa.model.tb_nilai;
import aplikasidatasiswa.model.tb_pengguna;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class FormInputDataNilai extends javax.swing.JFrame {

    /**
     * Creates new form FormInputDataNilai
     */
    private Koneksi con;
    private ResultSet res;
    private Statement st;
    tb_nilai tn = new tb_nilai();
    NilaiDao nd = new NilaiDao();
    tb_guru tg = new tb_guru();

    public FormInputDataNilai() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);
        Refresh();
    }

    void Refresh() {
        ShowNip();
        ShowNamaGuru();
        cbKelas.setEnabled(true);
        cbJurusan.setEnabled(false);
        cbNamaSiswa.setEnabled(false);
        cbNisn.setEnabled(false);
        ShowMapel();
        ShowTA();       
        cbSemester.setSelectedIndex(0);
        cbKelas.setSelectedIndex(0);
        cbJurusan.setSelectedIndex(0);
        cbNamaSiswa.setSelectedIndex(0);
        cbNisn.setSelectedIndex(0);
        txtNilai.setText("");
    }

    void ShowMapel() {

        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_guru WHERE nama = '" + txtNamaGuru.getText() + "'");
            while (res.next()) {
                txtMapel.setText(res.getString("bidang"));
            }
        } catch (SQLException ex) {

        }
    }

    void ShowTA() {

        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_ta");
            while (res.next()) {
                txtTA.setText(res.getString("tahun_ajaran"));
            }
        } catch (SQLException ex) {

        }
    }

    void ShowNisn() {
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_penempatan WHERE kelas = '" + cbKelas.getSelectedItem() + "' AND jurusan = '" + cbJurusan.getSelectedItem() + "' ORDER BY nama ASC");
            while (res.next()) {
                cbNisn.addItem(res.getString("nisn"));
            }
        } catch (SQLException ex) {

        }
    }

    void ShowSiswa() {
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_siswa WHERE nisn = '" + cbNisn.getSelectedItem() + "'");
            while (res.next()) {
                cbNamaSiswa.addItem(res.getString("nama"));
            }
        } catch (SQLException ex) {

        }
    }
    
    void ShowNip(){
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_pengguna WHERE username = '" + tb_pengguna.getUsername() + "'");
            while (res.next()) {
                tg.setNip(res.getString("nip"));
            }
        } catch (SQLException ex) {

        }
    }
    
    void ShowNamaGuru(){
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_guru WHERE nip = '" + tg.getNip() + "'");
            while (res.next()) {
                txtNamaGuru.setText(res.getString("nama"));
            }
        } catch (SQLException ex) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNamaGuru = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNilai = new javax.swing.JTextField();
        cbKelas = new javax.swing.JComboBox();
        cbJurusan = new javax.swing.JComboBox();
        cbNamaSiswa = new javax.swing.JComboBox();
        txtMapel = new javax.swing.JTextField();
        cbSemester = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cbNisn = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 204, 153));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FORM INPUT DATA NILAI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("NAMA GURU");

        txtNamaGuru.setEditable(false);
        txtNamaGuru.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNamaGuru.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNamaGuruKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamaGuruKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("SEMESTER");

        txtTA.setEditable(false);
        txtTA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("TAHUN AJARAN");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("MATA PELAJARAN");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("JURUSAN");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("KELAS");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("NAMA SISWA");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("NILAI");

        txtNilai.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNilai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNilaiKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNilaiKeyTyped(evt);
            }
        });

        cbKelas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbKelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", "X", "XI", "XII" }));
        cbKelas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbKelasItemStateChanged(evt);
            }
        });

        cbJurusan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbJurusan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", "BELUM DI TENTUKAN", "IPA", "IPS" }));
        cbJurusan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbJurusanItemStateChanged(evt);
            }
        });
        cbJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJurusanActionPerformed(evt);
            }
        });

        cbNamaSiswa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbNamaSiswa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH" }));
        cbNamaSiswa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNamaSiswaItemStateChanged(evt);
            }
        });

        txtMapel.setEditable(false);
        txtMapel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMapel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMapelKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMapelKeyTyped(evt);
            }
        });

        cbSemester.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbSemester.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", "GANJIL", "GENAP" }));
        cbSemester.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSemesterItemStateChanged(evt);
            }
        });
        cbSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSemesterActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("NISN");

        cbNisn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbNisn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH" }));
        cbNisn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNisnItemStateChanged(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 204, 153));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTA, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbNamaSiswa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbKelas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(210, 210, 210))
                                    .addComponent(txtMapel))
                                .addGap(40, 40, 40)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNilai, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(283, 283, 283))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cbSemester, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(40, 40, 40)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNamaGuru, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(40, 40, 40)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addGap(224, 224, 224))
                            .addComponent(cbJurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbNisn, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaGuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbNisn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNamaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaGuruKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaGuruKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaGuruKeyReleased

    private void txtNamaGuruKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaGuruKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();

        if ((!((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)))) {
            getToolkit().beep();
            evt.consume();
        }

        if (txtNamaGuru.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNamaGuruKeyTyped

    private void txtTAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTAKeyReleased

    private void txtTAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTAKeyTyped

    private void txtNilaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNilaiKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNilaiKeyReleased

    private void txtNilaiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNilaiKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNilaiKeyTyped

    private void cbJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJurusanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJurusanActionPerformed

    private void cbJurusanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbJurusanItemStateChanged
        // TODO add your handling code here:
        if (cbJurusan.equals("PILIH")) {

        } else {
            cbJurusan.setEnabled(false);
            cbNisn.removeAllItems();
            cbNisn.addItem("PILIH");
            ShowNisn();
            cbNisn.setEnabled(true);
            cbNamaSiswa.setEnabled(false);
        }
    }//GEN-LAST:event_cbJurusanItemStateChanged

    private void txtMapelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMapelKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMapelKeyReleased

    private void txtMapelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMapelKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMapelKeyTyped

    private void cbSemesterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSemesterItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSemesterItemStateChanged

    private void cbSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSemesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSemesterActionPerformed

    private void cbNamaSiswaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNamaSiswaItemStateChanged
        // TODO add your handling code here:
        if (cbNamaSiswa.equals("PILIH")) {

        } else {
            cbNamaSiswa.setEnabled(false);
            txtNilai.requestFocus();
        }
    }//GEN-LAST:event_cbNamaSiswaItemStateChanged

    private void cbKelasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbKelasItemStateChanged
        // TODO add your handling code here:
        if (cbKelas.getSelectedIndex() == 0) {

        } else {
            cbKelas.setEnabled(false);
            cbJurusan.setEnabled(true);
        }
    }//GEN-LAST:event_cbKelasItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_nilai WHERE tahun_ajaran = '"+txtTA.getText().trim()+"' AND mapel = '"+txtMapel.getText().trim()+"' AND nisn = '"+cbNisn.getSelectedItem().toString().trim()+"' AND semester = '"+cbSemester.getSelectedItem().toString().trim()+"' ");
            if (res.next()) {
                nd.Update(cbNisn.getSelectedItem().toString(), Integer.valueOf(txtNilai.getText()));
                Refresh();
            } else if (cbSemester.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Silahkan Pilih Semester");
                cbSemester.requestFocus();
            } else if (cbKelas.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Silahkan Pilih Kelas");
                cbKelas.requestFocus();
            } else if (cbJurusan.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Silahkan Pilih Jurusan");
                cbJurusan.requestFocus();
            } else if (cbNamaSiswa.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Silahkan Pilih Nama Siswa");
                cbNamaSiswa.requestFocus();
            } else {

                nd.Save(cbSemester.getSelectedItem().toString(), txtTA.getText().trim(), txtMapel.getText().trim(), cbNisn.getSelectedItem().toString(), Integer.valueOf(txtNilai.getText()));
                Refresh();
            }
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbNisnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNisnItemStateChanged
        // TODO add your handling code here:
        if (cbKelas.getSelectedIndex() == 0) {

        } else {
            cbNisn.setEnabled(false);

            cbNamaSiswa.removeAllItems();
            cbNamaSiswa.addItem("PILIH");
            ShowSiswa();
            cbNamaSiswa.setEnabled(true);
        }
    }//GEN-LAST:event_cbNisnItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Refresh();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormInputDataNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormInputDataNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormInputDataNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormInputDataNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormInputDataNilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbJurusan;
    private javax.swing.JComboBox cbKelas;
    private javax.swing.JComboBox cbNamaSiswa;
    private javax.swing.JComboBox cbNisn;
    private javax.swing.JComboBox cbSemester;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtMapel;
    private javax.swing.JTextField txtNamaGuru;
    private javax.swing.JTextField txtNilai;
    private javax.swing.JTextField txtTA;
    // End of variables declaration//GEN-END:variables
}
