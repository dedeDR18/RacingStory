package com.ddr.racingstory.di

import com.ddr.racingstory.data.MainRepository
import com.ddr.racingstory.data.MainRepositoryImpl
import com.ddr.racingstory.data.ScheduleRepository
import com.ddr.racingstory.data.ScheduleRepositoryImpl
import dagger.Binds
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

/**
 * Created by Dede Dari Rahmadi on 10/12/22
 */
@dagger.Module
@InstallIn(SingletonComponent::class)
interface ViewModelModule {

    @Binds
    fun bindMainRepository(mainRepo: MainRepositoryImpl): MainRepository

    @Binds
    fun bindScheduleRepository(mainRepo: ScheduleRepositoryImpl): ScheduleRepository
}