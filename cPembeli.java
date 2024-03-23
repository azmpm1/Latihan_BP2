package Latihan_BP2;
public class cPembeli {
    private String nama;
    private String alamat;
    cPembeli(){
        System.out.println("Default constructor pembeli..");
    }
    cPembeli(String n){
        nama=n;
        System.out.println(nama+" dibuat..");
    }
    cPembeli(String n, String a){
        nama=n; alamat=a;
        System.out.println("Object "+nama+" dibuat..");
    }
    public String getNama(){ return nama; }
    public String getAlamat(){ return alamat; }
}
