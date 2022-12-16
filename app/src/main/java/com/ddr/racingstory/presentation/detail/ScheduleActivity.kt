package com.ddr.racingstory.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ddr.racingstory.R
import com.ddr.racingstory.databinding.ActivityScheduleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScheduleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScheduleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}