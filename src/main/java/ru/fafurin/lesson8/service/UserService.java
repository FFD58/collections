package ru.fafurin.lesson8.service;

import ru.fafurin.six.lesson8.entity.user.User;
import ru.fafurin.six.lesson8.entity.user.UserInterface;
import ru.fafurin.six.lesson8.exception.InvalidInputDataException;
import ru.fafurin.six.lesson8.repository.user.UserRepositoryInterface;

import java.util.HashMap;

public class UserService {
    HashMap<String, UserInterface> users;

    UserRepositoryInterface userRepository;

    public UserService(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
        this.users = userRepository.getUsers();
    }

    public UserInterface logIn(String email, String password) {
        UserInterface user;
        if (email != null && password != null) {
            if (this.users.containsKey(email)) {
                user = this.users.get(email);
                if (user.getPassword().equals(password)) user.setLoggedIn(true);
                System.out.println("You have successfully logged in!");
                return user;
            }
        } throw new InvalidInputDataException();
    }

    public UserInterface register(String email, String password) {
        if (email != null && password != null) {
            if (!this.users.containsKey(email)) {
                UserInterface user = new User(email, password);
                this.userRepository.addUser(user);
                user.setLoggedIn(true);
                System.out.println("You have successfully registered!");
                return user;
            }
        } throw new InvalidInputDataException();
    }

    public void saveUsers() {
        this.userRepository.saveUsersToFile();
    }

}

