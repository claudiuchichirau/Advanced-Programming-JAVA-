package org.example.homework.commands;

import org.example.homework.catalog.Catalog;
import org.example.homework.documents.Article;
import org.example.homework.documents.Book;
import org.example.homework.documents.Document;

import java.util.List;

public class AddCommand extends CatalogCommand{
    private Document doc;
    public AddCommand(Catalog catalog, Document doc) {
        super(catalog);
        this.doc = doc;
    }

    @Override
    public void execute() {
        List<Document> documents = catalog.getDocuments();
        if(doc instanceof Book) {
            Book book = (Book) doc;
            documents.add(book);
        } else if (doc instanceof Article) {
            Article article = (Article) doc;
            documents.add(article);
        }
    }
}
