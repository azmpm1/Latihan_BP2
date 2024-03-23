package Latihan_BP2;
import java.util.Scanner;
public class cTransaksi {
    Scanner sc = new Scanner(System.in);
    private String kode;
    private String tgl;
    private cPembeli pbl;
    private cProduk prd[];
    private int idxprd; //indeks array
    private int maksprd; //maksimal kapasitas array
    private int total;
    private int jumlah;
    private int jumprd[];
    private int totprd[];
    cTransaksi(){
        prd=new cProduk[5];
        jumprd=new int [5];
        totprd=new int [5];
        idxprd=0; maksprd=5;
        System.out.println("Default constructor transaksi..");
    }
    public void setPembeli(String n, String a){
        pbl = new cPembeli(n,a);
    }
    public void setPembeli(cPembeli pb){
        pbl = new cPembeli();
        pbl = pb;
    }
    public void setProduk(cProduk p){
        prd[idxprd] = new cProduk();
        prd[idxprd] = p;
    }
    public void setJumlah(int j){ jumlah=j; }
    public void setTotal(int t){ total=t; }
    public cPembeli getPembeli(){ return pbl; }
    public cProduk[] getProduk(){ return prd; }
    public int getJumlah(){ return jumlah; }
    public int getTotal(){ return total; }
    public int getIdxprd(){ return idxprd; }
    public void tambahProduk(cProduk p, int j){
        prd[idxprd]=p;
        jumprd[idxprd]=j;
        totprd[idxprd]=j*p.getHarga();
        idxprd++;
    }
    public void tambahProduk(cProduk p){
        if(idxprd<maksprd){
            prd[idxprd]=p;
            System.out.println("Tambah sukses..");
            idxprd++;
        }else{
            System.out.println("Keranjang penuh!");
        }
    }
    public void lihatTransaksi(){
        System.out.println("Daftar Belanja");
        for (int i = 0; i < idxprd; i++) {
            System.out.println((i+i)+"."+prd[i].getNama()+" ["+jumprd[i]+"]");
        }
        System.out.println("");
    }
    public void hapusproduk(String np){
        boolean ketemu=false;
        for (int i = 0; i < idxprd; i++) {
            if(np.equalsIgnoreCase(prd[i].getNama()+" ["+jumprd[i]+"]")){
                ketemu=true;
            }
            System.out.println("Yakin Hapus?");
            System.out.println("1.Ya\n2.Batal");
            System.out.print("Jawab = ");
            int jwb=sc.nextInt();
            if(jwb==1){
                prd[i]=null;
                for (int j = 0; j < idxprd; j++) {
                    if(j==idxprd-1){
                        prd[j]=null;
                    }
                    else prd[j]=prd[j+1];
                }
                System.out.println("Hapus sukses..");
            }else System.out.println("Batal Hapus!");
            break;
        }
    }
}
