package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    final private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Цена продукта дожна быть больше 1 рубля или равна ему");
        }
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return super.getName() +
                ": " + price;
    }
}
