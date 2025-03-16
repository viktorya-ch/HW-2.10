package org.skypro.counter.model.search;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;



public class SearchEngine {
    private TreeSet<Searchable> searchables;




    public SearchEngine() {
        searchables = new TreeSet<>(new SearchableComparator());
    }

    public void addSearchable(Searchable searchable) {
        searchables.add(searchable);
    }

    public TreeSet<Searchable> search(String inquiry) {
        Supplier<TreeSet<Searchable>> treeSetSupplier = () -> new TreeSet<>(new SearchableComparator());
        return searchables.stream().filter(searchable -> searchable.getName().toLowerCase().contains(inquiry.toLowerCase())).collect(Collectors.toCollection(treeSetSupplier));
    }


    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }

    public HashSet<Searchable> findAllObjects(String search) throws BestResultNotFound {
        HashSet<Searchable> objects = searchables.stream().filter(searchable -> countOccurrences(searchable.getSearchTerm(), search) > 0).collect(Collectors.toCollection(HashSet::new));
        if (objects.isEmpty()) {
            throw new BestResultNotFound(" Объект для запроса " + search + " не найден");
        }
        return objects;

    }

}
