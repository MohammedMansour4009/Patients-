package com.training.tasktwo.domain.repo.patients

import com.training.tasktwo.domain.model.AddPatientRemoteModel
import com.training.tasktwo.domain.model.add.BodyAddPatientModel
import com.training.tasktwo.domain.model.patients.PatientRemoteModel

interface PatientsRepository {

    suspend fun getPatients(): List<PatientRemoteModel>

    suspend fun addPatients(bodyAddPatientModel: BodyAddPatientModel): AddPatientRemoteModel

}