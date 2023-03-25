package org.example.homework.documents;


import java.util.Map;

public interface DocumentInterface {
    void setID(int id);
    int getID();
    void setName(String Name);
    String getName();
    void setURL(String url);
    String getURL();
    void setTags(Map<String, Object> tags);
    Map<String, Object> getTags();
}

