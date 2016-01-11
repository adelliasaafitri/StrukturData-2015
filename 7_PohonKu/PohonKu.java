
/**
 * Write a description of class pohon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PohonKu
{


    String waktu;
    String id, id1;
    String suhu, uv, nitrogen ;
    String tampil;
    //String perintah;
    //String[] parameter = perintah.split("_");
  
    public PohonKu(String id, String waktu, String suhu, String uv, String nitrogen)
    {
        this.id = id;
        this.waktu = waktu;
        this.suhu = suhu;
        this.uv = uv;
        this.nitrogen = nitrogen;
        
        //id = id1.split("_");
        
        
    }

    public String getSuhu()
    {
        tampil = getWaktu()+" "+id+" "+suhu;
        return tampil;
    }

    
    public String getUV()
    {
        tampil = getWaktu()+" "+id+" "+uv;
        return tampil;
    }

    public String getNitrogen()
    {
        tampil = getWaktu()+" "+id+" "+nitrogen;
        return tampil;
    }

    public String getId()
    {
        return id;
    }

    public String getWaktu()
    {
       
        return waktu;
    }
    
    public String tampilSemua (){
        String keadaan = getWaktu() + " "+id+" "+suhu+" "+uv+" "+nitrogen;
        return keadaan;
    }
    
   public String tampilSatu (){
        String keadaan = getWaktu() + " "+id+" "+suhu+" "+uv+" "+nitrogen;
        return keadaan;
    }
    
}