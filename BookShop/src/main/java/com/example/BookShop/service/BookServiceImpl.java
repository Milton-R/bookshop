package com.example.BookShop.service;

import com.example.BookShop.entity.Book;
import com.example.BookShop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ObjectInputStream;
import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Iterable<Book> fetchBooksList() {
        return bookRepository.findAll();
    }

    @Override
    public Book fetchBookById(Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book updateBookInfo(Long bookId, Book newBookInfo) {
        Book updatedBookInfo = bookRepository.findById(bookId).get();
        if(Objects.nonNull(newBookInfo.getTitle())
                && !"".equalsIgnoreCase(newBookInfo.getTitle())){
            updatedBookInfo.setTitle(newBookInfo.getTitle());
        }
        return bookRepository.save(updatedBookInfo);
    }
}
