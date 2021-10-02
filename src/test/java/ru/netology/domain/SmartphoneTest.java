package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Product smartPhone = new Smartphone(3, "Redmi 9", 350, "Xiaomi");;

    @Test
    void shouldFindByName() {
        boolean actual = smartPhone.matches("Redmi");
        assertEquals(true, actual);
    }

    @Test
    void shouldFindByWrongName() {
        boolean actual = smartPhone.matches("Iphone");
        assertEquals(false, actual);
    }

    @Test
    void shouldFindByDeveloper() {
        boolean actual = smartPhone.matches("Xiaomi");
        assertEquals(true, actual);
    }

    @Test
    void shouldFindByWrongDeveloper() {
        boolean actual = smartPhone.matches("Apple");
        assertEquals(false, actual);
    }


}