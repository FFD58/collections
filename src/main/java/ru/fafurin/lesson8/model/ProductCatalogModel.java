package ru.fafurin.lesson8.model;

import java.util.ArrayList;

public class ProductCatalogModel {

    ArrayList<ProductModel> productModelCatalog = new ArrayList<>();

    public void addProductModel(ProductModel productModel) {
        this.productModelCatalog.add(productModel);
    }

    @Override
    public String toString() {
        return (String.valueOf(productModelCatalog).
                replace("[", "").
                replace("]", "").
                replace(",", "").
                replace("\n ", "\n"));
    }
}
