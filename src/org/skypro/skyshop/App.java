package org.skypro.skyshop;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        testAppStationery();
        System.out.println("________________" + '\n');
        testAppStationeryWithSearchAndArticle();
    }

    public static void testAppStationeryWithSearchAndArticle() {
        //товары канцелярского магазина
        Searchable pen = new SimpleProduct("ручка синяя", 15);
        Searchable pencil = new FixPriceProduct("карандаш");
        Searchable album = new FixPriceProduct("альбом для рисования");
        Searchable squaredNotebook = new DiscountedProduct("тетрадь в клетку", 12, 15);
        Searchable linedNotebook = new DiscountedProduct("тетрадь в линейку", 11, 10);
        SimpleProduct coloredCardboard = new SimpleProduct("цветной картон", 60);

        SearchEngine stationery = new SearchEngine(9);

        //статьи о товарах канцелярского магазина
        Searchable aboutPen = new Article("Шариковой ручка", "Ша́риковая ру́чка — разновидность ручки (авторучки), при письме которой чернила переносятся из резервуара на бумагу вращающимся шариком.");
        Searchable aboutPencil = new Article("Графитовый карандаш", "Деревянная палочка со стержнем из графита для письма, рисования, черчения.");
        Searchable aboutNotebook = new Article("Школьная тетрадь", "тетрадь, предназначенная для письма школьниками в период обучения в общеобразовательных учебных учреждениях и учреждениях начального профессионального образования.");
        Searchable aboutAlbum = new Article("Художественный альбом", "Книга, тетрадь в переплёте для стихов, рисунков. В нашем магазине есть разнообразные альбомы, скетчбуки простые и профессиональные на любой вкус!))");

        //Функциональность Article:
        System.out.println(aboutPen);
        System.out.println(((Article)aboutPencil).getName() + '\n');
        //Строковое представление через интерфейс:
        System.out.println(coloredCardboard.getStringRepresentation());
        System.out.println(aboutAlbum.getStringRepresentation() + '\n');
        //Функциональность SearchEngine:
        stationery.add(pen);
        stationery.add(pencil);
        stationery.add(album);
        stationery.add(squaredNotebook);
        stationery.add(linedNotebook);
        stationery.add(coloredCardboard);
        stationery.add(aboutPen);
        stationery.add(aboutPencil);
        stationery.add(aboutNotebook);
        //переполнение:
        stationery.add(aboutAlbum);
        //поиск:
        System.out.println('\n' + "Поиск по слову - тетрадь: " + '\n' + Arrays.toString(stationery.search("тетрадь")) + '\n');
        System.out.println("Поиск по слову - альбом: " + '\n' + Arrays.toString(stationery.search("альбом")) + '\n');
        System.out.println("Поиск по слову - карандаш: " + '\n' + Arrays.toString(stationery.search("карандаш")) + '\n');
        System.out.println("Поиск по слову - ручка: " + '\n' + Arrays.toString(stationery.search("ручка")));
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