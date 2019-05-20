package com.donali.bookapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.donali.bookapp.entities.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(app:Application):AndroidViewModel(app) {
    private val repo:BookRepository
    init {
        val bookDao = RoomDB.getInstance(app).bookDao()
        repo = BookRepository(bookDao)
    }

    fun getAllBooks():LiveData<List<Book>> = repo.getAll()

    fun insert(book: Book) = viewModelScope.launch(Dispatchers.IO){
        repo.insert(book)
    }
}