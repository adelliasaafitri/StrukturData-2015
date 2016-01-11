import java.net.Socket;
import java.net.InetAddress;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.ArrayList;

public class ClientProcess implements Runnable {

    ArrayList <PohonKu> pohon = new ArrayList <PohonKu> ();
    Penyimpanan simpan;

    public ClientProcess(Socket koneksi, Penyimpanan simpan) {
        this.koneksi = koneksi;
        this.simpan = simpan;
    }

    public void run() {        
        if (koneksi != null) {
            // Ambil IP dari koneksi
            ipStr = koneksi.getInetAddress().getHostAddress();

            try {
                // Ambil InputStream
                masukan = koneksi.getInputStream();
                masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
                // Ambil OutputStream
                keluaran = koneksi.getOutputStream();
                keluaranWriter = new BufferedWriter(new OutputStreamWriter(keluaran)); 

                // Selama masih terhubung dengan client tangani
                tangani();
            }
            catch(IOException salah) { 
                System.out.println(salah);
            }
            finally {
                try { 
                    // Tutup koneksi
                    koneksi.close();
                }
                catch(IOException salah) {
                    System.out.println(salah);
                }                
            }
        }
    }

    private void tangani() throws IOException {
        // Baca perintah dari socket
        String perintah = masukanReader.readLine();
        String[] parameter = perintah.split(" ");
        

        Date waktu = new Date();
        DateFormat df = new SimpleDateFormat ("HH:mm");
        String d1 = df.format(waktu);         
        
        
        // Jika tidak ada perintah keluar saja
        if (perintah == null)
            return;            
        // Ada perintah, hilangkan spasi depan & belakang serta ubah ke huruf besar semua
        perintah = perintah.trim().toUpperCase();

        if(parameter.length==4){

            simpan.isiData(parameter[0], d1, parameter[1], parameter[2],parameter[3]);
           // simpan.tampilData();

            keluaran = koneksi.getOutputStream();
            keluaranWriter = new BufferedWriter (new OutputStreamWriter(keluaran));
            keluaranWriter.write("Data disimpan");

            keluaranWriter.newLine();
            keluaranWriter.flush();
            koneksi.close();
        }

        else if(parameter.length==2){

            String a = "";
            a = a + simpan.showData(parameter[0], parameter[1],d1);

            System.out.println(a+"Disimpan, waktu "+d1);
           
            keluaranWriter.write(a);

            keluaranWriter.newLine();
            keluaranWriter.flush();
            koneksi.close();
        }
        
        else if(parameter.length==3){
            if(parameter[2].equals("WAKTU")){
                
                String tampil ;
                tampil = simpan.showSatu (parameter[0], parameter [2]);
    
                System.out.println(tampil+"print a, waktu "+d1);
                
                keluaranWriter.write(tampil);
    
                keluaranWriter.newLine();
                keluaranWriter.flush();
                koneksi.close();
                
            }else{
                String tampil ;
                tampil = simpan.showAll(parameter[0],parameter[2]);
    
                System.out.println(tampil+"print a, waktu "+d1);
                
                keluaranWriter.write(tampil);
    
                keluaranWriter.newLine();
                keluaranWriter.flush();
                koneksi.close();
            }
        }
    
                
        else{

            keluaranWriter.write(PERINTAH_TIDAK_DIKENAL, 0, PERINTAH_TIDAK_DIKENAL.length());
            keluaranWriter.newLine();
            keluaranWriter.flush();
            koneksi.close();
        }

        // Tampilkan perintahnya
        System.out.println("Dari: " + ipStr);
        System.out.println("perintah: " + perintah);
        System.out.println();
    }

    // Koneksi ke Client
    private Socket koneksi; 
    // IP address dari client
    private String ipStr; 

    // InputStream untuk baca perintah
    private InputStream masukan = null;
    // Reader untuk InputStream, pakai yang buffer
    private BufferedReader masukanReader = null;
    // OutputStream untuk tulis balasan
    private OutputStream keluaran = null;
    // Writer untuk OutputStream, pakai yang buffer
    private BufferedWriter keluaranWriter = null;

    private final static String PERINTAH_TIDAK_DIKENAL = "Perintah tidak dikenal!";
}