import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CaesarCipher {
    private int shift;
    
    public static void main (String[] args) throws IOException {
        try {
            CaesarCipher c = new CaesarCipher(3);
            c.enkripsi("README.txt","kopi.txt");
        }
        catch (IOException kesalahan){
            System.out.printf("Terjadi kesalahan : %s",kesalahan);
        }
    }
    
    public CaesarCipher(int shift)  {
        this.shift = shift;
    }
    
    public void enkripsi (String sumber, String sasaran)throws IOException{
       FileInputStream masukCC = null;
        FileOutputStream keluarCC = null;
        // Deklarasi variabel
        try { // menjaga file yang akan dieksekusi. ada kesalahn atau tidak
            // Object stream untuk masukkan
            masukCC = new FileInputStream(sumber);
            keluarCC = new FileOutputStream(sasaran);
            
            // Coba baca  dari stream
            int karakter = masukCC.read();
           
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {
                 karakter = karakter +shift;
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                keluarCC.write(karakter);
                // Coba baca lagi dari stream
                karakter = masukCC.read();
            }
            keluarCC.flush();
        } 
        finally { // salah atau tidak eksekusi akan tetap dijalankan
            // Tutup stream masukan
            if (masukCC != null) // null = pemberian nilai awal
                masukCC.close(); // jangan lupa tutup
            if (keluarCC != null)
                keluarCC.close();
        }
    
    
    }
    
    public void dekripsi (String sumber, String sasaran)throws IOException{
         FileInputStream masukCC = null;
        FileOutputStream keluarCC = null;
        // Deklarasi variabel
        try { // menjaga file yang akan dieksekusi. ada kesalahn atau tidak
            // Object stream untuk masukkan
            masukCC = new FileInputStream(sumber);
            keluarCC = new FileOutputStream(sasaran);
            
            // Coba baca  dari stream
            int karakter = masukCC.read();
            
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {
                karakter = karakter -shift;
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                keluarCC.write(karakter);
                // Coba baca lagi dari stream
                karakter = masukCC.read();
            }
            keluarCC.flush();
        } 
        finally { // salah atau tidak eksekusi akan tetap dijalankan
            // Tutup stream masukan
            if (masukCC != null) // null = pemberian nilai awal
                masukCC.close(); // jangan lupa tutup
            if (keluarCC != null)
                keluarCC.close();
        }
    }
    
}