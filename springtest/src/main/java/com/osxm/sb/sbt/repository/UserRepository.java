package com.osxm.sb.sbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osxm.sb.sbt.model.User;

public interface UserRepository extends JpaRepository<User, Long> {  
    // 这里可以定义一些特定的查询方法，但在这个例子中我们使用JpaRepository的默认方法  
}