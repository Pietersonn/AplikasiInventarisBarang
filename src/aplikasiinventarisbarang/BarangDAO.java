package aplikasiinventarisbarang;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BarangDAO {

    // Method untuk menambahkan data barang
    public void tambahBarang(Barang barang) {
        String sql = "INSERT INTO barang (kode_barang, nama_barang, tanggal_pembelian, kategori, kondisi, deskripsi) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, barang.getKodeBarang());
            stmt.setString(2, barang.getNamaBarang());
            stmt.setDate(3, new Date(barang.getTanggalPembelian().getTime())); // Konversi Date ke java.sql.Date
            stmt.setString(4, barang.getKategori());
            stmt.setString(5, barang.getKondisi());
            stmt.setString(6, barang.getDeskripsi());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method untuk mengambil semua data barang
    public List<Barang> getAllBarang() {
        List<Barang> daftarBarang = new ArrayList<>();
        String sql = "SELECT * FROM barang";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Barang barang = new Barang(
                    rs.getInt("id"),
                    rs.getString("kode_barang"),
                    rs.getString("nama_barang"),
                    rs.getDate("tanggal_pembelian"), // Mengambil java.sql.Date dan konversi ke java.util.Date
                    rs.getString("kategori"),
                    rs.getString("kondisi"),
                    rs.getString("deskripsi")
                );
                daftarBarang.add(barang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return daftarBarang;
    }

    // Method untuk memperbarui data barang
    public void updateBarang(Barang barang) {
        String sql = "UPDATE barang SET kode_barang = ?, nama_barang = ?, tanggal_pembelian = ?, kategori = ?, kondisi = ?, deskripsi = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, barang.getKodeBarang());
            stmt.setString(2, barang.getNamaBarang());
            stmt.setDate(3, new Date(barang.getTanggalPembelian().getTime())); // Konversi Date ke java.sql.Date
            stmt.setString(4, barang.getKategori());
            stmt.setString(5, barang.getKondisi());
            stmt.setString(6, barang.getDeskripsi());
            stmt.setInt(7, barang.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method untuk menghapus data barang
    public void hapusBarang(int id) {
        String sql = "DELETE FROM barang WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
