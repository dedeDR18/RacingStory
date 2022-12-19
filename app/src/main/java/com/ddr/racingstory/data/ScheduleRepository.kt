package com.ddr.racingstory.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ddr.core_model.Schedule

/**
 * Created by Dede Dari Rahmadi on 18/12/22
 */
interface ScheduleRepository {
    fun fetchScheduleMotogp(liveData: MutableLiveData<List<Schedule>>)
    fun fetchScheduleWsbk(liveData: MutableLiveData<List<Schedule>>)
    fun fetchScheduleFormula1(liveData: MutableLiveData<List<Schedule>>)
}