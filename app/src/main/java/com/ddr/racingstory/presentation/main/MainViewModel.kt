package com.ddr.racingstory.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ddr.core_model.Competition
import com.ddr.racingstory.data.MainRepository
import com.ddr.racingstory.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Dede Dari Rahmadi on 10/12/22
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    val repo: MainRepository
) : ViewModel() {

    private val _liveDataCompetition = MutableLiveData<List<Competition>>()
    val liveDataCompetition: LiveData<List<Competition>> = _liveDataCompetition


//    init {
//        getCompetition()
//    }

    fun getCompetition() {
        repo.fetchCompetition(_liveDataCompetition)
    }
}