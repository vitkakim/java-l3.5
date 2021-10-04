package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Product book = new Book(1, "Harry Potter and the Chamber of Secrets", 350, "J.K. Rowling");

    @Test
    void shouldFindByName() {
        boolean actual = book.matches("Harry");
        assertTrue(actual);
    }

    @Test
    void shouldFindByWrongName() {
        boolean actual = book.matches("Prince");
        assertFalse(actual);
    }

    @Test
    void shouldFindByAuthor() {
        boolean actual = book.matches("Rowling");
        assertTrue(actual);
    }

    @Test
    void shouldFindByWrongAuthor() {
        boolean actual = book.matches("Antoine");
        assertFalse(actual);
    }

}