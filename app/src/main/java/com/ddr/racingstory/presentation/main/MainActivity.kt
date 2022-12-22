package com.ddr.racingstory.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ddr.racingstory.databinding.ActivityMainBinding
import com.ddr.racingstory.presentation.motogp_schedule.ScheduleActivity
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
        handleOnItemClick()
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

    private fun handleOnItemClick(){
        listAdapter.onItemClick = {
            val intent = Intent(this, ScheduleActivity::class.java)
            startActivity(intent)
        }
    }
}