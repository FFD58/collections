package ru.fafurin.lesson8.entity.product;

import ru.fafurin.six.lesson8.entity.Entity;

public interface ProductInterface extends Entity {

    int getId();
    void setId(int id);
    String getTitle();
    int getPrice();
    int getCount();
    void setCount(int count);

}
