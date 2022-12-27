package com.ddr.racingstory.presentation.motogp_schedule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import com.ddr.racingstory.R
import com.ddr.racingstory.databinding.ActivityScheduleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScheduleActivity : AppCompatActivity() {

    private val viewModel: ScheduleViewModel by viewModels()
    private lateinit var listAdapter: ScheduleMotogpAdapter
    private lateinit var binding: ActivityScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScheduleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRv()
        viewModel.getScheduleMotoGp()
        observe()
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            onBackPressed()
        }
    }

    private fun initRv() {
        listAdapter = ScheduleMotogpAdapter()
        binding.rvScheduleMotogp.apply {
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    private fun observe() {
        viewModel.liveDataScheduleMotogp.observe(this) {
            listAdapter.setData(it)
        }
    }

    override fun onBackPressed() {
        onBackPressedDispatcher.onBackPressed()
    }
}