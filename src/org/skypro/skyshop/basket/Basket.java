package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Map;
import java.util.*;

public class Basket {
    private Map<String, List<Product>> products;

    public Basket() {
        this.products = new LinkedHashMap<>();
    }

    @Override
    public String toString() {
        String res = products.values().stream().flatMap(Collection::stream)
                .map(product -> product.toString() + '\n')
                .reduce("", String::concat);
        if (res == "") {
            return "в корзине пусто";
        }
        res += "Итого: " + this.getTotalPrice() + '\n' + "Специальных товаров: " + this.getAllSpecial();
        return res;
    }

    public void addProduct(Product newProduct) {
        if (products.containsKey(newProduct.getName())) {
            products.get(newProduct.getName()).add(newProduct);
        } else {
            List<Product> listNewProduct = new ArrayList<>();
            listNewProduct.add(newProduct);
            products.put(newProduct.getName(), listNewProduct);
        }
    }


    public int getTotalPrice() {
        int res = products.values().stream().flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
        return res;
    }


    public int getAllSpecial() {
        Long res = products.values().stream().flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
        var res2 = res.intValue();
        return res2;
    }

    public boolean isProductInBasket(String searchedProduct) {
        return products.containsKey(searchedProduct);
    }

    public void clear() {
        products.clear();
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removed = new LinkedList<>();
        if (products.containsKey(name)) {
            removed = products.get(name);
            products.remove(name);
        }
        return removed;
    }
}

