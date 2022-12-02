package com.ddr.racingstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ddr.core_model.Competition
import com.ddr.racingstory.databinding.ActivityMainBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var listAdapter: CompetitionAdapter
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        database = Firebase.database.reference
        initRv()
        getData()
    }

    private fun initRv(){
        listAdapter = CompetitionAdapter()
        binding.rvCompetition.apply {
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    private fun getData() {
        database.child("competition").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<Competition>()
                for (item in snapshot.children) {
                    val competition = item.getValue(Competition::class.java)
                    competition?.let {
                        list.add(it)
                    }
                    Log.d("MAIN", "competition = ${competition?.name}")
                    Log.d("MAIN", "competition = ${competition?.id}")
                }
                listAdapter.setData(list)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("MAIN", "error = ${error.message}")
            }

        })

    }
}