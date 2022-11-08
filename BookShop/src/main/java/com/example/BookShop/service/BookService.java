package com.example.BookShop.service;

import com.example.BookShop.entity.Book;
import java.util.*;

public interface BookService {
    Book createBook(Book book);

    Iterable<Book> fetchBooksList();

    Book fetchBookById(Long bookId);

    void deleteBookById(Long bookId);

    Book updateBookInfo(Long bookId, Book newBookInfo);
}
