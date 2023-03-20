package com.training.tasktwo.domain.repo.patients

import com.training.tasktwo.domain.model.add.AddPatientRemoteModel
import com.training.tasktwo.domain.model.add.BodyAddPatientModel
import com.training.tasktwo.domain.model.delete.PatientDeleteResponseModel
import com.training.tasktwo.domain.model.patients.PatientRemoteModel

interface PatientsRepository {

    suspend fun getPatients(): List<PatientRemoteModel>

    suspend fun addPatients(bodyAddPatientModel: BodyAddPatientModel): AddPatientRemoteModel

    suspend fun deletePatients(id: String): PatientDeleteResponseModel

    suspend fun getPatientById(id: String): PatientRemoteModel

}