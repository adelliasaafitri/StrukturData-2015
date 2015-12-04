import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Utama {
    public static void main(String[] args) {
        try {
            KirimInfo tanya = new KirimInfo();
            Scanner input = new Scanner(System.in);
            System.out.print("Saya : ");
            String chat = new String();
            chat = input.next();
             
            
            tanya.whois(chat);
        }
        catch (UnknownHostException ex) {
            System.err.println(ex);
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
