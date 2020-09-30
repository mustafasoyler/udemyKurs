package udemyKursPlayer;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {

            Ogrenci ogr1 =new Ogrenci("Ali","Alinin Tanıtım Yazısı","ali udemy");
            Egitmen egt1 =new Egitmen("Mustafa","Mustafa Java","MustafaSoyler");
            System.out.println(ogr1);
            System.out.println(egt1);

            Ders d1 =new Ders(1,"Giriş",5.4);
            Ders d2 =new Ders(2,"Java Nedir",10.4);
            Ders d3 =new Ders(3,"Primitive Veriler",15);
            Ders d4 =new Ders(4,"Diziler",30.1);
            Ders d5 =new Ders(5,"Metotlar",35.1);

            Ders d6 =new Ders(6,"Nesneler",20.1);
            Ders d7 =new Ders(7,"TryCatch",16.8);
            Ders d8 =new Ders(8,"Recycler",18);
            Ders d9 =new Ders(9,"Thread",34);
            Ders d10 =new Ders(10,"Lambda",23.5);


            Kurs javakurs =new Kurs("İleri seviye java kursu",egt1);
            javakurs.kursaDersEkle(d1);
            javakurs.kursaDersEkle(d2);
            javakurs.kursaDersEkle(d3);
            javakurs.kursaDersEkle(d4);
            javakurs.kursaDersEkle(d5);
            javakurs.kursaEgitmenSil(egt1);

            Kurs androidKursu =new Kurs("Android", egt1);
            androidKursu.kursaDersEkle(d6);
            androidKursu.kursaDersEkle(d7);
            androidKursu.kursaDersEkle(d8);
            androidKursu.kursaDersEkle(d9);
            androidKursu.kursaDersEkle(d10);



            ogr1.kursaKatil(javakurs);
            ogr1.kursaKatil(androidKursu);
            ogr1.izlenecekDersEkle(d6);
            ogr1.izlenecekDersEkle(d2);
            ogr1.izlenecekDersEkle(d7);
            ogr1.izlenecekDersEkle(d8);



            listeyiOynat(ogr1.getIzlenecekDersListesi());
    }
    public static void listeyiOynat(LinkedList<Ders> izlenecekDersler){

        Scanner tara =new Scanner(System.in);
        boolean cikis =false;
        boolean ileriDogruHareket=true;


        ListIterator<Ders> iterator =izlenecekDersler.listIterator();
        if (izlenecekDersler.size() == 0){
            System.out.println("Henüz ders eklenmemiş");
        }else{
            Ders ilkders = iterator.next();
            System.out.println("Su an izlenen ders " +ilkders.getDersBaslik()+ " Süre " +ilkders.getDakika());
        }
        menuGoster();
        while (!cikis){

            System.out.println("Seçiminiz: ");
            int kullaniciSecimi = tara.nextInt();

            switch (kullaniciSecimi){
                case 0:
                    System.out.println("Uygulamadan çıkılıyor");
                    cikis=true;
                case 1:
                    if (!ileriDogruHareket){
                        ileriDogruHareket=true;
                        if (iterator.hasNext()){
                            iterator.next();
                        }
                    }
                   if (iterator.hasNext()){
                       Ders ilkders = iterator.next();
                       System.out.println("=============================================================");
                       System.out.println(" Şu an oynatılan Ders No  " +ilkders.getDersNo()+ " başlık "+ilkders.getDersBaslik()+ " Süre " +ilkders.getDakika());
                       System.out.println("=============================================================");
                   }else {
                       System.out.println("Listenin sonuna geldiniz");
                   }
                   break;
                case 2:
                    if (ileriDogruHareket){
                        ileriDogruHareket=false;
                        if (iterator.hasPrevious()){
                            iterator.previous();

                        }
                    }
                    if (iterator.hasPrevious()){
                        Ders ilkders = iterator.previous();
                        System.out.println("=============================================================");
                        System.out.println(" Şu an oynatılan Ders No  " +ilkders.getDersNo()+ " başlık "+ilkders.getDersBaslik()+ " Süre " +ilkders.getDakika());
                        System.out.println("=============================================================");
                    }else {
                        System.out.println("Listenin başına geldiniz");
                    }

                case 3:
                    izlenecekDersleriListele(izlenecekDersler);
                    break;
                case 9:
                    menuGoster();
                    break;
            }
        }
    }

    private static void izlenecekDersleriListele(LinkedList<Ders> izlenecekDersler) {
        ListIterator<Ders> iterator =izlenecekDersler.listIterator();
        if (izlenecekDersler.size() == 0){
            System.out.println("Henüz ders eklenmemiş");
            return;
        }else{
            while (iterator.hasNext()){
                Ders ilkders = iterator.next();
                System.out.println("Ders No  " +ilkders.getDersNo()+ " başlık "+ilkders.getDersBaslik()+ " Süre " +ilkders.getDakika());
            }

        }
    }

    private static void menuGoster() {
        System.out.println( "*************MENU************");
        System.out.println("0 - Çıkış");
        System.out.println("1 -Bir sonraki derse git");
        System.out.println("2 - Bir önceki derse git");
        System.out.println("3 - Tüm listeyi göster");
        System.out.println("9 - Menü");

    }
}
