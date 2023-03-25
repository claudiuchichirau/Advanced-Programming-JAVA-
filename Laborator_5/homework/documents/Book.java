package org.example.homework.documents;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Book extends Document {
    private String isbn;
    private String publisher;

    @JsonCreator
    public Book(@JsonProperty("id") int id,
                @JsonProperty("name") String name,
                @JsonProperty("url") String url,
                @JsonProperty("tags") Map<String, Object> tags,
                @JsonProperty("isbn") String isbn,
                @JsonProperty("publisher") String publisher) {
        super(id, name, url, tags);

        if (isbn == null || isbn.trim().equals("")) {
            throw new IllegalArgumentException("ISBN should not be empty.");
        } else if (!isbn.matches("[A-Z0-9-]+")) {
            throw new IllegalArgumentException("ISBN must contain only capital letters and/or digits: " + isbn);
        } else
            this.isbn = isbn;

        if (publisher == null || publisher.trim().equals("")) {
            throw new IllegalArgumentException("Publisher should not be empty.");
        } else if (!publisher.matches("[A-Za-z ]+")) {
            throw new IllegalArgumentException("Publisher must contain only letters: " + publisher);
        } else
            this.publisher = publisher;
    }

    public void setISBN(String isbn){
        if (isbn == null || isbn.trim().equals("")) {
            throw new IllegalArgumentException("ISBN should not be empty.");
        } else if (!isbn.matches("[A-Z0-9-]+")) {
            throw new IllegalArgumentException("ISBN must contain only capital letters and/or digits: " + isbn);
        } else
            this.isbn = isbn;
    }

    public String getISBN(){
        return isbn;
    }

    public void setPublisher(String publisher){
        if (publisher == null || publisher.trim().equals("")) {
            throw new IllegalArgumentException("Publisher should not be empty.");
        } else if (!publisher.matches("[A-Za-z ]+")) {
            throw new IllegalArgumentException("Publisher must contain only letters: " + publisher);
        } else
            this.publisher = publisher;
    }

    public String getPublisher(){
        return publisher;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tType : BOOK, ISBN: '" + isbn + "', Publisher: '" + publisher + "'.";
    }

}
