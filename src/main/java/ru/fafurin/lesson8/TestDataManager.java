package ru.fafurin.lesson8;

import ru.fafurin.six.lesson8.entity.product.ProductCatalog;
import ru.fafurin.six.lesson8.entity.user.User;
import ru.fafurin.six.lesson8.entity.user.UserInterface;
import ru.fafurin.six.lesson8.repository.product.ProductRepository;
import ru.fafurin.six.lesson8.repository.user.UserRepository;
import ru.fafurin.six.lesson8.service.FileService;

public class TestDataManager {
    public static void main(String[] args) {
        FileService fileManager = new FileService();
        ProductRepository productRepository = new ProductRepository(fileManager);
        UserRepository userRepository = new UserRepository(fileManager);
        ProductCatalog catalog = new ProductCatalog();

//        ProductInterface product1 = new Product("Bread", 35, 45);
//        ProductInterface product2 = new Product("Hot-dog", 125, 50);
//        ProductInterface product3 = new Product("Bun", 43, 67);
//
//        catalog.putProductToCatalog(product1);
//        catalog.putProductToCatalog(product2);
//        catalog.putProductToCatalog(product3);

        UserInterface user1 = new User("email@email.ru", "qwerty");
        UserInterface user2 = new User( "another@email.ru", "1");

        userRepository.addUser(user1);
        userRepository.addUser(user2);
//
        System.out.println(userRepository.users);
//
        fileManager.writeStringToFile(userRepository.users.toString(), userRepository.FILENAME);

    }
}
