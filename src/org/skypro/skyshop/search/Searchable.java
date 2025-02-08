package org.skypro.skyshop.search;

public interface Searchable extends Comparable<Searchable> {
    String searchTerm();

    String typeFound();

    default String getStringRepresentation() {
        return this.searchTerm() + " — " + this.typeFound();
    }

    @Override
    default int compareTo(Searchable o) {
        return searchTerm().compareTo(o.searchTerm());
    }
}


