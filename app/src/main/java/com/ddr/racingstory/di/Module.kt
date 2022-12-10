package com.ddr.racingstory.di

import com.ddr.racingstory.data.MainRepository
import com.ddr.racingstory.data.MainRepositoryImpl
import com.google.firebase.database.FirebaseDatabase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Dede Dari Rahmadi on 10/12/22
 */

@dagger.Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun provideFirebaseDatabase() = FirebaseDatabase.getInstance()


//    @Provides
//    @Singleton
//    fun provideRepository(firebaseDatabase: FirebaseDatabase) : MainRepository = MainRepositoryImpl(firebaseDatabase)
}