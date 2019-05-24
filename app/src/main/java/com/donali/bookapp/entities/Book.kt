package com.donali.bookapp.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "book",
    foreignKeys = [
        ForeignKey(entity = Author::class,parentColumns = ["id"],childColumns = ["author"]),
        ForeignKey(entity = Tag::class,parentColumns = ["id"],childColumns = ["tag"])
    ])
data class Book(
    @PrimaryKey (autoGenerate = true)@ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name="title") val title:String,
    @ColumnInfo(name = "cover" ) val cover: String,
    @ColumnInfo(name = "authors") val authors: Int,
    @ColumnInfo(name = "edition") val edition: String,
    @ColumnInfo(name = "editorial") val editorial: String,
    @ColumnInfo(name = "isbn") val isbn : String,
    @ColumnInfo(name ="summary") val summary : String,
    @ColumnInfo(name = "tags") val tags: Int,
    @ColumnInfo(name = "favorite") val favorite: Boolean

): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(cover)
        parcel.writeInt(authors)
        parcel.writeString(edition)
        parcel.writeString(editorial)
        parcel.writeString(isbn)
        parcel.writeString(summary)
        parcel.writeInt(tags)
        parcel.writeByte(if (favorite) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }

}