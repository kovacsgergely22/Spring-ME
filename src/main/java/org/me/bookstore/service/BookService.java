package org.me.bookstore.service;

import org.me.bookstore.model.Book;
import org.me.bookstore.persist.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> getBookByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> getBookByPublisher(String publisher) {
        return bookRepository.findByPublisher(publisher);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
