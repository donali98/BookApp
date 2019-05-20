package com.donali.bookapp

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.donali.bookapp.daos.BookDao
import com.donali.bookapp.entities.Book

class BookRepository(private val bookDao: BookDao) {

    fun getAll():LiveData<List<Book>> = bookDao.getAllBooks()


    @WorkerThread
    suspend fun insert(book: Book) = bookDao.insert(book)
}