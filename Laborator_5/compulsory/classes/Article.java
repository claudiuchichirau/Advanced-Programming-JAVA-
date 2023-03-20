package org.example.compulsory.classes;

import java.util.Map;
public class Article extends Document{
    private int numberOfPages;

    public Article(int id, String name, Map<String, Object> tags, int numberOfPages) {
        super(id, name, tags);
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
