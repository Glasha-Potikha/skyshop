package org.skypro.skyshop.search;

public interface Searchable {
    String searchTerm();

    String typeFound();

    default String getStringRepresentation() {
        return this.searchTerm() + " — " + this.typeFound();
    }
}
