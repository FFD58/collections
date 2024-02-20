package ru.fafurin.lesson8.repository.product;

import ru.fafurin.six.lesson8.entity.product.Product;
import ru.fafurin.six.lesson8.entity.product.ProductInterface;
import ru.fafurin.six.lesson8.exception.ProductNotFoundException;
import ru.fafurin.six.lesson8.service.FileService;

import java.util.HashMap;

public class ProductRepository implements ProductRepositoryInterface {

    private HashMap<Integer, ProductInterface> products = new HashMap<>();
    public final String FILENAME = "catalog.txt";
    private FileService fileManager;

    public ProductRepository(FileService fileManager) {
        this.fileManager = fileManager;
    }

    public ProductInterface getById(int id) {
        ProductInterface product = null;
        if (this.products.containsKey(id)) product = this.products.get(id);
        if (product == null) throw new ProductNotFoundException(id);
        return product;
    }

    public HashMap<Integer, ProductInterface> getProducts() {
        String content = this.fileManager.getStringFromFile(FILENAME);
        String[] strings = content.split(";");
        for (String str : strings) {
            if (str.contains("price")) {
                ProductInterface product = this.getProductFromString(str);
                this.products.put(product.getId(), product);
            }
        }
        return this.products;
    }

    private ProductInterface getProductFromString(String str) {
        String id = str.substring(0, str.indexOf("="));

        int titleIndex = str.indexOf("title:");
        String title = str.substring(titleIndex + "title:".length(), str.indexOf(" ", titleIndex));

        int priceIndex = str.indexOf("price:");
        String price = str.substring(priceIndex + "price:".length(), str.indexOf(" ", priceIndex));

        int countIndex = str.indexOf("count:");
        String count = str.substring(countIndex + "count:".length());

        Product product = new Product(title, Integer.parseInt(price), Integer.parseInt(count));
        product.setId(Integer.parseInt(id));
        return product;
    }

    public void saveProductCatalogToFile() {
        this.fileManager.writeStringToFile(String.valueOf(this.products), this.FILENAME);
    }
}
