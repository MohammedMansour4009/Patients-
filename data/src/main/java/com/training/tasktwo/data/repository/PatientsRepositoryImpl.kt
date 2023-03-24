package com.training.tasktwo.data.repository

import com.training.tasktwo.data.datasource.PatientsDataSource
import com.training.tasktwo.domain.model.add.AddPatientResponse
import com.training.tasktwo.domain.model.add.AddPatientRequest
import com.training.tasktwo.domain.model.delete.PatientDeleteResponse
import com.training.tasktwo.domain.model.patients.PatientResponse
import com.training.tasktwo.domain.repo.patients.PatientsRepository
import javax.inject.Inject

class PatientsRepositoryImpl @Inject constructor(private val patientsDataSource: PatientsDataSource) :
    PatientsRepository {

    override suspend fun getPatients(): List<PatientResponse> {
        return patientsDataSource.getPatients().data
    }

    override suspend fun addPatients(bodyAddPatientModel: AddPatientRequest): AddPatientResponse {
        return patientsDataSource.addPatient(bodyAddPatientModel)
    }

    override suspend fun deletePatients(id: String): PatientDeleteResponse {
        return patientsDataSource.deletePatient(id)
    }

    override suspend fun getPatientById(id: String): PatientResponse {
        return patientsDataSource.getPatient(id).data
    }

}