package com.ddr.racingstory.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ddr.core_model.Competition
import com.ddr.racingstory.util.Resource
import com.google.firebase.database.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dede Dari Rahmadi on 10/12/22
 */

class MainRepositoryImpl @Inject constructor(
    val database: FirebaseDatabase
) : MainRepository {

    companion object {
        const val COMPETITION_REFERENCE = "competition"
    }

    override fun fetchCompetition(liveData: MutableLiveData<List<Competition>>) {

        database.getReference(COMPETITION_REFERENCE)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = ArrayList<Competition>()
                    for (item in snapshot.children) {
                        val competition = item.getValue(Competition::class.java)
                        competition?.let {
                            list.add(it)
                        }
                        Log.d("MAIN", "competition = ${competition?.name}")
                        Log.d("MAIN", "competition = ${competition?.id}")
                        liveData.postValue(list)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d("MAIN", "error = ${error.message}")
                }

            })
    }
}
