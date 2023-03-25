package org.example.homework.commands;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.homework.catalog.Catalog;
import org.example.homework.documents.Document;
import org.example.homework.exceptions.InvalidCommandParameterException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SaveCommand extends CatalogCommand{

    private String fileName;
    public SaveCommand(Catalog catalog, String fileName) {
        super(catalog);
        this.fileName = fileName;
    }

    @Override
    public void execute() throws IOException, InvalidCommandParameterException {
        List<Document> documents = catalog.getDocuments();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // adding tabs for better formatting

        try {
            mapper.writeValue(new File(fileName), documents);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
