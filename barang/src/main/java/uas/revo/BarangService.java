package uas.revo;

import java.util.ArrayList;
import java.util.List;

public class BarangService {
    private List<Barang> daftarBarang = new ArrayList<>();
    private int nextId = 1;

    public void tambahBarang(String nama, int stok) {
        Barang barang = new Barang(nextId++, nama, stok);
        daftarBarang.add(barang);
    }

    public List<Barang> getAll() { return daftarBarang; }

    public Barang cariById(int id) {
        return daftarBarang.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    public boolean updateBarang(int id, String namaBaru, int stokBaru) {
        Barang barang = cariById(id);
        if (barang != null) {
            barang.setNama(namaBaru);
            barang.setStok(stokBaru);
            return true;
        }
        return false;
    }

    public boolean hapusBarang(int id) {
        Barang barang = cariById(id);
        return barang != null && daftarBarang.remove(barang);
    }
}
