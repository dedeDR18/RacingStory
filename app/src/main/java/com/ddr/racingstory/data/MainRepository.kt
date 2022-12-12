package com.ddr.racingstory.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ddr.core_model.Competition
import com.ddr.racingstory.util.Resource
import com.google.android.gms.common.api.Response
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Dede Dari Rahmadi on 10/12/22
 */

interface MainRepository {

    fun fetchCompetition(liveData: MutableLiveData<List<Competition>>)
}