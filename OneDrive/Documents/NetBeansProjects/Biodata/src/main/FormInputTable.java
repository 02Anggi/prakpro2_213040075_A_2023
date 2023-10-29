/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;

public class FormInputTable extends AbstractTableModel {
     // kode berikut untuk mendefinisikan nama-nama kolom
    private String[] columnNames = {"Nama", "Nomor HP", "Jenis Kelamin", "Alamat"};
    // kode berikut untuk data tabel disimpan dalam ArrayList dari ArrayList String
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

    // kode berikut untuk mengembalikan jumlah kolom dalam tabel
    public int getColumnCount() {
        return columnNames.length;
    }

    // kode berikut untuk mengembalikan jumlah baris dalam tabel
    public int getRowCount() {
        return data.size();
    }

    // kode berikut untuk mengembalikan nama kolom pada indeks tertentu
    public String getColumnName(int col) {
        return columnNames[col];
    }

    // kode berikut untuk mengembalikan nilai pada sel yang ditentukan oleh baris dan kolom
    public Object getValueAt(int row, int col) {
        List<String> rowItem = data.get(row);
        return rowItem.get(col);
    }

    // kode berikut untuk mendefinisikan sel-sel tabel sebagai tidak dapat diedit
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    // kode berikut untuk memanggil data
    public ArrayList<ArrayList<String>> getData() {
        return data;
    }

    @Override
    // kode berikut untuk membuat setValueAct
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ArrayList<String> row = data.get(rowIndex);
        row.set(columnIndex, (String) aValue);
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    // kode berikut untuk menambahkan baris data baru ke tabel
    public void add(ArrayList<String> value) {
        data.add(value);

        // kode berikut untuk memicu event untuk memberi tahu bahwa baris baru telah ditambahkan
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    // kode berikut untuk mengubah baris data ke tabel
    public void update(ArrayList<String> newValue, int row) {
        data.set(row, newValue);
        fireTableRowsUpdated(row, row);
    }

    // kode berikut untuk menghapus baris data ke tabel
    public void delete(int row) {
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }
}



/**
 *
 * @author raden
 */

