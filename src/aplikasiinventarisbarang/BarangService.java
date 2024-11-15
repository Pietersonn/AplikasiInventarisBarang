package aplikasiinventarisbarang;


import java.util.List;
import java.util.ArrayList;


public class BarangService {

    private final BarangDAO barangDAO;

    public BarangService() {
        this.barangDAO = new BarangDAO();
    }

    public List<Barang> getAllBarang() {
        return barangDAO.getAllBarang();
    }

    public Barang getBarangByKode(String kodeBarang) {
        return barangDAO.getBarangByKode(kodeBarang);
    }

    public boolean saveBarang(Barang barang) {
        if (isValidBarang(barang)) {
            return barangDAO.insertBarang(barang);
        }
        return false;
    }

    public boolean updateBarang(Barang barang) {
        if (isValidBarang(barang)) {
            return barangDAO.updateBarang(barang);
        }
        return false;
    }

    public boolean deleteBarang(String kodeBarang) {
        if (kodeBarang != null && !kodeBarang.trim().isEmpty()) {
            return barangDAO.deleteBarang(kodeBarang);
        }
        return false;
    }

    private boolean isValidBarang(Barang barang) {
        return barang != null
                && barang.getKodeBarang() != null && !barang.getKodeBarang().trim().isEmpty()
                && barang.getNamaBarang() != null && !barang.getNamaBarang().trim().isEmpty()
                && barang.getTanggalPembelian() != null
                && barang.getKategori() != null && !barang.getKategori().trim().isEmpty()
                && barang.getKondisi() != null && !barang.getKondisi().trim().isEmpty();
    }

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
