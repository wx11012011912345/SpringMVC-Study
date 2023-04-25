package com.wang.dao;

import com.wang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    //只有一个基本类型的形参时，可加可不加@Param，最好加上
    int deleteBookById(int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询，返回一个Book
    Books queryBookById(@Param("bookID") int id);

    //根据书名查询
    Books queryBookByName(@Param("bookName") String name);

    //查询全部Book，返回list集合
    List<Books> queryAllBook();

}
