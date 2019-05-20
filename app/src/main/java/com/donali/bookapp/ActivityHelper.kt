package com.donali.bookapp

import androidx.recyclerview.widget.RecyclerView
/*
    Interfaz que permite ejecutar funciones que requieren el contexto
    de la actividad principal en otras clases, como en BookListFragment
* */
interface ActivityHelper {
    fun getLayoutManager(): RecyclerView.LayoutManager
    fun observeChanges()
    fun getListAdapter():BookListAdapter
}