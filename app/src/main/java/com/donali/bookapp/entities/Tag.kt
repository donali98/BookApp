package com.donali.bookapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tag")
data class Tag (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name= "id") var id: Int,
    @ColumnInfo(name = "tags") val tags: String
) {


}