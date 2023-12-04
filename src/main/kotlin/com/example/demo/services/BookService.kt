// src/main/kotlin/com/example/demo/service/BookService.kt
package com.example.demo.services

import com.example.demo.model.Book
import com.example.demo.model.MinBook
import com.example.demo.repo.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {

    fun getAllBooks(): List<Book> = bookRepository.findAll()

    fun getBookById(id: String): Book? = bookRepository.findById(id).orElse(null)

    fun saveBook(book: Book): Book = bookRepository.save(book)

    fun findBooksByTitleStartAndEndLetter(start: Char, end:Char) : List<Book>? = bookRepository.findBooksByTitleStartAndEndLetter(start, end)

    fun getBookByAuthor (author: String): List<Book>? = bookRepository.getBookByAuthor(author)

    fun getBookByTitle (title: String): List<Book>? = bookRepository.getBookByTitle(title)

    fun findBooksByAuthorAndTitle(author: String, title: String) : List<Book>? = bookRepository.findBooksByAuthorAndTitle(author, title)

    fun updateBook(id: String, book: Book): Book {
        require(id == book.id) { "ID mismatch" }
        return bookRepository.save(book)
    }

    fun findTitleAndPrice() : List<MinBook>?{
        val books = bookRepository.findAll()
        return books.map{ MinBook(it.title,it.price) }
    }

    fun deleteBook(id: String) {
        bookRepository.deleteById(id)
    }
}
