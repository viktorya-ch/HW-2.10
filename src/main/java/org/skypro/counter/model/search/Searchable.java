package org.skypro.counter.model.search;

import java.util.UUID;

public interface Searchable {

        String getSearchTerm();

        String getContentType();

        String getName();

        default String getStringRepresentation() {
            return " " + getName() + " " + getContentType() + " ";
        }

    default Searchable getId(){
        return UUID(java.util.UUID);
    }

 }


