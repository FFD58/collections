package ru.fafurin.lesson8.entity.user;

import ru.fafurin.six.lesson8.entity.cart.Cart;
import ru.fafurin.six.lesson8.entity.cart.CartInterface;

public class User implements UserInterface {
    private String email;
    private String password;

    private CartInterface cart = new Cart();

    private boolean loggedIn = false;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public CartInterface getCart() {
        return this.cart;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public String toString() {
        return String.format("password:%s;\n", this.password);
    }

}
