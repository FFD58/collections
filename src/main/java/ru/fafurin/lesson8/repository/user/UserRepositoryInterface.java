package ru.fafurin.lesson8.repository.user;

import ru.fafurin.six.lesson8.entity.user.UserInterface;
import ru.fafurin.six.lesson8.repository.Repository;

import java.util.HashMap;

public interface UserRepositoryInterface extends Repository {
    HashMap<String, UserInterface> getUsers();
    UserInterface getByEmail(String email);

    void addUser(UserInterface user);
    void saveUsersToFile();
}
