package ru.fafurin.lesson8.model;

import ru.fafurin.six.lesson8.entity.product.ProductInterface;

public class ProductModel {
    private int id;
    private String title;
    private int price;
    private int count;

    public ProductModel(ProductInterface product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.count = product.getCount();
    }

    @Override
    public String toString() {
        return String.format("id: %d\ntitle: %s\nprice: %d\ncount: %d\n\n", this.id, this.title, this.price, this.count);
    }
}
