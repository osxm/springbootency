package com.osxm.sb.springboot3.it;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osxm.sb.springboot3.entity.Book;
import com.osxm.sb.springboot3.service.BookService;

@SpringBootTest
public class BookServiceIT {


    @Autowired
    private BookService bookService;
    
    @Test
    public void save(){
        Book book = new Book();
        book.setTitle("Spring");
        book.setAuthor("oscar");
        bookService.save(book);
    }
}
