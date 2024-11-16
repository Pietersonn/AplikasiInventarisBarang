package aplikasiinventarisbarang;

import java.util.Date;

/**
 * Kelas ini merepresentasikan sebuah barang dalam sistem inventaris
 * Menyimpan informasi detail tentang sebuah barang seperti kode, nama,
 * tanggal pembelian, kategori, kondisi, dan deskripsi
 */
public class Barang {
    private String kodeBarang;
    private String namaBarang;
    private Date tanggalPembelian;
    private String kategori;
    private String kondisi;
    private String deskripsi;

    /**
     * Konstruktor untuk membuat objek Barang baru
     */
    public Barang(String kodeBarang, String namaBarang, Date tanggalPembelian,
            String kategori, String kondisi, String deskripsi) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.tanggalPembelian = tanggalPembelian;
        this.kategori = kategori;
        this.kondisi = kondisi;
        this.deskripsi = deskripsi;
    }

    // Getter dan Setter
    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public Date getTanggalPembelian() {
        return tanggalPembelian;
    }

    public void setTanggalPembelian(Date tanggalPembelian) {
        this.tanggalPembelian = tanggalPembelian;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public String toString() {
        return "Barang{" + "kodeBarang='" + kodeBarang + "', " +
               "namaBarang='" + namaBarang + "', " +
               "tanggalPembelian=" + tanggalPembelian + ", " +
               "kategori='" + kategori + "', " +
               "kondisi='" + kondisi + "', " +
               "deskripsi='" + deskripsi + "'}";
    }
}