package ru.fafurin.lesson8.entity.cart;

import ru.fafurin.six.lesson8.entity.Entity;
import ru.fafurin.six.lesson8.entity.product.ProductInterface;

import java.util.HashMap;

public interface CartInterface extends Entity {
    void addProduct(ProductInterface product);
    HashMap<Integer, ProductInterface> getCart();
}
