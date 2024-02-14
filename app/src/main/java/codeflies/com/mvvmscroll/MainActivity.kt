package codeflies.com.mvvmscroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import codeflies.com.mvvmscroll.adapter.MainAdapter
import codeflies.com.mvvmscroll.databinding.ActivityMainBinding
import codeflies.com.mvvmscroll.model.PostResultItem
import codeflies.com.mvvmscroll.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    private var arrlist = ArrayList<PostResultItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.model = viewModel
        viewModel.getpost {
            arrlist.clear()
            arrlist.addAll(it)
            adapter = MainAdapter(arrlist,this)
            binding.recyclerview.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
            binding.recyclerview.adapter = adapter

        }

    }
}