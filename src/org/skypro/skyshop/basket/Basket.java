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
        String res = "";
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    res += product.toString();
                    res += '\n';
                }
            }
        }
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
        int res = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    res += product.getPrice();
                }
            }
        }
        return res;
    }

    public int getAllSpecial() {
        int res = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product.isSpecial()) {
                    res++;
                }
            }
        }
        return res;
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

