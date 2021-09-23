package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
        // ваш код
        return null;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) { // если в параметре product лежит объект класса Book
            Smartphone smartphone = (Smartphone) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (smartphone.getDeveloper().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
