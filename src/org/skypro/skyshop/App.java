package org.skypro.skyshop;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.Searchable;

import java.util.List;

public class App {
    public static void main(String[] args) {
        testAppStationery();
        System.out.println("________________" + '\n');
        testAppStationeryWithSearchAndArticle();
        System.out.println("\n_______ДЗ.Исключения_________\n_");
        testAppStationeryWithException();
        System.out.println("\n_______ДЗ.Списки_________\n_");
        testAppStationeryWithLists();
    }

    public static void testAppStationeryWithLists() {
        //товары канцелярского магазина
        SimpleProduct pen = new SimpleProduct("ручка синяя", 15);
        FixPriceProduct pen2 = new FixPriceProduct("ручка красная упак 10шт");
        FixPriceProduct pen3 = new FixPriceProduct("ручка зеленая упак 10шт");
        DiscountedProduct pen4 = new DiscountedProduct("подарочная ручка", 500, 15);
        DiscountedProduct pen5 = new DiscountedProduct("гелевая ручка", 11, 10);
        SimpleProduct pen6 = new SimpleProduct("ручка черная", 15);
        SimpleProduct pencil = new SimpleProduct("карандаш", 15);
        System.out.println("--Демонстрация изменений  в классе Basket--");
        //корзина покупателя Маша
        Basket masha = new Basket();
        masha.addProduct(pen);
        masha.addProduct(pen2);
        masha.addProduct(pen3);
        masha.addProduct(pen4);
        masha.addProduct(pen5);
        //Вывести содержимое корзины
        System.out.println("\nВ корзине Маши: \n" + masha);
        //Удалить существующий продукт из корзины и вывести удаленные продукты на экран.
        System.out.println("\nудалили" + masha.removeProductByName("ручка синяя"));
        //Удаляем несуществующий продукт.
        List<Product> removed = masha.removeProductByName("глобус");
        //Проверяем, что список удаленных продуктов пустой и вывести сообщение “Список пуст”.
        if (removed.isEmpty()) {
            System.out.println("\nСписок пуст");
        }
        //Вывести содержимое корзины на экран.
        System.out.println("\nВ корзине Маши: \n" + masha);
        //
        System.out.println("\n--Демонстрация зменений в классе SearchEngine--");
        SearchEngine stationery = new SearchEngine(7);
        stationery.add(pencil);
        stationery.add(pen);
        stationery.add(pen2);
        stationery.add(pen3);
        stationery.add(pen4);
        stationery.add(pen5);
        stationery.add(pen6);

        stationery.printResSearch("ручка");
        stationery.printResSearch("карандаш");
        stationery.printResSearch("ластик");
    }

    public static void testAppStationeryWithException() {
        try {
            Searchable pencil = new FixPriceProduct("  ");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка - неверный ввод наименования продукта");
        }

        try {
            Searchable pen = new SimpleProduct("ручка синяя", -15);
        } catch (Exception e) {
            System.out.println("Ошибка - неверный ввод цены");
        }
        try {
            Searchable squaredNotebook = new DiscountedProduct("тетрадь в клетку", 12, 115);
        } catch (Exception e) {
            System.out.println("Ошибка - неверный ввод базовой цены");
        }
        try {
            Searchable linedNotebook = new DiscountedProduct("тетрадь в линейку", 0, 10);
        } catch (Exception e) {
            System.out.println("Ошибка - неверный ввод процентов");
        }


        System.out.println('\n' + "--Демонстрация нового метода поиска-");
        //товары канцелярского магазина
        Searchable pen = new SimpleProduct("ручка синяя", 15);
        Searchable pencil = new FixPriceProduct("карандаш");
        Searchable album = new FixPriceProduct("альбом для рисования");
        Searchable squaredNotebook = new DiscountedProduct("тетрадь в клетку", 12, 15);
        Searchable linedNotebook = new DiscountedProduct("тетрадь в линейку", 11, 10);
        SimpleProduct coloredCardboard = new SimpleProduct("цветной картон", 60);
        //Статьи
        Searchable aboutPen = new Article("Шариковой ручка", "Ша́риковая ру́чка — разновидность ручки (авторучки), при письме которой чернила переносятся из резервуара на бумагу вращающимся шариком.");
        Searchable aboutPencil = new Article("Графитовый карандаш", "Деревянная палочка со стержнем из графита для письма, рисования, черчения.");
        Searchable aboutNotebook = new Article("Школьная тетрадь", "тетрадь, предназначенная для письма школьниками в период обучения в общеобразовательных учебных учреждениях и учреждениях начального профессионального образования.");

        SearchEngine stationery = new SearchEngine(9);
        stationery.add(pen);
        stationery.add(pencil);
        stationery.add(album);
        stationery.add(squaredNotebook);
        stationery.add(linedNotebook);
        stationery.add(coloredCardboard);
        stationery.add(aboutPen);
        stationery.add(aboutPencil);
        stationery.add(aboutNotebook);
        try {
            System.out.println('\n' + "Поиск по слову - тетрадь: " + '\n' + stationery.searchForTheBestMatch("тетрадь") + '\n');
            stationery.searchForTheBestMatch("глобус");
        } catch (
                BestResultNotFound e) {
            System.out.println("Для поискового запроса - " + e.getMessage() + " - не нашлось подходящей статьи");
        }

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
        System.out.println(((Article) aboutPencil).getName() + '\n');
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
        stationery.printResSearch("тетрадь");
        stationery.printResSearch("альбом");
        stationery.printResSearch("карандаш");
        stationery.printResSearch("ручка");

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
        //2.здесь была демонстрация невозможности добавления продукта из-за нехватки места
        //3.
        System.out.println(sasha);
        //4.
        System.out.println("Общая стоимость корзины " + sasha.getTotalPrice() + " рублей");
        //5.
        System.out.println(sasha.isProductInBasket(pencil.getName()));
        //6.
        System.out.println(sasha.isProductInBasket(coloredCardboard.getName()));
        //7.
        sasha.clear();
        //8.
        System.out.println(sasha);
        //9.
        System.out.println("Общая стоимость корзины " + sasha.getTotalPrice() + " рублей");
        //10.
        System.out.println(sasha.isProductInBasket(coloredCardboard.getName()));
    }

}