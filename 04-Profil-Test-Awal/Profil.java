public class Profil{
    private String nama = new String ("Adelia Safitri");
    private String nim = new String ("1408107010023");
        
    public Profil (){
    
    }
    
    public Profil (String nama, String nim){
        this.nama = nama;
        this.nim = nim;  
    }
    
    public String getNama(){
        return nama;
    }
    
    public String getNim(){
        return nim;
    }

}


