package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Непобедимое солнце", 750, "Пелевин");
        Book book2 = new Book(2, "Музыка мозга", 500, "Прен");
        Book book3 = new Book(3, "Смертные машины", 500, "Рив");
        Smartphone phone1 = new Smartphone(4, "Nova 5T", 30000,"Huawei");
        Smartphone phone2 = new Smartphone(5, "Mark 2", 70000, "Sony");
        Smartphone phone3 = new Smartphone(6, "Redmi Note 9", 9000, "Xiaomi");




    @Test
    void shouldFindBookByNameIfExists() {
        manager = new ProductManager(repository);
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);


        String textToFind = "Непобедимое солнце";
        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindBookByNameIfNoExists() {
        String textToFind = "Собачье сердце";
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindBookByAuthorIfExists() {
        manager = new ProductManager(repository);
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);

        String textToFind = "Пелевин";
        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindBookByAuthorIfNoExists() {
        String textToFind = "Булгаков";
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmartphoneByNameIfExists() {
        manager = new ProductManager(repository);

        manager.addProduct(phone1);
        manager.addProduct(phone2);
        manager.addProduct(phone3);

        String textToFind = "Mark 2";
        Product[] expected = new Product[]{phone2};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindSmartphoneByNameIfNoExists() {
        String textToFind = "Iphone";
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmartphoneByBrandIfExists() {
        manager = new ProductManager(repository);

        manager.addProduct(phone1);
        manager.addProduct(phone2);
        manager.addProduct(phone3);

        String textToFind = "Sony";
        Product[] expected = new Product[]{phone2};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindSmartphoneByBrandIfNoExists() {
        String textToFind = "Apple";
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }
}


