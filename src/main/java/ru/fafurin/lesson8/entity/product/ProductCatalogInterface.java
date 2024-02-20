package ru.fafurin.lesson8.entity.product;

import java.util.HashMap;

public interface ProductCatalogInterface {
    void putProductToCatalog(ProductInterface product);
    HashMap<Integer, ProductInterface> getCatalog();
}
