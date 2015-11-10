import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Merge {

    public void merge (String file1, String file2, String file3, String sasaran)throws IOException {
         FileInputStream gabung1 = null;
         FileInputStream gabung2 = null;
         FileInputStream gabung3 = null;
         FileOutputStream keluaran = null;
        // Deklarasi variabel
        try { // menjaga file yang akan dieksekusi. ada kesalahn atau tidak
            // Object stream untuk masukkan
            gabung1 = new FileInputStream(file1);
            gabung2 = new FileInputStream(file2);
            gabung3 = new FileInputStream(file3);
            keluaran = new FileOutputStream(sasaran);
            
            // Coba baca  dari stream
            int karakter = gabung1.read();
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                keluaran.write(karakter);
                // Coba baca lagi dari stream
                karakter = gabung1.read();
            }
            
            
            keluaran = new FileOutputStream(sasaran,true);
            karakter = gabung2.read();
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                keluaran.write(karakter);
                // Coba baca lagi dari stream
                karakter = gabung2.read();
            }
            
            
            keluaran = new FileOutputStream(sasaran,true);
            karakter = gabung3.read();
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                keluaran.write(karakter);
                // Coba baca lagi dari stream
                karakter = gabung3.read();
            }
            
            keluaran.flush();
        } 
        finally { // salah atau tidak eksekusi akan tetap dijalankan
            // Tutup stream masukan
            if (gabung1 !=null) // null = pemberian nilai awal
                gabung1.close();
            if (gabung2 != null)
                gabung2.close();
            if (gabung3 != null)
                gabung3.close(); 
                
        
           if (keluaran != null)
            keluaran.close();
        
        }
    }
    }
