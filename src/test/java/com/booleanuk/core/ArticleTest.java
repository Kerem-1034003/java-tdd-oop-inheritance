package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArticleTest {
    @Test
    public void shouldCheckOutIfAvailable() {
        Author author = new Author("Kerem Yildiz", "Kerem@example.com", "www.kerem.com");
        Article article = new Article("JUnit Rocks", author);
        Assertions.assertEquals("item has been checked out", article.checkOut());
    }

    @Test
    public void shouldDeclineIfNotAvailableToCheckout() {
        Author author = new Author("Kerem Yildiz", "Kerem@example.com", "www.kerem.com");
        Article article = new Article("JUnit Rocks", author);  // <-- hier Author toevoegen!
        article.checkOut();

        Assertions.assertEquals("item is currently on loan", article.checkOut());
    }

    @Test
    public void shouldCheckInIfOnLoan() {
        Author author = new Author("Kerem Yildiz", "Kerem@example.com", "www.kerem.com");
        Article article = new Article("JUnit Rocks", author);  // <-- hier ook
        article.checkOut();

        Assertions.assertEquals("item has been checked in", article.checkIn());
    }

    @Test
    public void shouldDeclineCheckInIfNotOnLoan() {
        Author author = new Author("Kerem Yildiz", "Kerem@example.com", "www.kerem.com");
        Article article = new Article("JUnit Rocks", author);  // <-- hier ook

        Assertions.assertEquals("item is not currently on loan", article.checkIn());
    }
}

