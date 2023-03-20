package org.example.compulsory.classes;


import java.util.Map;

public class Book extends Document{
    private String isbn;
    private String publisher;

    public Book(int id, String name, Map<String, Object> tags, String isbn, String publisher) {
        super(id, name, tags);

        if (isbn == null || isbn.trim().equals("")) {
            throw new IllegalArgumentException("ISBN should not be empty.");
        } else if (!isbn.matches("[A-Z0-9]+")) {
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
        } else if (!isbn.matches("[A-Z0-9]+")) {
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
