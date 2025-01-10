package org.skypro.skyshop;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;

public class App {
    public static void main(String[] args) {
        testAppStationery();
    }

    public static void testAppStationery() {
        //товары канцелярского магазина
        SimpleProduct pen = new SimpleProduct("ручка синяя", 15);
        FixPriceProduct pencil = new FixPriceProduct("карандаш");
        FixPriceProduct album = new FixPriceProduct("Альбом для рисования");
        DiscountedProduct squaredNotebook = new DiscountedProduct("тетрадь в клетку", 12, 15);
        DiscountedProduct linedNotebook = new DiscountedProduct("тетрадь в линейку", 11, 10);
        SimpleProduct coloredCardboard = new SimpleProduct("цветной картон", 60);
        //корзина покупателя Саша
        Basket sasha = new Basket();
        // 1.
        sasha.addProduct(pen);
        sasha.addProduct(pencil);
        sasha.addProduct(album);
        sasha.addProduct(squaredNotebook);
        sasha.addProduct(linedNotebook);
        //2.
        sasha.addProduct(coloredCardboard);
        //3.
        System.out.println(sasha);
        //4.
        System.out.println("Общая стоимость корзины " + sasha.getTotalPrice() + " рублей");
        //5.
        System.out.println(sasha.isProductInBasket(pencil.getName()));
        //6.
        System.out.println(sasha.isProductInBasket(coloredCardboard.getName()));
        //7.
        sasha.clearBasket();
        //8.
        System.out.println(sasha);
        //9.
        System.out.println("Общая стоимость корзины " + sasha.getTotalPrice() + " рублей");
        //10.
        System.out.println(sasha.isProductInBasket(coloredCardboard.getName()));
    }

}