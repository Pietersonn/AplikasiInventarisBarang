package aplikasiinventarisbarang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarangDAO {
    
    public List<Barang> getAllBarang() {
        List<Barang> listBarang = new ArrayList<>();
        String query = "SELECT * FROM barang";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Barang barang = mapResultSetToBarang(resultSet);
                listBarang.add(barang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listBarang;
    }
    
    public Barang getBarangByKode(String kodeBarang) {
        String query = "SELECT * FROM barang WHERE kode_barang = ?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, kodeBarang);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return mapResultSetToBarang(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean insertBarang(Barang barang) {
        String query = "INSERT INTO barang (kode_barang, nama_barang, tanggal_pembelian, " +
                      "kategori, kondisi, deskripsi) VALUES (?, ?, ?, ?, ?, ?)";
                      
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            setStatementParameters(statement, barang);
            return statement.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateBarang(Barang barang) {
        String query = "UPDATE barang SET nama_barang = ?, tanggal_pembelian = ?, " +
                      "kategori = ?, kondisi = ?, deskripsi = ? WHERE kode_barang = ?";
                      
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, barang.getNamaBarang());
            statement.setDate(2, new java.sql.Date(barang.getTanggalPembelian().getTime()));
            statement.setString(3, barang.getKategori());
            statement.setString(4, barang.getKondisi());
            statement.setString(5, barang.getDeskripsi());
            statement.setString(6, barang.getKodeBarang());
            
            return statement.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteBarang(String kodeBarang) {
        String query = "DELETE FROM barang WHERE kode_barang = ?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, kodeBarang);
            return statement.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private Barang mapResultSetToBarang(ResultSet rs) throws SQLException {
        return new Barang(
            rs.getString("kode_barang"),
            rs.getString("nama_barang"),
            rs.getDate("tanggal_pembelian"),
            rs.getString("kategori"),
            rs.getString("kondisi"),
            rs.getString("deskripsi")
        );
    }
    
    private void setStatementParameters(PreparedStatement statement, Barang barang) throws SQLException {
        statement.setString(1, barang.getKodeBarang());
        statement.setString(2, barang.getNamaBarang());
        statement.setDate(3, new java.sql.Date(barang.getTanggalPembelian().getTime()));
        statement.setString(4, barang.getKategori());
        statement.setString(5, barang.getKondisi());
        statement.setString(6, barang.getDeskripsi());
    }
}