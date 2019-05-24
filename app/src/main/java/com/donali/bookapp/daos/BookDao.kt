package com.donali.bookapp.daos

import androidx.appcompat.widget.DialogTitle
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.donali.bookapp.entities.Book

@Dao
interface BookDao{

    @Query("select * from book where title = :title")
    fun getBookTitle(title: String): LiveData<Book>

    @Query("select * from book where isbn = :isbn")
    fun getBookisbn(isbn: String): LiveData<Book>


    @Query("select * from book")
    fun getAllBooks():LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: Book)

    @Query("update book set favorite = :favorite where title = :title")
    fun favorite(title: String,favorite: Boolean)

    @Query("delete from book")
    suspend fun deleteallbook()

}