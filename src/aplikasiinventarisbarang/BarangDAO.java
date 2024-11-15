package aplikasiinventarisbarang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BarangDAO {

    // Method untuk menambah barang
    public void tambahBarang(Barang barang) {
        String sql = "INSERT INTO barang (kode_barang, nama_barang, tahun_pembelian, kategori, kondisi, deskripsi) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, barang.getKodeBarang());
            stmt.setString(2, barang.getNamaBarang());
            stmt.setString(3, barang.getTahunPembelian());
            stmt.setString(4, barang.getKategori());
            stmt.setString(5, barang.getKondisi());
            stmt.setString(6, barang.getDeskripsi());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method untuk mendapatkan semua barang
    public List<Barang> getSemuaBarang() {
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
                    rs.getString("tahun_pembelian"),
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

    // Method untuk mengupdate barang
    public void updateBarang(Barang barang) {
        String sql = "UPDATE barang SET nama_barang = ?, tahun_pembelian = ?, kategori = ?, kondisi = ?, deskripsi = ? WHERE kode_barang = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, barang.getNamaBarang());
            stmt.setString(2, barang.getTahunPembelian());
            stmt.setString(3, barang.getKategori());
            stmt.setString(4, barang.getKondisi());
            stmt.setString(5, barang.getDeskripsi());
            stmt.setString(6, barang.getKodeBarang());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method untuk menghapus barang
    public void hapusBarang(String kodeBarang) {
        String sql = "DELETE FROM barang WHERE kode_barang = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, kodeBarang);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

