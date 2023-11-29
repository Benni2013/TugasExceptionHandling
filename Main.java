import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {    
    public static void main(String[] args) {
        //membuat scanner
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerDou = new Scanner(System.in);

        //input data dari pengguna
        //input nomor faktur + exception handling jika nomor faktur tidak valid
        Boolean inputFakturValid = true;
        Integer nomorFaktur = 0;
        while (inputFakturValid) {
            try {
                System.out.print("Input No. Faktur: ");
                nomorFaktur = scannerInt.nextInt();
                inputFakturValid = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: Input nomor faktur tidak valid. Silakan coba lagi.");
                scannerInt.next();
            }
        }

        System.out.print("Input Nama Pelanggan: ");
        String namaPelanggan = scannerStr.nextLine();

        System.out.print("Input No. HP: ");
        String nomorHp = scannerStr.nextLine();

        System.out.print("Input Nama Barang: ");
        String namaBarang = scannerStr.nextLine();

        //input harga barang + exception handling jika harga barang tidak valid
        Boolean inputHargaValid = true;
        Double hargaBarang = 0.0;
        while (inputHargaValid) {
            try {
                System.out.print("Input Harga Barang: ");
                hargaBarang = scannerDou.nextDouble();
                if (hargaBarang < 0) {
                    throw new ArithmeticException("Harga barang tidak boleh minus.");
                }
                inputHargaValid = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: Input harga barang tidak valid. Silakan coba lagi.");
                scannerDou.next(); 
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        //input jumlah beli + exception handling jika jumlah beli tidak valid
        Boolean inputJumlahValid = true;
        Integer jumlahBeli = 0;
        while (inputJumlahValid) {
            try {
                System.out.print("Input Jumlah Beli: ");
                jumlahBeli = scannerInt.nextInt();
                if (jumlahBeli <= 0) {
                    throw new ArithmeticException("Jumlah barang harus lebih dari 0.");
                }
                inputJumlahValid = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: Input jumlah barang tidak valid. Silakan coba lagi.");
                scannerInt.next();
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("--------------------------");

        //membuat objek transaksi bertipe Barang (polimorphysme)
        Barang transaksi = new Transaksi(nomorFaktur, namaPelanggan, nomorHp, namaBarang, hargaBarang, jumlahBeli);
        
        /* menampilkan detail transaksi dengan melakukan downcasting terlebih dahulu 
        agar dapat menggunakan method tampilkanTransaksi() */
        ((Transaksi) transaksi).tampilkanTransaksi(); //polimorphysme
        
        //tutup scanner
        scannerStr.close();
        scannerInt.close();
        scannerDou.close();
    }
    
}
