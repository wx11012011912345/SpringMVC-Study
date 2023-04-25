package com.wang.controller;

import com.wang.pojo.Books;
import com.wang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    //面向接口编程
    private BookService bookService;

    //查询全部书籍，并且返回到一个书籍显示页面
    //http://localhost:8080/SpringMVC_06_SSMbuild/book/allbooks
    @RequestMapping("/AllBooks")
    public String ListAllBooks(Model model){
        List<Books> books=bookService.queryAllBook();

        model.addAttribute("books",books);
        return "allBooks";//转发给allBooks.jsp
    }

    //http://localhost:8080/SpringMVC_06_SSMbuild/book/toAddBook
    @RequestMapping("/toAddBook")
    //跳转到增加书籍页面
    public String toAddBook(){
        return "addBook";//转发给addBook.jsp
    }

    @RequestMapping("/AddBook")
    public String addBook(Books book){
        System.out.println("addBook=>"+book);
        bookService.addBook(book);
//        return "redirect:/book/AllBooks";//也可以使用allBooks,前面不加/是相对路径，相对于http://localhost:8080/SpringMVC_06_SSMbuild/book/addBook
        return "redirect:AllBooks";//重定向到另一个handler方法(servlet)
                                   //同一个控制器下可以省略/book/
    }

    //跳转到更新书籍信息的页面
    //http://localhost:8080/SpringMVC_06_SSMbuild/book/toUpdateBook?id=1
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBook",books);
        return "updateBook";//转发给updateBook.jsp
    }

    @RequestMapping("/UpdateBook")
    public String updateBook(Books book){
        System.out.println("updateBook=>"+book);
        bookService.updateBook(book);
        return "redirect:AllBooks";//重定向到另一个handler方法(servlet)
                                   //同一个控制器下可以省略/book/
    }

    //删除书籍
    @RequestMapping("/DeleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        System.out.println("被删除书籍的id=>"+id);
        bookService.deleteBookById(id);
//        return "redirect:/book/AllBooks";//重定向到另一个handler方法(servlet)
        return "redirect:../AllBooks";//对于restful风格，若要使用相对路径不能为redirect:AllBooks,此时url为：http://localhost:8080/SpringMVC_06_SSMbuild/book/DeleteBook/AllBooks
    }

    //查询书籍
    @RequestMapping("/QueryBook")
    public String queryBook(String queryBookName,Model model){
        Books book = bookService.queryBookByName(queryBookName);
        System.out.println("查询的书籍："+book);
        List<Books> list = new ArrayList<>();
        list.add(book);

        if(book==null){
            list=bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }

        System.out.println(list);
        model.addAttribute("books",list);//注意这里的属性名要与allBooks.jsp中forEach标签的items="${books}"一致
        return "allBooks";//转发给allBooks.jsp（复用allBooks.jsp页面，不需要再写一个确认样Book.jsp）
    }


}
