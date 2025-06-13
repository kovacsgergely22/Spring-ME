package org.me.bookstore.controller;

import jakarta.annotation.PostConstruct;
import org.me.bookstore.model.Book;
import org.me.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @GetMapping("/title/{title}")
    public List<Book> getBookByTitle(@PathVariable String title){
        return bookService.getBookByTitle(title);
    }

    @GetMapping("/author/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author){
        return bookService.getBookByAuthor(author);
    }

    @GetMapping("/publisher/{publisher}")
    public List<Book> getBookByPublisher(@PathVariable String publisher){
        return bookService.getBookByPublisher(publisher);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book){
        book.setId(id);
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

    @PostConstruct
    public void init(){
        Book book = new Book();
        book.setTitle("Computer Networks");
        book.setAuthor("Tanenbaum - Wetherall");
        book.setPublisher("Pearson");
        book.setPrice(5100);
        bookService.saveBook(book);
        Book book2 = new Book();
        book2.setTitle("Operating Systems");
        book2.setAuthor("Tanenbaum");
        book2.setPublisher("Pearson");
        book2.setPrice(4500);
        bookService.saveBook(book2);
        Book book3 = new Book();
        book3.setTitle("Computer Architecture");
        book3.setAuthor("Tanenbaum");
        book3.setPublisher("Pearson");
        book3.setPrice(4000);
        bookService.saveBook(book3);
        Book book4 = new Book();
        book4.setTitle("Build Your API with Spring");
        book4.setAuthor("Baeldung");
        book4.setPublisher("Baeldung");
        book4.setPrice(1000);
        bookService.saveBook(book4);
        Book book5 = new Book();
        book5.setTitle("Full Stack Development with Spring Boot 3 and React");
        book5.setAuthor("Juha Hinkula");
        book5.setPublisher("Packt");
        book5.setPrice(1000);
        bookService.saveBook(book5);
    }
}
