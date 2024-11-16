# Aplikasi Inventaris Barang

Aplikasi manajemen inventaris barang berbasis Java dengan antarmuka grafis menggunakan Swing dan penyimpanan data menggunakan MySQL.

## Keunggulan Aplikasi
- **Antarmuka User-Friendly**: Menggunakan Java Swing untuk tampilan yang mudah digunakan
- **Basis Data Terpusat**: Penyimpanan data menggunakan MySQL untuk manajemen data yang efisien
- **Arsitektur Terstruktur**: Menggunakan pola desain DAO dan Service Layer untuk pemisahan logika yang baik
- **Validasi Data**: Memiliki sistem validasi data untuk memastikan integritas data
- **Pencarian Fleksibel**: Fitur pencarian dengan berbagai kriteria (kode, nama, kategori, kondisi)
- **Data Portability**: Fitur ekspor dan impor data menggunakan format CSV

## Fitur Aplikasi
1. **Manajemen Data Barang**
   - Tambah barang baru
   - Lihat daftar barang
   - Update informasi barang
   - Hapus barang
   
2. **Pencarian dan Filter**
   - Pencarian berdasarkan kode barang
   - Filter berdasarkan kategori
   - Filter berdasarkan kondisi
   - Pencarian multi-kriteria

3. **Tampilan Data**
   - Tampilan tabel yang informatif
   - Informasi detail barang
   - Status kondisi barang
   - Riwayat tanggal pembelian

4. **Export & Import Data**
   - Export data ke file CSV
   - Import data dari file CSV
   - Format CSV yang terstandarisasi
   - Validasi data saat import
   - Backup data mudah

## Prasyarat

1. JDK 8 atau lebih tinggi
2. NetBeans IDE
3. MySQL Server
4. XAMPP/WampServer (opsional)
5. Library OpenCSV untuk fungsi import/export (sudah termasuk dalam project)

## Panduan Penggunaan Aplikasi
### 1. Menu Utama
Saat aplikasi dijalankan, Anda akan melihat tampilan utama yang terdiri dari:
- Table untuk menampilkan data barang
- Menu bar dengan berbagai fungsi
- Form input untuk pengelolaan barang
- Tombol-tombol aksi
### 2. Menambah Data Barang
1. Klik tombol "Tambah Baru"
2. Isi form dengan data barang:
   - Kode Barang (wajib diisi, format: B001, B002, dst)
   - Nama Barang (wajib diisi)
   - Tanggal Pembelian (pilih dari calendar)
   - Kategori (pilih dari dropdown)
   - Kondisi (pilih: Baik, Rusak Ringan, Rusak Berat)
   - Deskripsi (opsional)
3. Klik "Simpan" untuk menyimpan data
4. Sistem akan menampilkan pesan sukses jika berhasil
### 3. Mengedit Data Barang
1. Pilih barang yang akan diedit dari tabel
2. Klik tombol "Edit"
3. Form akan terisi dengan data barang yang dipilih
4. Ubah data yang diinginkan
5. Klik "Update" untuk menyimpan perubahan
### 4. Menghapus Data Barang
1. Pilih barang yang akan dihapus dari tabel
2. Klik tombol "Hapus"
3. Konfirmasi penghapusan pada dialog yang muncul
4. Klik "Ya" untuk menghapus data
### 5. Mencari Data Barang
#### Pencarian Cepat:
1. Ketik kata kunci di kolom pencarian
2. Hasil akan otomatis difilter sesuai kata kunci
#### Pencarian Detail:
1. Klik tombol "Pencarian Lanjut"
2. Isi kriteria pencarian:
   - Kode Barang
   - Nama Barang
   - Kategori
   - Kondisi
3. Klik "Cari" untuk menampilkan hasil
### 6. Export Data ke CSV
1. Klik menu "File" > "Export to CSV"
2. Pilih lokasi penyimpanan file
3. Beri nama file (contoh: "inventaris.csv")
4. Klik "Save"
5. Tunggu proses export selesai
6. File CSV akan tersimpan di lokasi yang dipilih
### 7. Import Data dari CSV
1. Siapkan file CSV dengan format yang sesuai:
```csv
kode_barang,nama_barang,tanggal_pembelian,kategori,kondisi,deskripsi
B001,Laptop Asus,2024-01-01,Elektronik,Baik,Laptop untuk kantor
```
2. Klik menu "File" > "Import from CSV"
3. Pilih file CSV yang akan diimpor
4. Klik "Open"
5. Tunggu proses import selesai
6. Data akan muncul di tabel utama
### 8. Memfilter Data
1. Gunakan dropdown filter di atas tabel:
   - Filter Kategori
   - Filter Kondisi
2. Pilih opsi yang diinginkan
3. Tabel akan menampilkan data sesuai filter
4. Pilih "Semua" untuk menampilkan semua data


### Panduan Export/Import CSV
1. **Export Data ke CSV**
   - Klik menu 'File' > 'Export to CSV'
   - Pilih lokasi penyimpanan file
   - Data akan tersimpan dalam format CSV standar

2. **Import Data dari CSV**
   - Klik menu 'File' > 'Import from CSV'
   - Pilih file CSV yang akan diimpor
   - Sistem akan memvalidasi format dan data
   - Data valid akan ditambahkan ke database

## Struktur Project

### Kelas-kelas Utama
1. **InventarisBarangFrame.java**
   - Kelas utama yang mengimplementasikan antarmuka pengguna (GUI)
   - Menggunakan Java Swing untuk komponen visual
     
3. **Barang.java**
   - Model class untuk entitas barang
   - Menyimpan atribut dan properti barang
   - Implementasi getter/setter

4. **BarangDAO.java**
   - Data Access Object untuk operasi database
   - Implementasi CRUD
   - Penanganan koneksi database

5. **BarangService.java**
   - Service layer untuk logika bisnis
   - Validasi data
   - Penanganan operasi kompleks

6. **DatabaseConnection.java**
   - Konfigurasi koneksi database
   - Manajemen koneksi

7. **BarangManagerUI.java**
   - Interface utama aplikasi
   - Implementasi JFrame
   - Manajemen tampilan tabel



### Struktur Database
Tabel: `barang`
```sql
CREATE TABLE barang (
    kode_barang VARCHAR(50) PRIMARY KEY,
    nama_barang VARCHAR(100) NOT NULL,
    tanggal_pembelian DATE,
    kategori VARCHAR(50),
    kondisi VARCHAR(50),
    deskripsi TEXT
);
```

# Pembuat Aplikasi
 Muhammad Akmal ( 2210010437 ) 
