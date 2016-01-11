import java.util.ArrayList;
import java.util.Scanner; 

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.*;
import java.text.*;

public class Penyimpanan{

    Date waktu = new Date();

    DateFormat df = new SimpleDateFormat ("HH:mm");

    String d1 = df.format(waktu);

    ArrayList <PohonKu> simpan;

    public Penyimpanan()
    {
        //instansiasi
        simpan = new ArrayList<PohonKu>();
    }

    public void isiData(String id, String waktu, String suhu, String uv, String nitrogen)
    {
        simpan.add(new PohonKu(id, waktu, suhu, uv, nitrogen));
    }

    public void tampilData()
    {

        for(PohonKu pohon:simpan){
            System.out.println (pohon.getSuhu());
            System.out.println ("data disimpan");

        }
    }

    public String showData(String ID, String data, String waktu)
    {

        String hasil = "" ;
        for(PohonKu pohon:simpan){
            if (ID.equals(pohon.getId())){
                if(data.equals("SUHU") && waktu.equals(pohon.getWaktu())){

                    hasil = hasil + pohon.getSuhu() + "\n";
                    //System.out.println("Suhu ada");

                }
                //System.out.println("Id ada, Suhu tidak ada");

                if(data.equals("UV")){

                    hasil = hasil + pohon.getUV() + "\n";

                }

                if(data.equals("NITROGEN")){

                    hasil = hasil + pohon.getNitrogen() + "\n";

                }
            }

        }
        return hasil;
    }

    public String showAll(String ID, String waktu)
    {

        String hasil = "" ;
        for(PohonKu pohon:simpan){

            if(ID.equals(pohon.getId()) && waktu.equals(pohon.getWaktu())){

                hasil = hasil + pohon.tampilSemua()+"\n";

            }

        }
        return hasil;
    }

    public String showSatu(String ID, String waktu)
    {

        String hasil = "" ;
        int i;
        /*for(PohonKu pohon:simpan){

            if(ID.equals(pohon.getId())){
                hasil = hasil + pohon.tampilSatu()+"\n"; 

            }    

        }*/

        ListIterator<PohonKu> listIter = simpan.listIterator(simpan.size()-1);
        while (listIter.hasPrevious()) {
            PohonKu prev = listIter.previous();
            if(ID.equals(prev.getId())){
                hasil = hasil + prev.tampilSatu()+"\n";
                break;
            }
        }
        return hasil;
    }

}