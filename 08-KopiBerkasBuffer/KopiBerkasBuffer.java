import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class KopiBerkasBuffer{
    
    public void kopi(String sumber, String sasaran) throws IOException{
        FileInputStream masukan = null;
        FileOutputStream keluaran = null;
        BufferedInputStream masukanBuffer = null;
        BufferedOutputStream keluaranBuffer = null;
        // Deklarasi variabel
        try { // menjaga file yang akan dieksekusi. ada kesalahn atau tidak
            // Object stream untuk masukkan
            masukan = new FileInputStream(sumber);
            masukanBuffer = new BufferedInputStream(masukan);

            keluaran = new FileOutputStream(sasaran);
            keluaranBuffer = new BufferedOutputStream(keluaran);
            
            
            // Coba baca  dari stream
            // Coba baca  dari stream
            int karakter = masukanBuffer.read();
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {
                // Lakukan sesuatu dengan data yang dibaca => Tampilkan
                keluaranBuffer.write(karakter);
                // Coba baca lagi dari stream
                karakter = masukanBuffer.read();
            }
            keluaranBuffer.flush();
        } 
        finally { // salah atau tidak eksekusi akan tetap dijalankan
            // Tutup stream masukan
            if (masukan != null) // null = pemberian nilai awal
                masukan.close(); // jangan lupa tutup
            if (keluaran != null)
                keluaran.close();
        }

    }
   
    public static void main (String[] args){
        try {
            KopiBerkasBuffer x = new KopiBerkasBuffer();
            x.kopi("README.txt","kopi.txt");
        }
        catch (IOException kesalahan){
            System.out.printf("Terjadi kesalahan : %s",kesalahan);
        }
    }

}