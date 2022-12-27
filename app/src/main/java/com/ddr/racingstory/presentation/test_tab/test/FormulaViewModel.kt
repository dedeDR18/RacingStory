package com.ddr.racingstory.presentation.test_tab.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ddr.core_model.Competition
import com.ddr.core_model.Schedule
import com.ddr.racingstory.data.ScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Dede Dari Rahmadi on 22/12/22
 */

@HiltViewModel
class FormulaViewModel @Inject constructor(
    val repo: ScheduleRepository
) : ViewModel(){

    private val _liveDataSchedule = MutableLiveData<List<Schedule>>()
    val liveDataSchedule: LiveData<List<Schedule>> = _liveDataSchedule

    fun getSchedule() {
        repo.fetchScheduleFormula1(_liveDataSchedule)
    }
}