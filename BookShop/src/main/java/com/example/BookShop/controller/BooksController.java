package com.example.BookShop.controller;

import com.example.BookShop.entity.Book;
import com.example.BookShop.repository.BookRepository;
import com.example.BookShop.service.BookService;
import com.example.BookShop.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;


@Controller
public class BooksController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ModelAndView getAll() {
           // book.addAttribute("books" ,bookService.fetchBooksList());
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("books", bookService.fetchBooksList());

        return modelAndView;
    }
    @PostMapping("/book")
    public String createBook(@ModelAttribute @Valid  Book newBook, BindingResult result){
        if (result.hasErrors()) {
            return "redirect:add-book-form";
        }
        bookService.createBook(newBook);
        return "redirect:";
    }

    @GetMapping("/add-book-form")
    public ModelAndView addNewBook(){
        ModelAndView modelAndView = new ModelAndView("add-book-form");
       Book newBook = new Book();
       modelAndView.addObject("newbook",newBook);
        return modelAndView;
    }

    @GetMapping("book/{id}")
    public Book fetchBookById(@PathVariable("id") Long bookId) {
        return bookService.fetchBookById(bookId);
    }

    @GetMapping("delete-book")
    public String deleteBookById(@RequestParam("id") Long bookId) {
        bookService.deleteBookById(bookId);
        return "redirect:";
    }

    @GetMapping("update-book-form")
    public ModelAndView ShowUpdateForm(@RequestParam Long id){
        ModelAndView modelAndView = new ModelAndView("Update-form");
        Book book = new Book();
        book = bookService.fetchBookById(id);
        modelAndView.addObject("book",book);
        return modelAndView;
    }


    @PostMapping("updatebook")
    public String updateBook(@ModelAttribute @Valid Book book){
        bookService.createBook(book);
        return "redirect:";
    }

}
