package aplikasiinventarisbarang;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class BarangManagerUI extends JFrame {
    private JTable jTable1;
    private DefaultTableModel tableModel;

    public BarangManagerUI() {
        initUI();
        loadDataToTable();
    }

    private void initUI() {
        setTitle("Manajemen Barang");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inisialisasi JTable dan DefaultTableModel
        tableModel = new DefaultTableModel();
        jTable1 = new JTable(tableModel);

        // Menambahkan kolom ke tabel
        tableModel.addColumn("Kode Barang");
        tableModel.addColumn("Nama Barang");
        tableModel.addColumn("Tanggal Pembelian");
        tableModel.addColumn("Kategori");
        tableModel.addColumn("Kondisi");
        tableModel.addColumn("Deskripsi");

        // Menambahkan JTable ke JScrollPane
        JScrollPane scrollPane = new JScrollPane(jTable1);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void loadDataToTable() {
        BarangDAO barangDAO = new BarangDAO();
        List<Barang> listBarang = barangDAO.getAllBarang();

        // Menghapus data yang ada di tabel
        tableModel.setRowCount(0);

        // Mengisi data ke dalam tabel
        for (Barang barang : listBarang) {
            Object[] row = {
                barang.getKodeBarang(),
                barang.getNamaBarang(),
                barang.getTanggalPembelian(),
                barang.getKategori(),
                barang.getKondisi(),
                barang.getDeskripsi()
            };
            tableModel.addRow(row);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BarangManagerUI managerUI = new BarangManagerUI();
            managerUI.setVisible(true);
        });
    }
}
