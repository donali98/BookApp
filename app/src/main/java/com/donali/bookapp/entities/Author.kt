package com.donali.bookapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "authorxbook")
data class Author (
    @ColumnInfo(name = "nameauthors") val nameauthors: String
) {

    @PrimaryKey(autoGenerate = true) var idauthor:Long = 0


}