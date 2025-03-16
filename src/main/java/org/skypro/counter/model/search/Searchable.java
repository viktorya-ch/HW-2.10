package model.search;

import java.util.UUID;

public interface Searchable {

        String getSearchTerm();

        String getContentType();

        String getName();

        default String getStringRepresentation() {
            return " " + getName() + " " + getContentType() + " ";
        }

 }


 public Searchable getId(){
     return UUID(java.util.UUID);
 }