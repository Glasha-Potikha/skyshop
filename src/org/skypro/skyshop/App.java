package org.skypro.skyshop;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        testAppStationery();
    }

    public static void testAppStationery() {
        //товары канцелярского магазина
        Product pen = new Product("ручка синяя", 15);
        Product pencil = new Product("карандаш", 10);
        Product album = new Product("Альбом для рисования", 73);
        Product squaredNotebook = new Product("тетрадь в клетку", 12);
        Product linedNotebook = new Product("тетрадь в линейку", 11);
        Product coloredCardboard = new Product("цветной картон", 60);
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