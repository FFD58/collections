package ru.fafurin.lesson8.entity.cart;

import ru.fafurin.six.lesson8.entity.product.ProductInterface;

import java.util.HashMap;

public class Cart implements CartInterface {
    private HashMap<Integer, ProductInterface> cart = new HashMap<>();

    public void addProduct(ProductInterface product) {
        this.cart.put(product.getId(), product);
    }
    public HashMap<Integer, ProductInterface> getCart() {
        return this.cart;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart=" + cart +
                '}';
    }
}
