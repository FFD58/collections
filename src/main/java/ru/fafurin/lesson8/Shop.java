package ru.fafurin.lesson8;

import ru.fafurin.six.lesson8.entity.cart.CartInterface;
import ru.fafurin.six.lesson8.entity.user.UserInterface;
import ru.fafurin.six.lesson8.exception.NotEnoughProductsCountException;
import ru.fafurin.six.lesson8.exception.ProductNotFoundException;
import ru.fafurin.six.lesson8.repository.user.UserRepository;
import ru.fafurin.six.lesson8.service.CartService;
import ru.fafurin.six.lesson8.service.ProductService;
import ru.fafurin.six.lesson8.service.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop {
    private UserInterface currentUser;
    private CartInterface currentUserCart;
    private final UserRepository repository;
    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService;
    private final CartService cartService;
    private final ProductService productService;

    public Shop(
            UserRepository repository,
            UserService userService,
            ProductService productService,
            CartService cartService) {
        this.repository = repository;
        this.userService = userService;
        this.productService = productService;
        this.cartService = cartService;
    }
    public void run() {
        this.getCustomer();
        boolean shopping = true;
        while (shopping) {
            this.shopping();
            System.out.println("Buy something else, clear cart or place an order?");
            System.out.println("Please, enter yes - to continue shopping,");
            System.out.println("clear - to remove all products from your cart,");
            System.out.println("no - to proceed to order payment...");
            String answer = scanner.next();
            if (answer.equals("no")) {
                if (this.cartService.getTotal(this.currentUserCart) > 0) {
                    this.cartService.printCart(this.currentUserCart);
                    System.out.println("Total: " + this.cartService.getTotal(this.currentUserCart));
                    shopping = false;
                }
            } else if (answer.equals("clear")) {
                this.cartService.clearCart(this.currentUserCart);
            } else if (answer.equals("yes")) shopping = true;
        }
    }

    private void getCustomer() {
        System.out.println("Welcome to Bakery-online!");
        System.out.println("Enter email:");
        String email = scanner.next();
        System.out.println();
        System.out.println("Enter password:");
        String password = scanner.next();

        if (repository.getByEmail(email) != null) {
            this.currentUser = userService.logIn(email, password);
        } else this.currentUser = userService.register(email, password);

        this.currentUserCart = this.currentUser.getCart();
    }

    private void shopping() {
        this.productService.printCatalog();
        System.out.println("What would you like to buy on this wonderful day?");
        System.out.println("Enter an id and a count of product...");
        try {
            int id = scanner.nextInt();
            int count = scanner.nextInt();
            this.cartService.addProductToCart(this.currentUserCart, id, count);
            this.cartService.printCart(this.currentUserCart);
            this.saveResults();
        } catch (InputMismatchException | NotEnoughProductsCountException | ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void saveResults() {
        this.userService.saveUsers();
        this.productService.saveProductCatalog();
    }
}
