package com.training.tasktwo.data.di

import com.training.tasktwo.data.datasource.PatientsDataSource
import com.training.tasktwo.data.repository.PatientsRepositoryImpl
import com.training.tasktwo.domain.repo.patients.PatientsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepositoryPatients(patientsDataSource: PatientsDataSource): PatientsRepository {
        return PatientsRepositoryImpl(patientsDataSource)
    }

}