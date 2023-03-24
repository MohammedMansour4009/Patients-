package com.training.tasktwo.domain.repo.patients

import com.training.tasktwo.domain.model.add.AddPatientResponse
import com.training.tasktwo.domain.model.add.AddPatientRequest
import com.training.tasktwo.domain.model.delete.PatientDeleteResponse
import com.training.tasktwo.domain.model.patients.PatientResponse

interface PatientsRepository {

    suspend fun getPatients(): List<PatientResponse>

    suspend fun addPatients(bodyAddPatientModel: AddPatientRequest): AddPatientResponse

    suspend fun deletePatients(id: String): PatientDeleteResponse

    suspend fun getPatientById(id: String): PatientResponse

}