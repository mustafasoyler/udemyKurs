package udemyKursPlayer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ogrenci extends Kisi{

    private ArrayList<Kurs> katildigiKurslar ;
    private LinkedList<Ders> izlenecekDersListesi ;

    public Ogrenci(String isim, String tanitimYazisi, String kullaniciAdi) {
        super(isim, tanitimYazisi, kullaniciAdi);
        katildigiKurslar =new ArrayList<>();
        izlenecekDersListesi =new LinkedList<>();
    }


    @Override
    public String toString() {
        return super.toString() +"Ogrenci{" +
                "katildigiKurslar=" + katildigiKurslar +
                '}';
    }

    public void kursaKatil(Kurs javakurs) {
        if (javakurs.kursYayindaKontrol()){
            javakurs.getKursOgrencileri().add(this);
            katildigiKurslar.add(javakurs);
            System.out.println(this.getIsim()+ " kullanıcısı " +javakurs.getDersAdi()+ " kursuna katıldı");

        }else{
            System.out.println(javakurs.getDersAdi()+ " isimli kurs yayında değil , katılamazsınız");
        }
    }
    public void izlenecekDersEkle(Ders izlenecekDers){
        boolean dersBulundu =false;
        if (katildigiKurslar.size() > 0){

            for (Kurs gecici : katildigiKurslar){
                if (gecici.getKursatkiDersler().contains(izlenecekDers)){
                    System.out.println("izlenecek listesine " +gecici.getDersAdi() + " kursunda bulunan " +izlenecekDers.getDersBaslik()+ " dersi eklendi");
                    izlenecekDersListesi.add(izlenecekDers);
                    dersBulundu =true;
                    break;

                }

            }
            if (!dersBulundu){
                System.out.println("Girilen ders kurslarda bulunamadı ");
            }
        }

    }

    public LinkedList<Ders> getIzlenecekDersListesi() {
        return izlenecekDersListesi;
    }
}
