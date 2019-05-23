package com.donali.bookapp

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.donali.bookapp.daos.BookDao
import com.donali.bookapp.entities.Book

class BookRepository(private val bookDao: BookDao) {

    @WorkerThread
    //Funcion para insertar datos
    suspend fun insert(book: Book) = bookDao.insert(book)

    //Funcion para obtener todos resultados
    fun getAll():LiveData<List<Book>> = bookDao.getAllBooks()

}