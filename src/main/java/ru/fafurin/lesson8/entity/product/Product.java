package ru.fafurin.lesson8.entity.product;

import java.util.Random;

public class Product implements ProductInterface {

    private int id;
    private String title;
    private int price;
    private int count;

    private Random random = new Random();

    public Product(String title, int price, int count) {
        this.id = this.random.nextInt(100);
        this.title = title;
        this.price = price;
        this.count = count;
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("title:%s price:%d count:%d;\n", this.title, this.price, this.count);
    }

}
