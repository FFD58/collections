package ru.fafurin.lesson8.service;

import ru.fafurin.six.lesson8.entity.cart.CartInterface;
import ru.fafurin.six.lesson8.entity.product.Product;
import ru.fafurin.six.lesson8.entity.product.ProductInterface;
import ru.fafurin.six.lesson8.exception.NotEnoughProductsCountException;
import ru.fafurin.six.lesson8.exception.ProductNotFoundException;
import ru.fafurin.six.lesson8.model.ProductCatalogModel;
import ru.fafurin.six.lesson8.model.ProductModel;

import java.util.HashMap;

public class CartService {
    private ProductService productService;

    public CartService(ProductService productService) {
        this.productService = productService;
    }
    public void addProductToCart(CartInterface cart, int productId, int productsCount) {
        if (this.productService.getProductCatalog().getCatalog().containsKey(productId)) {
            ProductInterface selectedProduct = this.productService.getProductCatalog().getCatalog().get(productId);
            if (selectedProduct.getCount() >= productsCount) {
                ProductInterface product = new Product(selectedProduct.getTitle(), selectedProduct.getPrice(), productsCount);
                selectedProduct.setCount(selectedProduct.getCount() - productsCount);
                product.setId(productId);
                cart.addProduct(product);
            } else throw new NotEnoughProductsCountException(productId);
        } else throw new ProductNotFoundException(productId);
    }

    public int getTotal(CartInterface cart) {
        int total = 0;
        for (ProductInterface product : cart.getCart().values()) {
            total += product.getPrice() * product.getCount();
        }
        return total;
    }

    public void clearCart(CartInterface cart) {
        HashMap<Integer, ProductInterface> currentCart = cart.getCart();
        HashMap<Integer, ProductInterface> catalogProduct = this.productService.getProductCatalog().getCatalog();
        currentCart.forEach((id, product) -> {
            int cartProductId = product.getId();
            int cartProductCount = product.getCount();
            if (catalogProduct.containsKey(cartProductId)) {
                catalogProduct.get(cartProductId).setCount(catalogProduct.get(cartProductId).getCount() + cartProductCount);
            }
        });
        cart.getCart().clear();
        System.out.println("catalog: " + catalogProduct);
    }

    public void printCart(CartInterface cart) {
        HashMap<Integer, ProductInterface> currentCart = cart.getCart();;
        ProductCatalogModel cartModel = new ProductCatalogModel();
        currentCart.forEach((id, product) -> {
            cartModel.addProductModel(new ProductModel(product));
        });
        System.out.println("Shopping cart contents:");
        System.out.println(cartModel);
    }
}
