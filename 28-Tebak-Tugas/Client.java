import java.net.Socket;
import java.net.UnknownHostException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedWriter;

import java.util.Scanner;

public class Client {
    public void chat() 
    throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 33333);

        try {
            Reader masukan= null; 
            BufferedReader masukanBuff = null;
            String baris=null;

            int i=0;
            while(i!=3){
                // Ketik
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Silakan Tebak Angka (3 kali Kesempatan)");
                System.out.print("Tebak : ");
                String ketikanSatuBaris = keyboard.nextLine();

                // Tulis ke socket
                Writer keluaranWriter = new OutputStreamWriter(socket.getOutputStream()); 
                BufferedWriter keluaranBuff = new BufferedWriter(keluaranWriter);
                keluaranBuff.write(ketikanSatuBaris);
                keluaranBuff.write("\n");
                keluaranBuff.flush();

                // Baca dari Server
                System.out.print("Dari server: ");
                masukan = new InputStreamReader(socket.getInputStream()); 
                masukanBuff = new BufferedReader(masukan);
                baris = masukanBuff.readLine();
                System.out.println(baris);     

                //kalo server udah balas benar, maka langsung break
                if(baris.equalsIgnoreCase("Benar")){
                    break;
                }
                i++;
            }

            //kalo udah 3x coba gagal terus masuk ke if ini
            if(i==3)
            {
                baris = masukanBuff.readLine();
                System.out.println(baris);     
            }
        }
        catch(IOException salah) {
            System.out.println(salah);
        }
        finally {
            if (socket != null)
                socket.close();
        }
    }
}
