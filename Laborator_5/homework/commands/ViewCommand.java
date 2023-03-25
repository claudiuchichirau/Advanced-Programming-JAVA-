package org.example.homework.commands;

import org.example.homework.catalog.Catalog;

import org.example.homework.documents.Document;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ViewCommand extends CatalogCommand{
    private Document doc;
    public ViewCommand(Catalog catalog, Document doc) {
        super(catalog);
        this.doc = doc;
    }

    @Override
    public void execute() {
        if(this.doc == null)
            throw new IllegalArgumentException("Document not found in the catalog" + doc.getName());
        else {
            try{
                Desktop.getDesktop().browse(new URI(doc.getURL()));
            } catch (IOException | URISyntaxException e){
                e.printStackTrace();
            }
        }
    }
}
