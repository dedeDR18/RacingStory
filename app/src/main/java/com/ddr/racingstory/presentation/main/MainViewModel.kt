package com.ddr.racingstory.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
): ViewModel(){


//    init {
//        getCompetition()
//    }

    fun getCompetition(){
        viewModelScope.launch {
            repo.getCompetition().collect{ data ->
                when (data) {
                    is Resource.Success -> {
                        Log.d("VIEWMODEL", "${data.model?.size}")
                    }

                    is Resource.Error -> {
                        Log.d("VIEWMODEL", "Error !!!")
                    }

                    is Resource.Loading -> {
                        Log.d("VIEWMODEL", "Loading...")
                    }
                    else -> {
                        Log.d("VIEWMODEL", "else...")
                    }
                }

            }
        }
    }
}