package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    @Test
    public void shouldAddAndCheckOutBook() {
        Author author = new Author("John Doe", "johndoe@email.com", "www.johndoe.com");
        Book book = new Book("JUnit in Action", author);

        library.addToStock(book);

        String result = library.checkOutItem("JUnit in Action");
        Assertions.assertEquals("item has been checked out", result);
    }

    @Test
    public void shouldDeclineIfBookNotAvailable() {
        Author author = new Author("John Doe", "johndoe@email.com", "www.johndoe.com");
        Book book = new Book("JUnit in Action", author);
        library.addToStock(book);
        library.checkOutItem("JUnit in Action");

        String result = library.checkOutItem("JUnit in Action");
        Assertions.assertEquals("item is currently on loan", result);
    }

    @Test
    public void shouldCheckInBook() {
        Author author = new Author("John Doe", "johndoe@email.com", "www.johndoe.com");
        Book book = new Book("JUnit in Action", author);
        library.addToStock(book);
        library.checkOutItem("JUnit in Action");

        String result = library.checkInItem("JUnit in Action");
        Assertions.assertEquals("item has been checked in", result);
    }

    @Test
    public void shouldNotAllowNewspaperCheckOut() {
        Newspaper paper = new Newspaper("The Daily Java");
        library.addToStock(paper);

        String result = library.checkOutItem("The Daily Java");
        Assertions.assertEquals("newspapers are not available for loan", result);
    }

    @Test
    public void shouldNotAllowNewspaperCheckIn() {
        Newspaper paper = new Newspaper("The Daily Java");
        library.addToStock(paper);

        String result = library.checkInItem("The Daily Java");
        Assertions.assertEquals("newspapers are not available for loan", result);
    }
}
