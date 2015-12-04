/**
 * Write a description of class KirimInfo here.
 * 
 * @author ADELIA SAFITRI
 * @NIM 1408107010023
 */
import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

public class KirimInfo {
    public void whois(String namaDomain) 
                throws UnknownHostException, IOException {
        // 0. Buka socket
        koneksi = new Socket("192.168.43.139",33333); 

        // Kirim perintah untuk informasi namaDomain
        kirimPerintah(namaDomain);
        
        // Baca balasannya
        //bacaBalasan();

        // Tutup socket-nya => dengan sendirinya menutup semua stream
        koneksi.close();
    }
    
    public void kirimPerintah(String namaDomain) throws IOException {
        // 1 & 2. Minta socket untuk ditulis dan Langsung dibuka
        OutputStream keluaran = koneksi.getOutputStream();
        // Note: Karena protokol-nya berbasis teks pakai writer aja.
        Writer keluaranWriter = new OutputStreamWriter(keluaran); 
        // 3. Selagi ada data kirim
        keluaranWriter.write(namaDomain);
        // Syarat protokol-nya, semua perintah diakhiri dengan: CR & LF
        keluaranWriter.write("Adelia Safitri (1408107010023)\r\n"); 
        keluaranWriter.flush(); // Paksa kirim data yang belum terkirim
    }

    private Socket koneksi = null;
}
    