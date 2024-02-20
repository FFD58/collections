package ru.fafurin.lesson8.entity.user;

import ru.fafurin.six.lesson8.entity.Entity;
import ru.fafurin.six.lesson8.entity.cart.CartInterface;

public interface UserInterface extends Entity {
    String getEmail();
    String getPassword();
    void setLoggedIn(boolean loggedIn);
    CartInterface getCart();
}
