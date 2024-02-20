package ru.fafurin.lesson8;

import ru.fafurin.six.lesson8.entity.product.ProductCatalog;
import ru.fafurin.six.lesson8.entity.product.ProductCatalogInterface;
import ru.fafurin.six.lesson8.repository.product.ProductRepository;
import ru.fafurin.six.lesson8.repository.user.UserRepository;
import ru.fafurin.six.lesson8.service.CartService;
import ru.fafurin.six.lesson8.service.FileService;
import ru.fafurin.six.lesson8.service.ProductService;
import ru.fafurin.six.lesson8.service.UserService;

// Урок 13. SortedMap / NavigableMap / TreeMap
public class Main {
    public static void main(String[] args) {
// Вам предстоит сделать онлайн магазин, без графического интерфейса,
// обладающего следующими функциями:
// ●  Каталог товаров
// ●  Авторизация почта и пароль (данные возможно хранить в простом незашифрованном виде)
// ●  Реализовать вывод каталога
// ●  Добавление товара по ID
// ●  Возможность очистки корзины

        // Каталог товаров и список зарегистрированных пользователей считываются из файлов
        // (после совершения покупок файлы обновляются)
        // Регистрация и аутентификация сделаны максимально просто (безопасность на нуле)
        // Количество добавленных в корзину товаров вычитается из товаров в каталоге
        // После очистки корзины все товары из корзины возвращаются в каталог

        FileService fileManager = new FileService();
        ProductRepository productRepository = new ProductRepository(fileManager);
        ProductCatalogInterface productCatalog = new ProductCatalog();
        ProductService productService = new ProductService(productCatalog, productRepository);
        Shop shop = new Shop(
                new UserRepository(fileManager),
                new UserService(new UserRepository(fileManager)),
                new ProductService(productCatalog, productRepository),
                new CartService(productService));
        shop.run();
    }
}
