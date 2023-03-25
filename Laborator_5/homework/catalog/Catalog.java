package org.example.homework.catalog;

import org.example.homework.documents.Document;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Document> documents;

    public Catalog() {
        this.documents = new ArrayList<>();
    }

    public void setDocuments(List<Document> documents){
        this.documents = documents;
    }

    public List<Document> getDocuments(){
        return documents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Document document : this.documents) {
            sb.append(document.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}