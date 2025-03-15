package model.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        int lenghtComparison = Integer.compare(o2.getName().length(), o1.getName().length());
        if (lenghtComparison != 0) {
            return lenghtComparison;

        }
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}

