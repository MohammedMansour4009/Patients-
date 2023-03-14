package com.training.tasktwo.data.datasource

import com.training.tasktwo.domain.model.AddPatientRemoteModel
import com.training.tasktwo.domain.model.add.BodyAddPatientModel
import com.training.tasktwo.domain.model.patients.PatientsWrappedRemoteModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PatientsDataSource {

    @GET("patients")
    suspend fun getPatients(): PatientsWrappedRemoteModel

    @POST("patients")
    suspend fun addPatient(@Body bodyAddPatientModel : BodyAddPatientModel): AddPatientRemoteModel


}