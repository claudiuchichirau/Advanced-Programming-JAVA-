package org.example.homework.commands;

import org.example.homework.catalog.Catalog;
import org.example.homework.documents.Article;
import org.example.homework.documents.Book;
import org.example.homework.documents.Document;

import java.util.List;

public class ListCommand extends CatalogCommand {
    public ListCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void execute() {
        List<Document> documents = catalog.getDocuments();
        if (documents.isEmpty()) {
            System.out.println("No documents found in the catalog.");
        } else {
            System.out.println("List of documents:");
            for (Document document : documents) {
                if(document instanceof Book)
                    System.out.println("- (BOOK): " + document.getName());
                else if (document instanceof Article) {
                    System.out.println("- (ARTICLE): " + document.getName());
                }
            }
        }
    }
}
