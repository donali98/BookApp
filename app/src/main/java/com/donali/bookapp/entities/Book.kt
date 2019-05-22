package com.donali.bookapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class Book(
    @ColumnInfo(name="title") val title:String,
    @ColumnInfo(name = "cover" ) val cover: String,
    @ColumnInfo(name = "authors") val authors: Number,
    @ColumnInfo(name = "edition") val edition: Number,
    @ColumnInfo(name = "editorial") val editorial: String,
    @ColumnInfo(name = "isbn") val isbn : String,
    @ColumnInfo(name ="summary") val summary : String,
    @ColumnInfo(name = "tags") val tags: Number,
    @ColumnInfo(name = "favorite") val favorite: Boolean

) {
    @PrimaryKey(autoGenerate = true) var id:Long = 0
}