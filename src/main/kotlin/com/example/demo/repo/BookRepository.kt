package com.example.demo.repo

import com.example.demo.model.Book
import com.example.demo.model.MinBook
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface BookRepository : MongoRepository<Book, String>{
    fun getBookByAuthor(author: String): List<Book>?

    fun getBookByTitle(title: String): List<Book>?

    @Query("{'title': { \$regex: '^${'$'}start.*${'$'}end$', \$options: 'i' }}")
    fun findBooksByTitleStartAndEndLetter(start: Char, end: Char): List<Book>?

    @Query("{'author': ?0, 'title': ?1}")
    fun findBooksByAuthorAndTitle(author: String, title: String): List<Book>?

    fun findTitleAndPrice() : List<MinBook>?

}