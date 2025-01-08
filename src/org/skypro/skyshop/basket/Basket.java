package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class Basket {
    private Product[] products;

    public Basket() {
        this.products = new Product[5];
    }

    @Override
    public String toString() {
        String res = "";
        for (Product product : this.products) {
            if (product != null) {
                res += product.toString();
                res += '\n';
            }
        }
        if (res == "") {
            return "в корзине пусто";
        }
        res += "Итого: " + this.getTotalPrice() + '\n' + "Специальных товаров: " + this.getAllSpecial();
        return res;
    }

    public void addProduct(Product newProduct) {
        if (this.products[4] != null) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        if (this.isProductInBasket(newProduct.getName())) {
            System.out.println("Продукт уже есть в корзине");
            return;
        }
        for (int i = 0; i < this.products.length; i++) {
            if (products[i] == null) {
                products[i] = newProduct;
                break;
            }
        }

    }

    public int getTotalPrice() {
        int res = 0;
        for (Product product : this.products) {
            if (product != null) {
                res += product.getPrice();
            }
        }
        return res;
    }

    public int getAllSpecial() {
        int res = 0;
        for (Product product : this.products) {
            if (product.isSpecial()) {
                res++;
            }
        }
        return res;
    }

    public boolean isProductInBasket(String searchedProduct) {
        boolean itFound = false;
        for (Product product : this.products) {
            if (product != null) {
                if (Objects.equals(product.getName(), searchedProduct)) {
                    itFound = true;
                }
            }
        }
        return itFound;
    }

    public void clearBasket() {
        for (int i = 0; i < this.products.length; i++) {
            if (products[i] != null) {
                products[i] = null;
            }
        }
    }
}

