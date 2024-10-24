/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2024-10-24
 * Author: XM
 */
package com.osxm.sb.springboot3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osxm.sb.springboot3.entity.Book;
import com.osxm.sb.springboot3.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 查询所有图书
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // 查询单个图书
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    // 保存单个图书
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    // 删除单个图书
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}