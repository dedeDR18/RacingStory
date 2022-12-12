package com.ddr.racingstory.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.ddr.core_model.Competition
import com.ddr.racingstory.databinding.ActivityMainBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val exampleViewModel: MainViewModel by viewModels()
    private lateinit var listAdapter: CompetitionAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRv()
        exampleViewModel.getCompetition()
        observe()
    }

    private fun initRv() {
        listAdapter = CompetitionAdapter()
        binding.rvCompetition.apply {
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    private fun observe() {
        exampleViewModel.liveDataCompetition.observe(this) {
            listAdapter.setData(it)
        }
    }
}