package com.osxm.sb.springboot3.repository;

  

import org.springframework.data.jpa.repository.JpaRepository;

import com.osxm.sb.springboot3.entity.Book;  
  
public interface BookRepository extends JpaRepository<Book, Long> {  
    // 可以根据需要添加自定义查询方法  
}