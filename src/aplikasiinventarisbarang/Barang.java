package aplikasiinventarisbarang;

public class Barang {
    private int id;
    private String kodeBarang;
    private String namaBarang;
    private String tahunPembelian;
    private String kategori;
    private String kondisi;
    private String deskripsi;

    public Barang(int id, String kodeBarang, String namaBarang, String tahunPembelian, String kategori, String kondisi, String deskripsi) {
        this.id = id;
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.tahunPembelian = tahunPembelian;
        this.kategori = kategori;
        this.kondisi = kondisi;
        this.deskripsi = deskripsi;
    }

    // Constructor tanpa id
    public Barang(String kodeBarang, String namaBarang, String tahunPembelian, String kategori, String kondisi, String deskripsi) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.tahunPembelian = tahunPembelian;
        this.kategori = kategori;
        this.kondisi = kondisi;
        this.deskripsi = deskripsi;
    }

    // Getter dan Setter
    public int getId() {
        return id;
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

    public String getTahunPembelian() {
        return tahunPembelian;
    }

    public void setTahunPembelian(String tahunPembelian) {
        this.tahunPembelian = tahunPembelian;
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

