package com.donali.bookapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tag")
data class Tag (
    @ColumnInfo(name = "tags") val tags: String
) {

    @PrimaryKey(autoGenerate = true) var idtag:Long = 0
}