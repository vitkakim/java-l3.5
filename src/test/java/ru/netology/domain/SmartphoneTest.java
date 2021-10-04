package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Product smartPhone = new Smartphone(3, "Redmi 9", 350, "Xiaomi");;

    @Test
    void shouldFindByName() {
        boolean actual = smartPhone.matches("Redmi");
        assertTrue(actual);
    }

    @Test
    void shouldFindByWrongName() {
        boolean actual = smartPhone.matches("Iphone");
        assertFalse(actual);
    }

    @Test
    void shouldFindByDeveloper() {
        boolean actual = smartPhone.matches("Xiaomi");
        assertTrue(actual);
    }

    @Test
    void shouldFindByWrongDeveloper() {
        boolean actual = smartPhone.matches("Apple");
        assertFalse(actual);
    }


}