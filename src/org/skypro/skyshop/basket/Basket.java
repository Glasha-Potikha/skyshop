package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Basket {
    private List<Product> products;

    public Basket() {
        this.products = new LinkedList<>();
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

        if (this.isProductInBasket(newProduct.getName())) {
            System.out.println("Продукт уже есть в корзине");
            return;
        }
        products.add(newProduct);

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

    public void clear() {
        Iterator<Product> iterator = products.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removed = new LinkedList<>();
        Iterator<Product> iterator = products.listIterator();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (Objects.equals(element.getName(), name)) {
                removed.add(element);
                iterator.remove();
            }
        }
        return removed;
    }
}

