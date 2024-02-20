package ru.fafurin.lesson8.service;

import ru.fafurin.six.lesson8.entity.product.ProductCatalogInterface;
import ru.fafurin.six.lesson8.entity.product.ProductInterface;
import ru.fafurin.six.lesson8.model.ProductCatalogModel;
import ru.fafurin.six.lesson8.model.ProductModel;
import ru.fafurin.six.lesson8.repository.product.ProductRepositoryInterface;

import java.util.HashMap;

public class ProductService {
    ProductCatalogInterface productCatalog;
    ProductRepositoryInterface productRepository;

    public ProductService(ProductCatalogInterface productCatalog, ProductRepositoryInterface productRepository) {
        this.productCatalog = productCatalog;
        this.productRepository = productRepository;
        this.fillProductCatalog();
    }

    public void fillProductCatalog() {
        HashMap<Integer, ProductInterface> products = this.productRepository.getProducts();
        products.forEach((id, product) -> {
            this.productCatalog.putProductToCatalog(product);
        });
    }

    public ProductCatalogInterface getProductCatalog() {
        this.productCatalog.getCatalog();
        return this.productCatalog;
    }

    public void printCatalog() {
        HashMap<Integer, ProductInterface> catalog = this.productCatalog.getCatalog();
        ProductCatalogModel catalogModel = new ProductCatalogModel();
        catalog.forEach((id, product) -> {
            catalogModel.addProductModel(new ProductModel(product));
        });
        System.out.println("We can offer the following products:");
        System.out.println(catalogModel);
    }

    public void saveProductCatalog() {
        this.productRepository.saveProductCatalogToFile();
    }

}
