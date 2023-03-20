package org.example.compulsory.classes;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Document> documents;

    public Catalog() {
        this.documents = new ArrayList<>();
    }

    public void addDocument(Document document) {
        this.documents.add(document);
    }

    public boolean removeDocument(Document document) {
        return this.documents.remove(document);
    }

    public void saveCatalog(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // adaugarea tab-urilor pentru o formatare mai buna

        try {
            mapper.writeValue(new File(fileName), this.documents);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadCatalog(String fileName) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            this.documents = mapper.readValue(new File(fileName), new TypeReference<List<Document>>() {});

            for(Document document : documents)
                System.out.println(document);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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