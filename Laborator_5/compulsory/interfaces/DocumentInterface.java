package org.example.compulsory.interfaces;


import java.util.Map;

public interface DocumentInterface {
    void setID(int id);
    int getID();
    void setName(String Name);
    String getName();
    void setTags(Map<String, Object> tags);
    Map<String, Object> getTags();
}
