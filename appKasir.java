package Latihan_BP2;
import java.util.Scanner;
public class appKasir {
    public static void main(String[] args) {
        cProduk p = new cProduk();
        cProduk p2 = new cProduk("Sepatu",150000,10);
        cPembeli pb = new cPembeli("Budi","Surabaya");
        cProduk produk[] = new cProduk[3];
        cTransaksi tr = new cTransaksi();
        Scanner sc = new Scanner(System.in);
        //master produknya toko
        produk[0]=new cProduk("Sepatu",150000,5);
        produk[1]=new cProduk("Sandal",100000, 5);
        produk[2]=new cProduk("Topi", 70000, 5 );
        int pilih=0;
        do{
            System.out.println("\nMENU APP");
            System.out.println("1. Produk");
            System.out.println("2. Pembeli");
            System.out.println("3. Transaksi");
            System.out.println("4. Exit");
            System.out.print("Pilih = ");
            pilih=sc.nextInt();
            switch(pilih){
                case 1:
                    System.out.println("[Produk]");
                    System.out.println("  1.Tambah");
                    System.out.println("  2.Ubah");
                    System.out.println("  3.Hapus");
                    System.out.println("  4.Detail");
                    System.out.print("  Pilih = ");
                    int pilih2=sc.nextInt();
                    switch(pilih2){
                        case 1:
                            sc = new Scanner(System.in);
                            System.out.print("  Nama = ");
                            String nm=sc.nextLine();
                            System.out.print("  Harga = ");
                            int hg=sc.nextInt();
                            System.out.print("  Stok = ");
                            int st=sc.nextInt();
                            p2 = new cProduk(nm,hg,st);
                            break;
                        case 2:
                            System.out.print("  Stok Baru = ");
                            st=sc.nextInt();
                            System.out.println("  Yakin Ubah?");
                            System.out.println("  1. Ya");
                            System.out.println("  2. Batal");
                            System.out.print("  Jawab = ");
                            int jwb=sc.nextInt();
                            if(jwb==1){
                                p2.setStok(st);
                                System.out.println("  Ubah stok berhasil..");
                            }else{
                                System.out.println("  Ubah stok batal..");
                            }
                            break;
                        case 3:
                            System.out.print("  Nama = ");
                            nm=sc.next();
                            if(nm.equalsIgnoreCase(p2.getNama())){
                                System.out.println("  Yakin Hapus?");
                                System.out.println("  1. Ya");
                                System.out.println("  2. Tidak");
                                System.out.print("  Jawab = ");
                                jwb=sc.nextInt();
                                if(jwb==1){
                                    p2=null;
                                    System.out.println("  Hapus sukses..");
                                }else{
                                    System.out.println("  Batal hapus!");
                                }
                            }else{
                                System.out.println("  Produk tidak ada..");
                            }
                            break;
                        case 4:
                            if(p2!=null){
                                System.out.println(p2.ToString());
                            }else{
                                System.out.println("  Objek kosong");
                            }
                    }
                    break;
                case 2:
                    System.out.println("<<PEMBELI>>");
                    break;
                case 3:
                    System.out.println("<<TRANSAKSI>>");
                    System.out.println("  1.Tambah");
                    System.out.println("  2.Ubah");
                    System.out.println("  3.Hapus");
                    System.out.println("  4.Cetak");
                    System.out.print("  Pilih = ");
                    pilih2=sc.nextInt();
                    switch(pilih2){
                        case 1:
                            System.out.print("  Nama  = ");
                            String n = sc.next();
                            pb = new cPembeli(n);
                            tr.setPembeli(pb);
                            String pr;
                            int j,pilih3=0;
                            do{
                                System.out.println("Produk");
                                System.out.println("1.Sepatu");
                                System.out.println("2.Sandal");
                                System.out.println("3.Tas");
                                System.out.println("4.Selesai");
                                System.out.print("Pilih = ");
                                pilih3=sc.nextInt();
                                switch(pilih3){
                                    case 1:
                                        System.out.print("Jumlah = ");
                                        j=sc.nextInt();
                                        tr.tambahProduk(produk[0],j);
                                        System.out.println("Tambah sukses..");
                                        break;
                                    case 2:
                                        tr.tambahProduk(produk[1]);
                                        System.out.println("Tambah sukses..");
                                        break;
                                    case 3:
                                        tr.tambahProduk(produk[2]);
                                        System.out.println("Tambah sukses..");
                                        break;
                                    case 4:
                                        System.out.println("Kembali...");
                                }
                            }while(pilih3!=4);
                            //System.out.print("  Produk = ");
                            //String pr = sc.next();
                            //System.out.print("  Jumlah = ");
                            //int j = sc.nextInt();
                            //if(pr.equalsIgnoreCase(p2.getNama())){
                                //int t = j*p2.getHarga();
                                //tr.setProduk(p2);
                                //tr.setJumlah(j);
                                //tr.setTotal(t);
                                //System.out.println("Transaksi sukses..");
                            //}
                            //else{
                                //System.out.println("Produk tidak ada!");
                            //}
                            //break;
                        case 2:
                            System.out.print("  Nama = ");
                            pr=sc.next();
                            for (int i = 0; i < tr.getIdxprd(); i++) {
                                if(pr.equalsIgnoreCase(tr.getProduk()[i].getNama())){
                                    System.out.print("  Jumlah Baru = ");
                                    j=sc.nextInt();  
                                    System.out.print("  Yakin Ubah?");
                                    System.out.println("1.Ya\n2.Batal");
                                    System.out.println("  Jawab = ");
                                    int jwb=sc.nextInt();
                                    if(jwb==1){
                                        tr.setJumlah(j);
                                        tr.setTotal(j*tr.getProduk()[i].getHarga());
                                        System.out.println("Ubah sekses..");
                                    }
                                    else{
                                        System.out.println("Ubah batal!");
                                    }
                                    break;
                                }
                                else{
                                    System.out.println("Produk tidak ada!");
                                }
                            }
                            break;
                        case 3:
                            System.out.print("Nama produk = ");
                            pr=sc.next();
                            tr.hapusproduk(pr);
                            break;
                        case 4:
                            if(tr!=null){
                                System.out.println("Nama : "+tr.getPembeli().getNama());
                                tr.lihatTransaksi();
                                //System.out.println("Produk : "+tr.getProduk().getNama());
                                //System.out.println("Jumlah : "+tr.getJumlah());
                                //System.out.println("Harga : "+tr.getProduk().getHarga());
                                //System.out.println("Total : "+tr.getTotal());
                            }
                    }
                    break;
                case 4:
                    System.out.println("Terima kasih..");
            }
        }while(pilih!=4);
    } 
}