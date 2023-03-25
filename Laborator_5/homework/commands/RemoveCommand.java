package org.example.homework.commands;

import org.example.homework.catalog.Catalog;
import org.example.homework.documents.Document;

import java.util.List;

public class RemoveCommand extends CatalogCommand{

    private Document doc;
    public RemoveCommand(Catalog catalog, Document doc) {
        super(catalog);
        this.doc=doc;
    }

    @Override
    public void execute() {
        List<Document> documents = catalog.getDocuments();
        documents.remove(doc);
    }
}
