package com.training.tasktwo.data.repository

import com.training.tasktwo.data.datasource.PatientsDataSource
import com.training.tasktwo.domain.model.add.AddPatientRemoteModel
import com.training.tasktwo.domain.model.add.BodyAddPatientModel
import com.training.tasktwo.domain.model.delete.PatientDeleteResponseModel
import com.training.tasktwo.domain.model.patients.PatientRemoteModel
import com.training.tasktwo.domain.repo.patients.PatientsRepository
import javax.inject.Inject

class PatientsRepositoryImpl @Inject constructor(private val patientsDataSource: PatientsDataSource) :
    PatientsRepository {

    override suspend fun getPatients(): List<PatientRemoteModel> {
        return patientsDataSource.getPatients().data
    }

    override suspend fun addPatients(bodyAddPatientModel: BodyAddPatientModel): AddPatientRemoteModel {
        return patientsDataSource.addPatient(bodyAddPatientModel)
    }

    override suspend fun deletePatients(id: String): PatientDeleteResponseModel {
        return patientsDataSource.deletePatient(id)
    }

    override suspend fun getPatientById(id: String): PatientRemoteModel {
        return patientsDataSource.getPatientById(id).data
    }

}