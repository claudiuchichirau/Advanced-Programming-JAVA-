package org.example.homework.documents;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Document implements DocumentInterface {
    private int id;
    private String name;
    private String url;
    private Map<String, Object> tags = new HashMap<>();

    @JsonCreator
    public Document(@JsonProperty("id") int id,
                    @JsonProperty("name") String name,
                    @JsonProperty("url") String url,
                    @JsonProperty("tags") Map<String, Object> tags) {

        // Validates the ID.
        if (id < 0)
            throw new IllegalArgumentException("ID should be a positive number:" + id);
        else
            this.id = id;

        // Validates the name.
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name should not be empty.");
        } else if (!name.matches("[a-zA-Z0-9 ,;.!?:-]+")) {
            throw new IllegalArgumentException("Name should only contain characters: " + name);
        } else
            this.name = name;

        // Validates the URL.
        if (url == null || url.trim().equals(""))
            throw new IllegalArgumentException("URL should not be empty.");
        else
            this.url = url;

        // Validates the tags.
        if (tags == null) {
            this.tags = new HashMap<>();
        } else {
            for (Map.Entry<String, Object> entry : tags.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                // Validates the "Title" tag.
                if (key == "Title") {
                    if (value instanceof String) {
                        String title = (String) value;
                        if (title == null || title.trim().equals(""))
                            throw new IllegalArgumentException("Title should not be empty.");
                        if (!title.matches("[A-Za-z0-9 ,;.!?:-]+"))
                            throw new IllegalArgumentException("Title must contain only letters or digits: " + title);
                    } else throw new IllegalArgumentException("Title should be a String.");

                    // Validates the "Author" tag.
                } else if (key == "Author") {
                    if (value instanceof String) {
                        String author = (String) value;
                        if (author == null || author.trim().equals(""))
                            throw new IllegalArgumentException("Author should not be empty.");
                        if (!author.matches("[A-Za-z ]+"))
                            throw new IllegalArgumentException("Author must contain only letters: " + author);
                    } else throw new IllegalArgumentException("Author should be a String.");

                    // Validates the "Year" tag.
                } else if (key == "Year") {
                    if (value instanceof Integer) {
                        int year = (int) value;
                        if (year > 1000 && year <= 2023) {
                            // year is within the valid range
                        } else {
                            throw new IllegalArgumentException("Year should be between 1901 and 2023.");
                        }
                    } else {
                        throw new IllegalArgumentException("Year should be an Integer.");
                    }

                    // Validates the "PublishingDate" tag.
                } else if (key == "PublishingDate"){
                    if((value instanceof String)){
                        String data = (String) value;
                        if (!data.matches("[0-9., ]+"))
                            throw new IllegalArgumentException("PublishingDate must contain only letters: " + data);
                    }
                    else
                        throw new IllegalArgumentException("PublishingDate should be a String.");
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
    public void setURL(String url) {
        if (url == null || url.trim().equals(""))
            throw new IllegalArgumentException("Name should not be empty.");
        else
            this.url = url;
    }

    @Override
    public String getURL() {
        return url;
    }

    @Override
    public void setTags(Map<String, Object> tags) {
        if (tags == null) {
            this.tags = new HashMap<>();
        } else {
            for (Map.Entry<String, Object> entry : tags.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                // Validates the "Title" tag.
                if (key == "Title") {
                    if (value instanceof String) {
                        String title = (String) value;
                        if (title == null || title.trim().equals(""))
                            throw new IllegalArgumentException("Title should not be empty.");
                        if (!title.matches("[A-Za-z0-9 ,;.!?:-]+"))
                            throw new IllegalArgumentException("Title must contain only letters or digits: " + title);
                    } else throw new IllegalArgumentException("Title should be a String.");

                    // Validates the "Author" tag.
                } else if (key == "Author") {
                    if (value instanceof String) {
                        String author = (String) value;
                        if (author == null || author.trim().equals(""))
                            throw new IllegalArgumentException("Author should not be empty.");
                        if (!author.matches("[A-Za-z ]+"))
                            throw new IllegalArgumentException("Author must contain only letters: " + author);
                    } else throw new IllegalArgumentException("Author should be a String.");

                    // Validates the "Year" tag.
                } else if (key == "Year") {
                    if (value instanceof Integer) {
                        int year = (int) value;
                        if (year > 1000 && year <= 2023) {
                            // year is within the valid range
                        } else {
                            throw new IllegalArgumentException("Year should be between 1901 and 2023.");
                        }
                    } else {
                        throw new IllegalArgumentException("Year should be an Integer.");
                    }

                    // Validates the "PublishingDate" tag.
                } else if (key == "PublishingDate"){
                    if((value instanceof String)){
                        String data = (String) value;
                        if (!data.matches("[0-9., ]+"))
                            throw new IllegalArgumentException("PublishingDate must contain only letters: " + data);
                    }
                    else
                        throw new IllegalArgumentException("PublishingDate should be a String.");
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
        sb.append("URL: '" + this.getURL() + "', ");

        if (tags != null || tags.isEmpty()) {
            sb.append("Tags [");

            for (Map.Entry<String, Object> entry : tags.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                sb.append(key + ": " + value + ", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("]");
        }
        return sb.toString();
    }

}
