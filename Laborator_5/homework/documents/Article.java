package org.example.homework.documents;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
public class Article extends Document {
    private int numberOfPages;

    @JsonCreator
    public Article(@JsonProperty("id") int id,
                   @JsonProperty("name") String name,
                   @JsonProperty("url") String url,
                   @JsonProperty("tags") Map<String, Object> tags,
                   @JsonProperty("numberOfPages") int numberOfPages) {
        super(id, name, url, tags);
        this.numberOfPages = numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages){
        if (numberOfPages < 0) {
            throw new IllegalArgumentException("'numberOfPages' should be a positive number:" + numberOfPages);
        }
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages(){
        return numberOfPages;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tType : ARTICLE, Number of Pagess: " + numberOfPages + ".";
    }
}