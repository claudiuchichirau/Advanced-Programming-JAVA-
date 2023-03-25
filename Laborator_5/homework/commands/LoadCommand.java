package org.example.homework.commands;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.homework.catalog.Catalog;
import org.example.homework.documents.Book;
import org.example.homework.exceptions.InvalidCommandParameterException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LoadCommand extends CatalogCommand {
    private final String filePath;

    public LoadCommand(Catalog catalog, String filePath) {
        super(catalog);
        this.filePath = filePath;
    }

    @Override
    public void execute() throws IOException, InvalidCommandParameterException /*throws IOException*/ {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File(filePath);
        if (!file.exists()) {
            throw new InvalidCommandParameterException("File not found: " + filePath);
        }

        List<Book> books = objectMapper.readValue(new File(filePath), new TypeReference<List<Book>>() {});

        for(Book book : books) {
            AddCommand newDocument = new AddCommand(this.catalog, book);
            newDocument.execute();
        }
    }
}
