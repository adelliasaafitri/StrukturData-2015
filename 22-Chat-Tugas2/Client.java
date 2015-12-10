/**
 * Write a description of class KirimInfo here.
 * 
 * @author ADELIA SAFITRI
 * @NIM 1408107010023
 */
import java.net.Socket;
import java.net.UnknownHostException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.io.Reader;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.util.Scanner;

public class Client {    
    public void chat()
                throws UnknownHostException, IOException {
        Socket socket= new Socket("localhost", 33333);//dibawah kominfo untuk registrasi utama diIndonesia protocol whois di port 43

        try{
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Pesan: ");
            String ketikanSatuBaris = keyboard.nextLine();
                    
            // Tulis ke socket
            Writer keluaranWriter = new OutputStreamWriter(socket.getOutputStream()); 
            BufferedWriter keluaranBuff = new BufferedWriter(keluaranWriter);
            keluaranBuff.write(ketikanSatuBaris);
            keluaranBuff.write("\n");
            keluaranBuff.flush();
                
            // Baca dari Server
            System.out.print("Server: ");
            Reader masukan = new InputStreamReader(socket.getInputStream()); 
            BufferedReader masukanBuff = new BufferedReader(masukan);
            String baris = masukanBuff.readLine();
            System.out.println(baris);    
            
            baris = baris.toUpperCase();
            
            keluaranBuff.write(baris);
            keluaranBuff.flush();
            
            System.out.println("Pesan terkirim");
            System.out.println();
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