package ru.fafurin.lesson8.entity.product;

import java.util.HashMap;

public class ProductCatalog implements ProductCatalogInterface {

    private HashMap<Integer, ProductInterface> catalog = new HashMap<>();

    @Override
    public String toString() {
        return String.valueOf(catalog);
    }

    public void putProductToCatalog(ProductInterface product) {
        this.catalog.put(product.getId(), product);
    }

    public HashMap<Integer, ProductInterface> getCatalog() {
        return catalog;
    }
}
