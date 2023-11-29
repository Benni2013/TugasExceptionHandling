public class Barang {
    private String namaBarang;
    private Double hargaBarang;

    public Barang (String namaBarang, Double hargaBarang){
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public Double getHargaBarang() {
        return hargaBarang;
    }
}
