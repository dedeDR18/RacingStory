package com.ddr.racingstory.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ddr.core_model.Competition
import com.ddr.core_model.Schedule
import com.ddr.racingstory.data.ScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Dede Dari Rahmadi on 16/12/22
 */
@HiltViewModel
class ScheduleViewModel @Inject constructor(
    val repo: ScheduleRepository
) : ViewModel(){

    private val _liveDataScheduleMotoGp = MutableLiveData<List<Schedule>>()
    val liveDataScheduleMotogp: LiveData<List<Schedule>> = _liveDataScheduleMotoGp

    fun getScheduleMotoGp(){
        repo.fetchScheduleMotogp(_liveDataScheduleMotoGp)
    }
}