// src/main/kotlin/com/example/demo/controller/BookController.kt
package com.example.demo.controller

import com.example.demo.model.Book
import com.example.demo.model.MinBook
import com.example.demo.services.BookService
import org.springframework.data.mongodb.core.query.Query
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/api/books")
class BookController(private val bookService: BookService) {

    @GetMapping
    fun getAllBooks(): List<Book> = bookService.getAllBooks()

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: String): Book? = bookService.getBookById(id)

    @GetMapping("/author/{author}")
    fun searchByAuthor(@PathVariable author: String ): List<Book>? = bookService.getBookByAuthor(author)

    @GetMapping("/title/{title}")
    fun getBookByTitle(@PathVariable title: String ): List<Book>? = bookService.getBookByTitle(title)

    @GetMapping("/filter/{title}/{author}")
    fun findBooksByAuthorAndTitle(@PathVariable author: String, @PathVariable title: String ): List<Book>? = bookService.findBooksByAuthorAndTitle(author, title)

    @GetMapping("/filter/{start},{end}")
    fun findBooksByTitleStartAndEndLetter(start: Char, end: Char) : List<Book>? = bookService.findBooksByTitleStartAndEndLetter(start, end)

    @PostMapping
    fun saveBook(@RequestBody book: Book): Book = bookService.saveBook(book)

    @PutMapping("/{id}")
    fun updateBook(@PathVariable id: String, @RequestBody book: Book): Book =
        bookService.updateBook(id, book)

    @GetMapping("/select")
    fun findTitleAndPrice(): List<MinBook>? = bookService.findTitleAndPrice()

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: String) = bookService.deleteBook(id)
}
