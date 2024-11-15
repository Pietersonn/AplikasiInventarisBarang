package aplikasiinventarisbarang;

import java.util.Date;

public class Barang {
    private int id;
    private String kodeBarang;
    private String namaBarang;
    private Date tanggalPembelian; // Menggunakan tipe Date
    private String kategori;
    private String kondisi;
    private String deskripsi;

    // Constructor
    public Barang(int id, String kodeBarang, String namaBarang, Date tanggalPembelian, String kategori, String kondisi, String deskripsi) {
        this.id = id;
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.tanggalPembelian = tanggalPembelian;
        this.kategori = kategori;
        this.kondisi = kondisi;
        this.deskripsi = deskripsi;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
