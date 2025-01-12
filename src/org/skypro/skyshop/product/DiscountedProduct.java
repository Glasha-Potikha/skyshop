package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    final private int basePrice;
    final private int percentageDiscount;
    //Скидка может быть только положительным целым числом от 0 до 100

    public DiscountedProduct(String name, int basePrice, int percentageDiscount) {
        super(name);
        this.basePrice = basePrice;
        this.percentageDiscount = percentageDiscount;
    }

    @Override
    public int getPrice() {
        float res = (float) (basePrice / 100) * (100 - percentageDiscount);
        return (int) res;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return super.getName() +
                ": " + basePrice + " (" + percentageDiscount + ")";
    }


}
