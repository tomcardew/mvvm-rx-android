package com.example.mvvm_tutorial_2.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_tutorial_2.R
import com.example.mvvm_tutorial_2.data.api.ApiHelper
import com.example.mvvm_tutorial_2.data.api.ApiServiceImpl
import com.example.mvvm_tutorial_2.data.model.Instructor
import com.example.mvvm_tutorial_2.ui.base.ViewModelFactory
import com.example.mvvm_tutorial_2.ui.main.adapter.MainAdapter
import com.example.mvvm_tutorial_2.ui.main.viewmodel.MainViewModel
import com.example.mvvm_tutorial_2.utils.Status
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUi()
        setupViewModel()
        setupObserver()
    }

    private fun setupUi() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        mainViewModel.getInstructors().observe(this, Observer {
            when (it.status) {
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { response -> response.data?.let { instructors -> renderList(instructors) } }
                    recyclerView.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun renderList(instructors: List<Instructor>) {
        adapter.addData(instructors)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(this, ViewModelFactory(ApiHelper(ApiServiceImpl()))).get(MainViewModel::class.java)
    }

}