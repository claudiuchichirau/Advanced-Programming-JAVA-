package org.example.homework.app;


import org.example.homework.commands.*;
import org.example.homework.documents.Article;
import org.example.homework.documents.Book;
import org.example.homework.catalog.Catalog;
import org.example.homework.exceptions.InvalidCommandParameterException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static <CommandException> void main(String[] args) throws IOException, InvalidCommandParameterException {

        // creating a Map for the book's tags
        Map<String, Object> MorometiiTags = new HashMap<>();
        MorometiiTags.put("Title", "Morometii");
        MorometiiTags.put("Author", "Marin Preda");
        MorometiiTags.put("Year", 1955);
        MorometiiTags.put("PublishingDate", "13.04.1955");

        // create Book 1
        Book morometiiBook = new Book(1, "Morometii","https://bgrmihailsturdza.files.wordpress.com/2014/02/marin-preda-morometii-volumul.pdf", MorometiiTags, "1685620523", "Editura Albatros");

        // create Book 2
        Map<String, Object> IonTags = new HashMap<>();
        IonTags = null;
        Book ionBook = new Book(2, "Ion", "https://bgrmihailsturdza.files.wordpress.com/2014/02/rebreanu-liviu-ion-i-cartea.pdf", IonTags, "9789732103966", "Editura Cartex");

        // create Book 3
        Map<String, Object> EnigmaOtilieiTags = new HashMap<>();
        EnigmaOtilieiTags.put("Title", "Enigma Otiliei");
        EnigmaOtilieiTags.put("Author", "George Calinescu");
        EnigmaOtilieiTags.put("Year", 1938);

        Book enigmaOtilieiBook = new Book(3, "Enigma Otiliei", "https://liceulfranciscan.ro/biblioteque/materiale_digitale/George_Calinescu-Enigma_Otiliei.pdf",EnigmaOtilieiTags, "9789734600753", "Editura Minerva");

        // create Book 4
        Map<String, Object> UltimaNoapteDeDragosteTags = new HashMap<>();
        UltimaNoapteDeDragosteTags.put("Title", "Ultima noapte de dragoste, intaia noapte de razboi");
        UltimaNoapteDeDragosteTags.put("Author", "Camil Petrescu");
        UltimaNoapteDeDragosteTags.put("Year", 1930);
        UltimaNoapteDeDragosteTags.put("PublishingDate", "31.12.1930");

        Book ultimaNoapteBook = new Book(4, "Ultima noapte de dragoste, intaia noapte de razboi", "https://cantemird.files.wordpress.com/2008/03/ultima-noapte-de-dragoste-intiia-noapte-de-razboi-camil-petrescu.pdf",UltimaNoapteDeDragosteTags, "9789734600807", "Editura Minerva");

        // ----------------------------------------------------------------------------------------------

        // creation of Article objects

        // creating a Map for the article's tags
        Map<String, Object> revolutiaRomanaTags = new HashMap<>();
        revolutiaRomanaTags.put("Title", "Revolutia Romana din 1989");
        revolutiaRomanaTags.put("Author", "Vladimir Tismaneanu");
        revolutiaRomanaTags.put("Year", 2019);
        // revolutiaRomanaTags.put("Magazine", "Observator Cultural");

        // create Article 1
        Article revolutiaRomana = new Article(6, "Revolutia Romana din 1989", "https://www.contributors.ro/revolutia-nici-n-a-existat-a-fost-o-lovilutie-fragment-din-tragatori-%C8%99i-mistificatori-contrarevolu%C8%9Bia-securita%C8%9Bii-in-decembrie-1989/",revolutiaRomanaTags, 5);

        // create Article 2
        Map<String, Object> romaniaPostcomunistaTags = new HashMap<>();
        romaniaPostcomunistaTags.put("Author", "Vladimir Tismaneanu");
        romaniaPostcomunistaTags.put("Year", 2007);
        Article romaniaPostcomunista = new Article(7, "Romania postcomunista: memoria ca argument politic", "https://moldova.europalibera.org/a/28189371.html",romaniaPostcomunistaTags, 10);

        // create Article 3
        Map<String, Object> mioritaTags = new HashMap<>();
        mioritaTags.put("Title", "Miorita - povestea ciobanului");
        mioritaTags.put("Author", "Mircea Eliade");
        mioritaTags.put("Year", 1960);
        Article miorita = new Article(8, "Miorita - povestea ciobanului", "https://www.referatele.com/referate/romana/online1/Balada-Miorita-Portretul-ciobanului-moldovean--motivele-din-balada-Miorita-referatele-com.php", mioritaTags, 3);

        Map<String, Object> schimbariClimaticeTags = new HashMap<>();
        schimbariClimaticeTags.put("Title", "Efectele schimbarilor climatice");
        schimbariClimaticeTags.put("Author", "Greta Thunberg");
        schimbariClimaticeTags.put("Year", 2022);
        Article schimbariClimatice = new Article(9, "Efectele schimbarilor climatice", "https://www.europarl.europa.eu/news/ro/headlines/society/20200227STO73520/greta-thunberg-cere-eurodeputatilor-sa-arate-leadership-in-domeniul-climatic", schimbariClimaticeTags, 8);

        // create a new catalog
        Catalog catalog1 = new Catalog();

        // add the documents in the catalog1
        AddCommand addMorometiiBook = new AddCommand(catalog1, morometiiBook);
        addMorometiiBook.execute();

        AddCommand addIonBook = new AddCommand(catalog1, ionBook);
        addIonBook.execute();

        AddCommand addEnigmaOtilieiBook = new AddCommand(catalog1, enigmaOtilieiBook);
        addEnigmaOtilieiBook.execute();

        AddCommand addUltimaNoapteBook = new AddCommand(catalog1, ultimaNoapteBook);
        addUltimaNoapteBook.execute();

        AddCommand addRevolutiaRomanaArticle = new AddCommand(catalog1, revolutiaRomana);
        addRevolutiaRomanaArticle.execute();

        AddCommand addRomaniaPostcomunistaArticle = new AddCommand(catalog1, romaniaPostcomunista);
        addRomaniaPostcomunistaArticle.execute();

        AddCommand addMioritaArticle = new AddCommand(catalog1, miorita);
        addMioritaArticle.execute();

        AddCommand addSchimbariClimaticeArticle = new AddCommand(catalog1, schimbariClimatice);
        addSchimbariClimaticeArticle.execute();


        // display the contents of catalog 1
        ListCommand listCatalog1 = new ListCommand(catalog1);
        listCatalog1.execute();

        // save catalog 1 in a file called "catalog1.json"
        SaveCommand saveCatalog1 = new SaveCommand(catalog1,"Laborator_5/catalog1.json");
        saveCatalog1.execute();

        // open a book from the catalog in the browser
//        ViewCommand viewIonBook = new ViewCommand(catalog1, enigmaOtilieiBook);
//        viewIonBook.execute();

        // generate html report
//        ReportCommand reportCatalog = new ReportCommand(catalog1);
//        reportCatalog.execute();

        // create a new catalog
        Catalog catalog2 = new Catalog();

        // load the data of the second catalog from an external json file
        LoadCommand loadCatalog2 = new LoadCommand(catalog2, "Laborator_5/catalogLoad.json");
        loadCatalog2.execute();

        System.out.println("\n\tNew load catalog");
        // display the contents of catalog 2
        ListCommand listCatalog2 = new ListCommand(catalog2);
        listCatalog2.execute();
    }

}