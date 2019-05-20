package com.donali.bookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.donali.bookapp.entities.Book

class MainActivity : AppCompatActivity(),ActivityHelper {



    lateinit var btnAdd:Button
    lateinit var bookViewModel: BookViewModel
    lateinit var etName:EditText
    var bookListAdapter:BookListAdapter = BookListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd = findViewById(R.id.bt_add)
        etName = findViewById(R.id.et_name)
        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        observeChanges()


        btnAdd.setOnClickListener {
            val book = Book(etName.text.toString())
            bookViewModel.insert(book)
        }

        val bookListFragment = BookListFragment()
        supportFragmentManager.beginTransaction().add(R.id.fl_container,bookListFragment).commit()
    }

    override fun getLayoutManager(): RecyclerView.LayoutManager {
        return GridLayoutManager(this,2)
    }
    override fun observeChanges() {
        /*
            Observando en tiempo real los cambios en la tabla book
            (si se agrega, modifica o elimina un registro), si esto
            ocurre, ejecuta la funcion publica setData en el BookListAdapter
        * */
        bookViewModel.getAllBooks().observe(this, Observer {
            bookListAdapter.setData(it)
        })
    }

    override fun getListAdapter(): BookListAdapter {
        return bookListAdapter
    }
}
