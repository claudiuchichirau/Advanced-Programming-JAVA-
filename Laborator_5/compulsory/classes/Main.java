package org.example.compulsory.classes;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // crearea unui Map pentru tagurile cartii
        Map<String, Object> MorometiiTags = new HashMap<>();
        MorometiiTags.put("Title", "Morometii");
        MorometiiTags.put("Author", "Marin Preda");
        MorometiiTags.put("Year", 1955);

        // Book 1
        Calendar calendar = Calendar.getInstance();
        calendar.set(1955, Calendar.APRIL, 13);
        MorometiiTags.put("PublishingDate", Calendar.getInstance());
        Book morometiiBook = new Book(1, "Morometii", MorometiiTags, "1685620523", "Editura Albatros");

        // Cartea 2
        Map<String, Object> IonTags = new HashMap<>();
        IonTags = null;
        Book ionBook = new Book(2, "Ion", IonTags, "9789732103966", "Editura Cartex");

        // Cartea 3
        Map<String, Object> EnigmaOtilieiTags = new HashMap<>();
        EnigmaOtilieiTags.put("Title", "Enigma Otiliei");
        EnigmaOtilieiTags.put("Author", "George Calinescu");
        EnigmaOtilieiTags.put("Year", 1938);

        Book enigmaOtilieiBook = new Book(3, "Enigma Otiliei", EnigmaOtilieiTags, "9789734600753", "Editura Minerva");

        // Cartea 4
        Map<String, Object> UltimaNoapteDeDragosteTags = new HashMap<>();
        UltimaNoapteDeDragosteTags.put("Title", "Ultima noapte de dragoste, intaia noapte de razboi");
        UltimaNoapteDeDragosteTags.put("Author", "Camil Petrescu");
        UltimaNoapteDeDragosteTags.put("Year", 1930);

        Calendar UltimaNoapteDeDragosteCalendar = Calendar.getInstance();
        UltimaNoapteDeDragosteCalendar.set(1930, Calendar.DECEMBER, 31);
        UltimaNoapteDeDragosteTags.put("PublishingDate", UltimaNoapteDeDragosteCalendar);
        Book ultimaNoapteBook = new Book(4, "Ultima noapte de dragoste, intaia noapte de razboi", UltimaNoapteDeDragosteTags, "9789734600807", "Editura Minerva");

        // Cartea 5
        Map<String, Object> BaltagulTags = new HashMap<>();
        BaltagulTags.put("Title", "Baltagul");
        BaltagulTags.put("Author", "Mihail Sadoveanu");
        BaltagulTags.put("Year", 1930);

        Book baltagulBook = new Book(5, "Baltagul", BaltagulTags, "9789734600821", "Editura Minerva");

        // ----------------------------------------------------------------------------------------------

        // Exemplu de obiect Article

        // crearea unui Map pentru tagurile articolului
        Map<String, Object> revolutiaRomanaTags = new HashMap<>();
        revolutiaRomanaTags.put("Title", "Revolutia Romana din 1989");
        revolutiaRomanaTags.put("Author", "Vladimir Tismaneanu");
        revolutiaRomanaTags.put("Year", 2019);
        // revolutiaRomanaTags.put("Magazine", "Observator Cultural");

        // crearea Articolului 1
        Article revolutiaRomana = new Article(6, "Revolutia Romana din 1989", revolutiaRomanaTags, 5);

        // crearea Articolului 2
        Map<String, Object> romaniaPostcomunistaTags = new HashMap<>();
        romaniaPostcomunistaTags.put("Author", "Vladimir Tismaneanu");
        romaniaPostcomunistaTags.put("Year", 2007);
        Article romaniaPostcomunista = new Article(7, "Romania postcomunista: memoria ca argument politic", romaniaPostcomunistaTags, 10);

        // crearea Articolului 3
        Map<String, Object> mioritaTags = new HashMap<>();
        mioritaTags.put("Title", "Miorita - povestea ciobanului");
        mioritaTags.put("Author", "Mircea Eliade");
        mioritaTags.put("Year", 1960);
        Article miorita = new Article(8, "Miorita - povestea ciobanului", mioritaTags, 3);

        Map<String, Object> schimbariClimaticeTags = new HashMap<>();
        schimbariClimaticeTags.put("Title", "Efectele schimbarilor climatice");
        schimbariClimaticeTags.put("Author", "Greta Thunberg");
        schimbariClimaticeTags.put("Year", 2022);
        Article schimbariClimatice = new Article(9, "Efectele schimbarilor climatice", schimbariClimaticeTags, 8);


        Catalog catalog = new Catalog();

        catalog.addDocument(morometiiBook);
        catalog.addDocument(ionBook);
        catalog.addDocument(enigmaOtilieiBook);
        catalog.addDocument(ultimaNoapteBook);
        catalog.addDocument(baltagulBook);
        catalog.addDocument(revolutiaRomana);
        catalog.addDocument(romaniaPostcomunista);
        catalog.addDocument(miorita);
        catalog.addDocument(schimbariClimatice);

        // afisam continutul catalogului
        System.out.println("Catalogul cu articolul 'MIORITA - POVESTEA CIOBANULUI':\n" + catalog);

        // stergem un document
         catalog.removeDocument(miorita);

        // afisam continutul catalogului modificat
        System.out.println("Catalogul fara articolul 'MIORITA - POVESTEA CIOBANULUI':\n" + catalog);

         // salvam catalogul intr-un fisier
         catalog.saveCatalog("catalog.json");

//        Catalog catalog1 = new Catalog();
//        // incarcam catalogul din fisier
//        catalog1.loadCatalog("catalog.json");
//
//        System.out.println(catalog1);
    }

}