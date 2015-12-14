import java.net.Socket;
import java.net.InetAddress;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ProcessClientThread implements Runnable {
    public ProcessClientThread(Socket koneksiKiriman) {
        koneksi = koneksiKiriman;
    }

    public void run() {
        try{
            if (koneksi != null)
                prosesPermintaanClient();

        }   
        catch(IOException err) {
            System.out.println(err);
        }
        catch(InterruptedException err) {
            System.out.println(err);
        }
    }

    /* gak perlu
    private void prosesPermintaanClient(Socket koneksi) 
    throws InterruptedException, IOException {
    String ip = koneksi.getInetAddress().getHostAddress();
    System.out.println("Dari: " + ip);

    // Ambil dan tampilkan masukan
    InputStream masukan = koneksi.getInputStream();
    BufferedReader masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
    String baris = masukanReader.readLine();
    System.out.println(baris);

    // Baca pesan dari keyboard
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Pesan kembali: ");
    baris = keyboard.nextLine();

    // Kirim ke client
    OutputStream keluaran = koneksi.getOutputStream();
    BufferedWriter keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran)); 
    keluaranBuf.write(baris);
    keluaranBuf.newLine();
    keluaranBuf.flush();

    // Tunggu kirim balasan client
    masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
    baris = masukanReader.readLine();
    System.out.println(baris);
    }
     */

    private void prosesPermintaanClient()  throws InterruptedException, IOException
    {
        try {
            OutputStream keluaran = koneksi.getOutputStream();
            BufferedWriter keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran)); 
            // IP address asal koneksi                                                                   
            String ip = koneksi.getInetAddress().getHostAddress();
            // Tampilkan pesan
            System.out.println("Dari: " + ip);

            int i=0;
            //dipastikan berulang 3x kecuali udah benar maka langsung break
            while(i!=3){
                // Baca dari socket
                InputStream masukan = koneksi.getInputStream();
                BufferedReader masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
                String baris = masukanReader.readLine();
                System.out.println("Tebak : "+baris);

                if(baris.charAt(0)=='3'){
                    keluaranBuf.write("RIGHT");
                    keluaranBuf.newLine();
                    keluaranBuf.flush();
                    break;
                }else{
                    keluaranBuf.write("WRONG");
                    keluaranBuf.newLine();
                    keluaranBuf.flush();
                }
                i++;
            }

            
            //kalo udah 3 x coba tapi gagal terus masuk ke sini
            if(i==3)
            {
                keluaranBuf.write("Sorry ! YOU LOSE ! GAME OVER\nangka = "+angka);
                keluaranBuf.newLine();
                keluaranBuf.flush();
            }

            /*
            // Tunggu 2 detik
            System.out.println("Tunggu...");
            Thread.sleep(2000);
            System.out.println("Selesai tunggu...");
            */
            koneksi.close();
        }
        catch(IOException err) {
            System.out.println(err);
        }
    }

    private Socket koneksi; 
    private String angka ="3";
}