package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    final private String name;


    public Product(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой");
        }
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String searchTerm() {
        return this.getName();
    }

    @Override
    public String typeFound() {
        return "PRODUCT";
    }
}
