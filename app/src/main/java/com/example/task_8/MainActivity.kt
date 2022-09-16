package com.example.task_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.task_8.common.extensions.asynchronously
import com.example.task_8.databinding.ActivityMainBinding
import com.example.task_8.presentation.MainViewModel
import com.example.task_8.presentation.ItemsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    private val itemsAdapter = ItemsAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

        observers()
    }
    private fun init() {
        binding.recycler.apply {
            adapter = itemsAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
        asynchronously { viewModel.getOutfits() }
    }

    private fun observers() {
        asynchronously {
            viewModel.itemsFlow.collect { state ->
                state.value?.let { items ->
                    itemsAdapter.submitList(items.map { it.toItems() })
                }
                state.errorMessage?.let {
                    Log.d("Error", it,)
                }
            }
        }
    }
}