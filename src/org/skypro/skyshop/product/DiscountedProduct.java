package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    final private int basePrice;
    final private int percentageDiscount;
    //Скидка может быть только положительным целым числом от 0 до 100

    public DiscountedProduct(String name, int basePrice, int percentageDiscount) {
        super(name);
        if (basePrice > 0) {
            this.basePrice = basePrice;
        } else {
            throw new IllegalArgumentException("Цена продукта дожна быть больше 1 рубля или равна ему");
        }
        if (percentageDiscount >= 0 && percentageDiscount <= 100) {
            this.percentageDiscount = percentageDiscount;
        } else {
            throw new IllegalArgumentException("Процент должен быть числом в диапазоне от 0 до 100 включительно");
        }
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
