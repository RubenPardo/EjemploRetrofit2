package com.example.rparcas.ejemploretrofit2.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rparcas.ejemploretrofit2.databinding.ActivityMainBinding
import com.example.rparcas.ejemploretrofit2.ui.DogAdapter
import com.example.rparcas.ejemploretrofit2.ui.viewmodel.DogsViewModel
//import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint // PREPARAR LA CLASE PARA QUE PUEDA INYECTAR
class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter
    private var dogsImages:MutableList<String> =  mutableListOf<String>()

    private val dogsViewModel: DogsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        binding.svDogs.setOnQueryTextListener(this)

        dogsViewModel.onCreate()

        dogsViewModel.dogsImages.observe(this,{dogsImagesVM ->
            Log.d("XD","6")
            dogsImages.clear()
            dogsImages.addAll(dogsImagesVM)
            adapter.notifyDataSetChanged()
        })

        dogsViewModel.error.observe(this, {error ->
            showError(error)
        })

        dogsViewModel.isLoading.observe(this, {isLoading ->
            binding.progress.isVisible = isLoading
            binding.rvDogs.isVisible = !isLoading

        })



    }

    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.viewRoot.windowToken, 0)
    }

    private fun showError(error: String?) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }

    private fun initRecyclerView(){
        adapter = DogAdapter(dogsImages)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            hideKeyboard()
            dogsViewModel.searchDogsByName(query)
        }

        return true

    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}