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
    Product book1 = new Book("Harry Potter", "J.K. Rowling");
    Product book2 = new Book("The Little Prince", "Antoine de Saint-Exupery");
    Product book3 = new Book("Harry Potter", "J.K. Rowling");
    Product book4 = new Book("The Little Prince", "Antoine de Saint-Exupery");

    Product smartPhone1 = new Smartphone("Samsung A52", "Samsung");
    Product smartPhone2 = new Smartphone("Iphone X", "Apple");
    Product smartPhone3 = new Smartphone("Samsung A52", "Samsung");
    Product smartPhone4 = new Smartphone("Iphone X", "Apple");


    Product product1 = new Product(1, "Harry Potter", 350);
    Product product2 = new Product(2, "Iphone X", 70000);
    Product product3 = new Product(3, "Harry Potter", 350);
    Product product4 = new Product(4, "Iphone X", 70000);


    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        manager.add(smartPhone1);
        manager.add(smartPhone2);
        manager.add(smartPhone3);
        manager.add(smartPhone4);

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
    }

    @Test
    void shouldAddProduct() {
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{
                book1, book2, book3, book4,
                smartPhone1, smartPhone2, smartPhone3, smartPhone4,
                product1, product2, product3, product4};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByText() {
        assertArrayEquals(new Product[]{smartPhone2, smartPhone4}, manager.searchBy("Iphone X"));
        assertArrayEquals(new Product[]{smartPhone2, smartPhone4}, manager.searchBy("Apple"));

        assertArrayEquals(new Product[]{book1, book3}, manager.searchBy("Harry Potter"));
        assertArrayEquals(new Product[]{book2, book4}, manager.searchBy("Antoine de Saint-Exupery"));
    }

    @Test
    void shouldSearchById() {
        assertEquals(product3, repository.findById(3));
        assertEquals(null, repository.findById(7));
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{
                book1, book2, book3, book4,
                smartPhone1, smartPhone2, smartPhone3, smartPhone4,
                product1, product3, product4};

        assertArrayEquals(expected, actual);
    }

    @Test
    @Disabled
    void shouldRemoveByIdNotExist() {
        repository.removeById(6);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{
                book1, book2, book3, book4,
                smartPhone1, smartPhone2, smartPhone3, smartPhone4,
                product1, product2, product3, product4};

        assertArrayEquals(expected, actual);
    }
}