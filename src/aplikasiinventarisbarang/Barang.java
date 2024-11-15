package aplikasiinventarisbarang;

import java.util.Date;

public class Barang {

    private String kodeBarang;
    private String namaBarang;
    private Date tanggalPembelian;
    private String kategori;
    private String kondisi;
    private String deskripsi;

    public Barang(String kodeBarang, String namaBarang, Date tanggalPembelian,
            String kategori, String kondisi, String deskripsi) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.tanggalPembelian = tanggalPembelian;
        this.kategori = kategori;
        this.kondisi = kondisi;
        this.deskripsi = deskripsi;
    }

    // Getters
    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public Date getTanggalPembelian() {
        return tanggalPembelian;
    }

    public String getKategori() {
        return kategori;
    }

    public String getKondisi() {
        return kondisi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    // Setters
    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setTanggalPembelian(Date tanggalPembelian) {
        this.tanggalPembelian = tanggalPembelian;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public String toString() {
        return "Barang{"
                + "kodeBarang='" + kodeBarang + '\''
                + ", namaBarang='" + namaBarang + '\''
                + ", tanggalPembelian=" + tanggalPembelian
                + ", kategori='" + kategori + '\''
                + ", kondisi='" + kondisi + '\''
                + ", deskripsi='" + deskripsi + '\''
                + '}';
    }
}
