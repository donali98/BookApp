package com.donali.bookapp


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView

class BookListFragment : Fragment() {
    lateinit var recyclerView:RecyclerView
    lateinit var activityHelper: ActivityHelper
    lateinit var customLayoutManager: RecyclerView.LayoutManager
    lateinit var bookListAdapter: BookListAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityHelper = context as ActivityHelper

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_book_list, container, false)
        recyclerView = view.findViewById(R.id.rv_book_list)
        bind()
        return view
    }

    private fun bind(){
        bookListAdapter = activityHelper.getListAdapter()
        customLayoutManager = activityHelper.getLayoutManager()
        recyclerView.apply {
            setHasFixedSize(true)
            adapter = bookListAdapter
            layoutManager = customLayoutManager
        }
    }

}
