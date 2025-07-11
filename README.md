# CRUD Barang JavaFX

Aplikasi sederhana berbasis JavaFX untuk mengelola data barang (CRUD: Create, Read, Update, Delete).

Deskripsi

Aplikasi ini memungkinkan pengguna untuk:
- Menambahkan data barang
- Menampilkan seluruh data barang dalam tabel
- Memperbarui data barang
- Menghapus data barang

Setiap barang memiliki:
- ID (unik, otomatis bertambah)
- Nama Barang
- Stok Barang

Semua data disimpan secara sementara di memori (tidak menggunakan database).

Teknologi

- Java 8 atau lebih baru
- JavaFX (GUI)
- IDE: Disarankan IntelliJ IDEA atau Eclipse

Struktur Paket


#Cara Menjalankan

1. Pastikan Java dan JavaFX sudah terinstal** di sistem kamu.
2. Clone atau download project ini.
3. Buka di IDE favoritmu.
4. Jalankan `App.java` sebagai aplikasi Java.

Jika kamu menggunakan Java 11 ke atas, pastikan menambahkan module JavaFX secara manual (misalnya via VM options atau Maven/Gradle).

Fitur Aplikasi

| Fitur       | Deskripsi |
|-------------|-----------|
| Tambah      | Menambahkan barang baru dengan nama dan stok |
| Tampil      | Menampilkan daftar barang dalam tabel |
| Update      | Mengubah data barang yang dipilih |
| Hapus       | Menghapus data barang dari daftar |

