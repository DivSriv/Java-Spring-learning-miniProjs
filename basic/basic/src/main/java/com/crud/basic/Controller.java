package com.crud.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private BookJpaRepository bookJpaRepository;


    @GetMapping("/book")
    public Book getBookTitle(@Valid @RequestBody Book book) throws BookExceptionHandler{

        Book bookObj = new Book();
        bookObj.setTitle(book.getTitle());
        if (book.getTitle().equals("A")) {
            bookObj.setTitle("R100");
        } else if (book.getTitle().equals("B")) {
            bookObj.setTitle("G200");
        } else {
            bookObj.setTitle("B300");
        }
        return bookObj;
    }
    @PostMapping("/book")
    public void bookTitlePost(@Valid @RequestBody Book book) throws BookExceptionHandler{

        System.out.println("Post ho gya");
    }

    @GetMapping("/books")
    public List<Book> retrieveAllBooks(){
        return bookJpaRepository.findAll();
    }


    @PostMapping("/books")
    public Book addNewBook(@RequestBody Book newBook){
        Book book = bookJpaRepository.save(newBook);
        return book;
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable int id){
        System.out.println("Request for findBookById had id as " + id);
        return bookJpaRepository.findById(id);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id,
                                               @RequestBody Book bookDetails) {

        Book book = bookJpaRepository.findById(id).orElse(null);

        book.setTitle(bookDetails.getTitle());
        book.setAuthorName(bookDetails.getAuthorName());
        book.setReleasedYear(bookDetails.getReleasedYear());
        final Book updatedBook = bookJpaRepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable int id){
        Book book = bookJpaRepository.findById(id).orElse(null);
        bookJpaRepository.delete(book);
        return "Deleted Book with id "+id;
    }
}
