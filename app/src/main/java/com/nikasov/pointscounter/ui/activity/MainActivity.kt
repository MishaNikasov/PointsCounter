package com.nikasov.pointscounter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.nikasov.pointscounter.ui.adapter.TableAdapter
import com.nikasov.pointscounter.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var tableAdapter: TableAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupList()
    }

    private fun setupList() {
        val layoutManager = LinearLayoutManager(this@MainActivity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        binding.tableRecycler.apply {
            adapter = tableAdapter
            this.layoutManager = layoutManager
        }

        tableAdapter.items = viewModel.tableList

        viewModel.updateList.observe(this) { tableAdapter.notifyDataSetChanged() }
    }
}