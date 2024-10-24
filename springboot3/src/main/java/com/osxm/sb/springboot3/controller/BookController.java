package com.osxm.sb.springboot3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.osxm.sb.springboot3.entity.Book;
import com.osxm.sb.springboot3.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 获取所有图书
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    // 根据ID获取图书
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    // 创建图书
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    // 删除图书
    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}