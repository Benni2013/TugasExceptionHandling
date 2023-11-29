public class Transaksi extends Barang implements TotalBayar{
    private Integer nomorFaktur;
    private String namaPelanggan;
    private String nomorHp;
    private Integer jumlahBeli;

    public Transaksi(Integer nomorFaktur, String namaPelanggan, String nomorHp, String namaBarang, Double hargaBarang, Integer jumlahBeli) {
        super(namaBarang, hargaBarang);
        this.nomorFaktur = nomorFaktur;
        this.namaPelanggan = namaPelanggan;
        this.nomorHp = nomorHp;
        this.jumlahBeli = jumlahBeli;
    }

    public Double hitungTotalBayar(Double harga, Integer jumlah) {
        return harga * jumlah;
    }

    public void tampilkanTransaksi() {
        System.out.println("No. Faktur: " + nomorFaktur);
        System.out.println("Nama Pelanggan: " + namaPelanggan);
        System.out.println("No. HP: " + nomorHp);
        System.out.println("Nama Barang: " + getNamaBarang());
        System.out.println("Harga Barang: " + getHargaBarang());
        System.out.println("Jumlah Beli: " + jumlahBeli);
        System.out.println("Total Bayar: " + hitungTotalBayar(getHargaBarang(), jumlahBeli));
    }
     
}
