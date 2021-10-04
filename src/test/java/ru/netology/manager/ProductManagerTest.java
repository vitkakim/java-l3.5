package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    Product book1 = new Book(1, "Harry Potter and the Chamber of Secrets", 350, "J.K. Rowling");
    Product book2 = new Book(2, "The Little Prince", 350, "Antoine de Saint-Exupery");

    Product smartPhone1 = new Smartphone(3, "Redmi 9", 350, "Xiaomi");
    Product smartPhone2 = new Smartphone(4, "Iphone X", 350, "Apple");

    Product product1 = new Product(5, "Harry Potter and the Half-Blood Prince", 350);
    Product product2 = new Product(6, "Iphone SE", 350);

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartPhone1);
        manager.add(smartPhone2);
        manager.add(product1);
        manager.add(product2);
    }

    @Test
    void shouldAddProduct() {
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1, book2, smartPhone1, smartPhone2, product1, product2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameSmartphone() {
        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = new Product[]{smartPhone2, product2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByDeveloper() {
        Product[] actual = manager.searchBy("Xiaomi");
        Product[] expected = new Product[]{smartPhone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameBook() {
        Product[] actual = manager.searchBy("Harry Potter");
        Product[] expected = new Product[]{book1, product1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthor() {
        Product[] actual = manager.searchBy("Antoine");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNotExistAuthor() {
        Product[] actual = manager.searchBy("Достоевский");
        Product[] expected = new Product[] {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchById() {
        Product actual = repository.findById(2);
        Product expected = book2;
        assertEquals(expected, actual);
    }

    @Test
    void shouldSearchByNotExistId() {
        Product actual = repository.findById(10);
        Product expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{
                book1,
                smartPhone1, smartPhone2,
                product1, product2};

        assertArrayEquals(expected, actual);
    }

    @Test
    @Disabled
    void shouldRemoveByIdNotExist() {
        repository.removeById(10);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{
                book1, book2,
                smartPhone1, smartPhone2,
                product1, product2};

        assertArrayEquals(expected, actual);
    }
}