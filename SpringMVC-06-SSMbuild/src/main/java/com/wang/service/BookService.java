package com.wang.service;

import com.wang.pojo.Books;

import java.util.List;

public interface BookService {
    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    int deleteBookById(int id);

    //更新Book
    int updateBook(Books book);

    //根据id查询，返回一个Book
    Books queryBookById(int id);

    Books queryBookByName(String bookName);

    //查询全部Book，返回List集合
    List<Books> queryAllBook();
}
