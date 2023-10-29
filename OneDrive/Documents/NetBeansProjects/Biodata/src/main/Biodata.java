/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class Biodata extends JFrame {
    private void simpanFile(ArrayList<ArrayList<String>> data) {
        // kode berikut untuk menampilkan pesan konfirmasi
        int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menyimpan file '.txt' ?",
        "Konfirmasi", JOptionPane.YES_NO_OPTION);
       
        if(konfirmasi == JOptionPane.YES_OPTION) {
            try {
                // kode berikut untuk menulis lokasi file
                BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
           
                for(ArrayList<String> row : data) {
                    // kode berikut untuk memisahkan beberapa data dengan melalui tab
                    for (String s : row) {
                        writer.write(s + "\t");
                    }
                    // kode berikut untuk memindahkan data ke baris yang baru
                    writer.newLine();
                }
                writer.close();
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke file ini");
            }
            catch(IOException e) {
                JOptionPane.showMessageDialog(null, "Data gagal disimpan ke file ini.");
                e.printStackTrace();
            }
        }
    }

    public Biodata() {
        // kode berikut untuk mengatur layout frame menjadi null
        this.setLayout(null);

        // kode berikut untuk membuat label untuk Nama
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 40, 100, 10);

        // kode berikut untuk membuat TextField untuk Nama
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        // kode berikut untuk membuat label untuk Nomor HP
        JLabel labelNomorHP = new JLabel("Nomor HP:");
        labelNomorHP.setBounds(15, 100, 100, 10);

        // kode berikut untuk membuat TextField untuk Nomor HP
        JTextField textFieldNomorHP = new JTextField();
        textFieldNomorHP.setBounds(15, 120, 350, 30);

        // kode berikut untuk membuat label untuk Jenis Kelamin
        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        labelRadio.setBounds(15, 160, 350, 10);

        // kode berikut untuk membuat RadioButton "Laki-Laki"
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki");
        radioButton1.setBounds(15, 180, 350, 30);

        // kode berikut untuk membuat RadioButton "Perempuan"
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15, 210, 350, 30);

        // kode berikut untuk membuat label "Alamat"
        JLabel labelAlamat = new JLabel("Alamat:");
        labelAlamat.setBounds(15, 240, 350, 30);

        // kode berikut untuk membuat TextArea "Alamat"
        JTextArea textAreaAlamat = new JTextArea(5, 20);
        textAreaAlamat.setBounds(15, 270, 350, 100);

        // kode berikut untuk membuat ButtonGroup untuk mengelola RadioButton
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        // kode berikut untuk membuat tombol "Simpan"
        JButton buttonAdd = new JButton("Simpan");
        buttonAdd.setBounds(15, 380, 100, 40);

        // kode berikut untuk membuat tombol "Edit"
        JButton buttonUpdate = new JButton("Edit");
        buttonUpdate.setBounds(120, 380, 100, 40);

        // kode berikut untuk membuat tombol "Hapus"
        JButton buttonDelete = new JButton("Hapus");
        buttonDelete.setBounds(225, 380, 100, 40);

        // kode berikut untuk membuat tombol "Simpan ke File"
        JButton buttonSave = new JButton("Simpan Ke File");
        buttonSave.setBounds(330, 380, 120, 40);

        // kode berikut untuk membuat tabel JTable
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 430, 560, 150);

        // kode berikut untuk membuat FormInputTable
        FormInputTable formInputTable = new FormInputTable();
        table.setModel(formInputTable);

        // kode berikut untuk menambahkan ActionListener pada tombol "Simpan"
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // kode berikut untuk mengambil data dari inputan Nama, Nomor HP, Jenis Kelamin, dan Alamat
                String jenisKelamin = "";
                String nama = textFieldNama.getText();
                String nomorHP = textFieldNomorHP.getText();
                String alamat = textAreaAlamat.getText();

                // kode berikut untuk memberikan notifikasi hanya boleh memilih satu jenis kelamin
                if(radioButton1.isSelected() && radioButton2.isSelected()) {
                    JOptionPane.showMessageDialog(Biodata.this, "Hanya satu jenis kelamin dipilih!",
                    "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
                else if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }
                else if(radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }
                else {
                    // kode berikut untuk memberikan notifikasi jika jenis kelamin belum dipilih
                    JOptionPane.showMessageDialog(Biodata.this, "Pilih jenis kelamin terlebih dahulu!",
                    "Kesalahan", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // kode berikut untuk validasi data kosong
                if(nama.isEmpty() || nomorHP.isEmpty() || alamat.isEmpty()) {
                    JOptionPane.showMessageDialog(Biodata.this, "Semua input harus diisi!",
                    "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    // kode berikut untuk mengonfirmasi sebelum melakukan penyimpanan data
                    int konfirmasi = JOptionPane.showConfirmDialog(Biodata.this, "Apakah anda yakin menyimpan data ?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);

                    if(konfirmasi == JOptionPane.YES_OPTION) {
                        // kode berikut untuk menambahkan data ke model tabel
                        formInputTable.add(new ArrayList<>(Arrays.asList(nama, nomorHP, jenisKelamin, alamat)));
                        // kode berikut untuk membersihkan input setelah penyimpanan
                        textFieldNama.setText("");
                        textFieldNomorHP.setText("");
                        textAreaAlamat.setText("");
                        labelRadio.setText("Jenis Kelamin: ");
                    }
                }
            }
        });

        // kode berikut untuk menambahkan ActionListener pada tombol "Edit"
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Silahkan pilih data akan diubah!");
                    return;
                }

                // kode berikut untuk mengambil data dari inputan Nama, Nomor HP, Jenis Kelamin, dan Alamat
                String jenisKelamin = "";
                String nama = textFieldNama.getText();
                String nomorHP = textFieldNomorHP.getText();
                String alamat = textAreaAlamat.getText();

                // kode berikut untuk memberikan notifikasi hanya boleh memilih satu jenis kelamin
                if(radioButton1.isSelected() && radioButton2.isSelected()) {
                    JOptionPane.showMessageDialog(Biodata.this, "Hanya satu jenis kelamin dipilih!",
                            "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
                else if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }
                else if(radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }
                else {
                    // kode berikut untuk memberikan notifikasi jika jenis kelamin belum dipilih
                    JOptionPane.showMessageDialog(Biodata.this, "Pilih jenis kelamin terlebih dahulu!",
                            "Kesalahan", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // kode berikut untuk validasi data kosong
                if(nama.isEmpty() || nomorHP.isEmpty() || alamat.isEmpty()) {
                    JOptionPane.showMessageDialog(Biodata.this, "Semua input harus diisi!",
                            "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    // kode berikut untuk mengonfirmasi sebelum melakukan pengubahan data
                    int konfirmasi = JOptionPane.showConfirmDialog(Biodata.this, "Apakah anda yakin mengubah data ?",
                            "Konfirmasi", JOptionPane.YES_NO_OPTION);

                    if(konfirmasi == JOptionPane.YES_OPTION) {
                        // kode berikut untuk menambahkan data ke model tabel
                        ArrayList<String> data = new ArrayList<String>(Arrays.asList(nama, nomorHP, jenisKelamin, alamat));
                        formInputTable.update(data, row);

                        // kode berikut untuk membersihkan input setelah penyimpanan
                        textFieldNama.setText("");
                        textFieldNomorHP.setText("");
                        textAreaAlamat.setText("");
                        labelRadio.setText("Jenis Kelamin: ");
                    }
                }
            }
        });

        // kode berikut untuk menambahkan ActionListener pada tombol "Hapus"
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if(selectedRow >= 0) {
                    // kode berikut untuk memberikan notifikasi pesan konfirmasi
                    int option = JOptionPane.showConfirmDialog(Biodata.this, "Apakah anda yakin menghapus data ?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);
                   
                    if(option == JOptionPane.YES_OPTION) {
                        // kode berikut untuk memanggil metode deleteRow untuk menghapus isi data tabel
                        formInputTable.delete(selectedRow);
                        JOptionPane.showMessageDialog(Biodata.this, "Data berhasil dihapus!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                // kode berikut untuk memberikan notifikasi pesan baris mana yang akan dihapus
                else {
                    JOptionPane.showMessageDialog(Biodata.this, "Pilih baris yang akan dihapus!",
                    "Konfirmasi", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // kode berikut untuk menambahkan ActionListener pada tombol "Simpan ke File"
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpanFile(formInputTable.getData());
            }
        });

        // kode berikut untuk mengurusi jelang penutupan frame
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // kode berikut untuk memberikan notifikasi pesan konfirmasi
                int konfirmasi = JOptionPane.showConfirmDialog(Biodata.this,
                        "Anda yakin ingin keluar ?", "Konfirmasi",JOptionPane.YES_NO_OPTION);
                if(konfirmasi == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

        // kode berikut untuk menambahkan komponen-komponen ke frame
        this.add(buttonAdd);
        this.add(buttonUpdate);
        this.add(buttonDelete);
        this.add(buttonSave);
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelNomorHP);
        this.add(textFieldNomorHP);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(labelAlamat);
        this.add(textAreaAlamat);
        this.add(scrollableTable);

        // kode berikut untuk mengatur ukuran dan tata letak frame
        this.setSize(600, 650);
        this.setVisible(true);
    }

    // kode berikut untuk mennjalankan program 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Biodata m = new Biodata();
                m.setVisible(true);
            }
        });
    }
}


/**
 *
 * @author raden
 */