package org.example.compulsory.classes;

import org.example.compulsory.interfaces.DocumentInterface;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;

public class Document implements DocumentInterface {
    private int id;
    private String name;
    private Map<String, Object> tags = new HashMap<>();

    public Document() {
        // constructor implicit
    }
    public Document(int id, String name, Map<String, Object> tags) {

        if (id < 0)
            throw new IllegalArgumentException("ID should be a positive number:" + id);
        else
            this.id = id;

        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name should not be empty.");
        } else if (!name.matches("[a-zA-Z0-9 ,;.!?:-]+")) {
            throw new IllegalArgumentException("Name should only contain characters: " + name);
        } else
            this.name = name;

        if (tags == null) {
            this.tags = new HashMap<>();
        } else {
            for (Map.Entry<String, Object> entry : tags.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                if (key == "Title") {
                    if (value instanceof String) {
                        String title = (String) value;
                        if (title == null || title.trim().equals(""))
                            throw new IllegalArgumentException("Title should not be empty.");
                        if (!title.matches("[A-Za-z0-9 ,;.!?:-]+"))
                            throw new IllegalArgumentException("Title must contain only letters or digits: " + title);
                    } else throw new IllegalArgumentException("Title should be a String.");
                } else if (key == "Author") {
                    if (value instanceof String) {
                        String author = (String) value;
                        if (author == null || author.trim().equals(""))
                            throw new IllegalArgumentException("Author should not be empty.");
                        if (!author.matches("[A-Za-z ]+"))
                            throw new IllegalArgumentException("Title must contain only letters: " + author);
                    } else throw new IllegalArgumentException("Title should be a String.");
                } else if (key == "Year") {
                    if (value instanceof Integer) {
                        int year = (int) value;
                        if (year > 1900 && year <= 2023) {
                            // year is within the valid range
                        } else {
                            throw new IllegalArgumentException("Year should be between 1901 and 2023.");
                        }
                    } else {
                        throw new IllegalArgumentException("Year should be an Integer.");
                    }
                } else if (key == "PublishingDate"){
                    if(!(value instanceof Calendar))
                        throw new IllegalArgumentException("PublishingDate should be a Calendar.");
                } else if (key != "Title" || key != "Author" || key != "Year" || key != "PublishingDate")
                    throw new IllegalArgumentException("Invalid tag type or missing tag key. Key " + key);
            }
            this.tags = tags;
        }
    }

    @Override
    public void setID(int id) {
        if (id < 0)
            throw new IllegalArgumentException("ID should be a positive number:" + id);
        else
            this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setName(String Name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name should not be empty.");
        } else if (!name.matches("[a-zA-Z ,;.!?:-]+")) {
            throw new IllegalArgumentException("Name should only contain characters: " + name);
        } else
            this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setTags(Map<String, Object> tags) {
        if (tags == null) {
            this.tags = new HashMap<>();
        } else {
            for (Map.Entry<String, Object> entry : tags.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                if (key == "Title") {
                    if (value instanceof String) {
                        String title = (String) value;
                        if (title == null || title.trim().equals(""))
                            throw new IllegalArgumentException("Title should not be empty.");
                        if (!title.matches("[A-Za-z0-9 ,;.!?:-]+"))
                            throw new IllegalArgumentException("Title must contain only letters or digits: " + title);
                    } else throw new IllegalArgumentException("Title should be a String.");
                } else if (key == "Author") {
                    if (value instanceof String) {
                        String author = (String) value;
                        if (author == null || author.trim().equals(""))
                            throw new IllegalArgumentException("Author should not be empty.");
                        if (!author.matches("[A-Za-z ]+"))
                            throw new IllegalArgumentException("Title must contain only letters: " + author);
                    } else throw new IllegalArgumentException("Title should be a String.");
                } else if (key == "Year") {
                    if (value instanceof Integer) {
                        int year = (int) value;
                        if (year > 1900 && year <= 2023) {
                            // year is within the valid range
                        } else {
                            throw new IllegalArgumentException("Year should be between 1901 and 2023.");
                        }
                    } else {
                        throw new IllegalArgumentException("Year should be an Integer.");
                    }
                } else if (key == "PublishingDate"){
                    if(!(value instanceof Calendar))
                        throw new IllegalArgumentException("PublishingDate should be a Calendar.");
                } else if (key != "Title" || key != "Author" || key != "Year" || key != "PublishingDate")
                    throw new IllegalArgumentException("Invalid tag type or missing tag key. Key " + key);
            }
            this.tags = tags;
        }
    }

    @Override
    public Map<String, Object> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + this.getID() + ", ");
        sb.append("Name: '" + this.getName() + "', ");

        if (tags != null || tags.isEmpty()) {
            sb.append("Tags [");

            for (Map.Entry<String, Object> entry : tags.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                if(key == "PublishingDate"){
                    Calendar publishingDate = (Calendar) tags.get("PublishingDate");
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = format.format(publishingDate.getTime());
                    sb.append(key + ": " + formattedDate + ", ");
                }
                else
                    sb.append(key + ": " + value + ", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("]");
        }
        return sb.toString();
    }

}