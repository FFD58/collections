package ru.fafurin.lesson8.repository.product;

import ru.fafurin.six.lesson8.entity.product.ProductInterface;
import ru.fafurin.six.lesson8.repository.Repository;

import java.util.HashMap;

public interface ProductRepositoryInterface extends Repository {

    public static int START = 1;
    HashMap<Integer, ProductInterface> getProducts();

    ProductInterface getById(int id);
    void saveProductCatalogToFile();
}
