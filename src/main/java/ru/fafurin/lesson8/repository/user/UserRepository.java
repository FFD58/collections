package ru.fafurin.lesson8.repository.user;

import ru.fafurin.six.lesson8.entity.user.User;
import ru.fafurin.six.lesson8.entity.user.UserInterface;
import ru.fafurin.six.lesson8.service.FileService;

import java.util.HashMap;

public class UserRepository implements UserRepositoryInterface {

    private FileService fileManager;

    public final String FILENAME = "users.txt";
    public HashMap<String, UserInterface> users = new HashMap<>();

    public UserRepository(FileService fileManager) {
        this.fileManager = fileManager;
        this.users = getUsers();
    }

    public void registerUser(String name, String email, String password) {
        if (name != null && email != null && password != null) {
            User user = new User(email, password);
            if (!users.containsValue(user)) {
                users.put(user.getEmail(), user);
            }
        }
    }

    public void addUser(UserInterface user) {
        this.users.put(user.getEmail(), user);
    }

    public UserInterface getByEmail(String email) {
        UserInterface user = null;
        if (this.users.containsKey(email)) user = this.users.get(email);
        return user;
    }

    public HashMap<String, UserInterface> getUsers() {
        String content = this.fileManager.getStringFromFile(FILENAME);

        String[] strings = content.split(";");

        for (String str : strings) {
            if (str.contains("password")) {
                UserInterface user = this.getUserFromString(str);
                this.users.put(user.getEmail(), user);
            }
        }
        return this.users;
    }

    private UserInterface getUserFromString(String str) {
        String email = str.substring(0, str.indexOf("="));

        int passwordIndex = str.indexOf("password:");
        String password = str.substring(passwordIndex + "password:".length());

        return new User(email, password);
    }

    public void saveUsersToFile() {
        this.fileManager.writeStringToFile(String.valueOf(this.users), this.FILENAME);
    }
}
