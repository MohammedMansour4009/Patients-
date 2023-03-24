package com.training.tasktwo.data.datasource

import com.training.tasktwo.domain.model.BaseWrapper
import com.training.tasktwo.domain.model.add.AddPatientRemoteModel
import com.training.tasktwo.domain.model.add.BodyAddPatientModel
import com.training.tasktwo.domain.model.delete.PatientDeleteResponseModel
import com.training.tasktwo.domain.model.patients.PatientRemoteModel
import retrofit2.http.*

interface PatientsDataSource {

    @GET("patients")
    suspend fun getPatients(): BaseWrapper<List<PatientRemoteModel>>

    @POST("patients")
    suspend fun addPatient(@Body bodyAddPatientModel: BodyAddPatientModel): AddPatientRemoteModel

    @DELETE("patients/{id}")
    suspend fun deletePatient(@Path("id") id: String): PatientDeleteResponseModel

    @GET("patients/{id}")
    suspend fun getPatientById(@Path("id") id: String): BaseWrapper<PatientRemoteModel>

}