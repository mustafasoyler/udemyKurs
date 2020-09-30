package udemyKursPlayer;

import java.util.ArrayList;

public class Kurs {
    private String dersAdi;
    private ArrayList<Ders> kursatkiDersler;
    private ArrayList<Egitmen> kursEgitmenleri;
    private ArrayList<Ogrenci> kursOgrencileri;
    private boolean yayinda;

    public Kurs(String dersAdi, Egitmen basEgitmen) {
        this.dersAdi = dersAdi;
        this.kursatkiDersler = new ArrayList<>();
        this.kursEgitmenleri = new ArrayList<>();
        this.kursOgrencileri = new ArrayList<>();
        kursEgitmenleri.add(0,basEgitmen);
        this.yayinda = false;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public ArrayList<Ogrenci> getKursOgrencileri() {
        return kursOgrencileri;
    }

    public void kursaEgitmenEkle(Egitmen yeniEgitmen){
        if (!kursEgitmenleri.contains(yeniEgitmen)){
            kursEgitmenleri.add(yeniEgitmen);
            System.out.println(yeniEgitmen.getIsim()+ " kursa yeni eğitmen olarak eklendi");
        }else{
            System.out.println(yeniEgitmen.getIsim()+ "zaten kursta tanımlı bir eğitmendir");
        }

    }
    public void kursaEgitmenSil(Egitmen silinecekEgitmen){
        if (silinecekEgitmen.getIsim().equals(kursEgitmenleri.get(0).getIsim())){
            System.out.println(silinecekEgitmen.getIsim()+ " kursun baş eğitmeni o yüzden silinemez");
        }else {
            kursEgitmenleri.remove(silinecekEgitmen);
            System.out.println(silinecekEgitmen.getIsim()+ " kursun eğitiminden çıkarıldı");
        }


    }
    public void kursaDersEkle(Ders eklenecekDers){
        kursatkiDersler.add(eklenecekDers);
    }
    public int kurstakiDersSayisi(){
        return kursatkiDersler.size();
    }
    private int kurslarınDerslerinToplamDakikSuresi(){
        double toplamSure =0;
        for (Ders ders : kursatkiDersler){
            toplamSure = toplamSure + ders.getDakika();
        }
        return (int)toplamSure;
    }
    public boolean kursYayindaKontrol(){
        if (kursatkiDersler.size() >= 5 && kurslarınDerslerinToplamDakikSuresi() >= 60){
            yayinda=true;
            return true;
        }else return false;
    }

    public void kursaOgrenciEkle(Ogrenci kursOgrenci){
        if (kursYayindaKontrol()){
            kursOgrencileri.add(kursOgrenci);
        }

    }

    public ArrayList<Ders> getKursatkiDersler() {
        return kursatkiDersler;
    }
}
