import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class KopiBerkas {
   public void kopi(String sumber, String sasaran) throws IOException {
        FileInputStream masukan = null;
        FileOutputStream keluaran = null;
        // Deklarasi variabel
        try { // menjaga file yang akan dieksekusi. ada kesalahn atau tidak
            // Object stream untuk masukkan
            masukan = new FileInputStream(sumber);
            keluaran = new FileOutputStream(sasaran);
            
            // Coba baca  dari stream
            int karakter = masukan.read();
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                keluaran.write(karakter);
                // Coba baca lagi dari stream
                karakter = masukan.read();
            }
            keluaran.flush();
        } 
        finally { // salah atau tidak eksekusi akan tetap dijalankan
            // Tutup stream masukan
            if (masukan != null) // null = pemberian nilai awal
                masukan.close(); // jangan lupa tutup
            if (keluaran != null)
                keluaran.close();
        }
    }
}