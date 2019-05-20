package com.donali.bookapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.donali.bookapp.entities.Book

class BookListAdapter:RecyclerView.Adapter<BookListAdapter.ViewHolder>() {

    var books:List<Book> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_template,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: BookListAdapter.ViewHolder, position: Int) = holder.bind(books[position])
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        lateinit var tvTitle:TextView
        fun bind(book:Book) = with(itemView){
            tvTitle =  findViewById(R.id.tv_title)
            tvTitle.text = book.title
        }
    }
    /*
        Funcion que se ejecuta al momento en que ocurre un cambio en la tabla book
        (se agrega, modifica o elimina un registro), la cual actualiza el recycler
        con la nueva lista de libros
    * */
    public fun setData(books:List<Book> ){
        this.books = books
        notifyDataSetChanged()
    }
}