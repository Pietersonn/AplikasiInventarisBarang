package aplikasiinventarisbarang;

import java.util.List;
import java.util.ArrayList;


public class BarangService {

    private final BarangDAO barangDAO;

    public BarangService() {
        this.barangDAO = new BarangDAO();
    }

    /**
     * Mengambil semua data barang
     */
    public List<Barang> getAllBarang() {
        return barangDAO.getAllBarang();
    }

    /**
     * Mencari barang berdasarkan kode
     */
    public Barang getBarangByKode(String kodeBarang) {
        return barangDAO.getBarangByKode(kodeBarang);
    }

    /**
     * Menyimpan barang baru
     */
    public boolean saveBarang(Barang barang) {
        if (isValidBarang(barang)) {
            return barangDAO.insertBarang(barang);
        }
        return false;
    }

    /**
     * Mengupdate data barang
     */
    public boolean updateBarang(Barang barang) {
        if (isValidBarang(barang)) {
            return barangDAO.updateBarang(barang);
        }
        return false;
    }

    /**
     * Menghapus barang
     */
    public boolean deleteBarang(String kodeBarang) {
        if (kodeBarang != null && !kodeBarang.trim().isEmpty()) {
            return barangDAO.deleteBarang(kodeBarang);
        }
        return false;
    }

    /**
     * Validasi data barang
     */
    private boolean isValidBarang(Barang barang) {
        return barang != null
                && barang.getKodeBarang() != null && !barang.getKodeBarang().trim().isEmpty()
                && barang.getNamaBarang() != null && !barang.getNamaBarang().trim().isEmpty()
                && barang.getTanggalPembelian() != null
                && barang.getKategori() != null && !barang.getKategori().trim().isEmpty()
                && barang.getKondisi() != null && !barang.getKondisi().trim().isEmpty();
    }

    /**
     * Mencari barang berdasarkan beberapa kriteria
     */
    public List<Barang> cariBarang(String kodeBarang, String namaBarang, String kategori, String kondisi) {
        List<Barang> hasil = new ArrayList<>();
        List<Barang> semuaBarang = getAllBarang();

        for (Barang barang : semuaBarang) {
            if (barang.getKodeBarang().contains(kodeBarang)
                    && barang.getNamaBarang().contains(namaBarang)
                    && (kategori.equals(" ") || barang.getKategori().equals(kategori))
                    && (kondisi.equals(" ") || barang.getKondisi().equals(kondisi))) {
                hasil.add(barang);
            }
        }

        return hasil;
    }
}