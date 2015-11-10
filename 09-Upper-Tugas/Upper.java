import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Upper{
    public static void main (String[] args){
        try {
            Upper x = new Upper();
            x.upper("README.txt","kopi.txt");
        }
        catch (IOException kesalahan){
            System.out.printf("Terjadi kesalahan : %s",kesalahan);
        }
    }
    
   public void upper(String sumber, String sasaran) throws IOException {
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
               karakter = Character.toUpperCase(karakter);
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
