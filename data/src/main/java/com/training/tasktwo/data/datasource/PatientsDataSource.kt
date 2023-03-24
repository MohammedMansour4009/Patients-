package com.training.tasktwo.data.datasource

import com.training.tasktwo.domain.model.BaseWrapper
import com.training.tasktwo.domain.model.add.AddPatientResponse
import com.training.tasktwo.domain.model.add.AddPatientRequest
import com.training.tasktwo.domain.model.delete.PatientDeleteResponse
import com.training.tasktwo.domain.model.patients.PatientResponse
import retrofit2.http.*

interface PatientsDataSource {

    @GET("patients")
    suspend fun getPatients(): BaseWrapper<List<PatientResponse>>

    @POST("patients")
    suspend fun addPatient(@Body addPatientRequest: AddPatientRequest): AddPatientResponse

    @DELETE("patients/{id}")
    suspend fun deletePatient(@Path("id") id: String): PatientDeleteResponse

    @GET("patients/{id}")
    suspend fun getPatient(@Path("id") id: String): BaseWrapper<PatientResponse>

}