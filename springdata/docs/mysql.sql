-- 创建数据库
create database osxmdb;

-- 使用数据库
use osxmdb;

-- 创建表
CREATE TABLE CITY
(
 id INT NOT NULL COMMENT '主键',
 name varchar(30) NOT NULL COMMENT '姓名',
 state varchar(30),
 PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 插入数据
INSERT INTO CITY(ID,NAME) VALUES(1,'Hefei') ;
INSERT INTO CITY(ID,NAME) VALUES(2,'AnQing') ;

