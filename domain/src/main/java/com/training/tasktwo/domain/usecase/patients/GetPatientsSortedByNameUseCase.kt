package com.training.tasktwo.domain.usecase.patients

import com.training.tasktwo.domain.model.patients.PatientRemoteModel
import com.training.tasktwo.domain.repo.patients.PatientsRepository
import javax.inject.Inject

class GetPatientsSortedByNameUseCase @Inject constructor(private val repository: PatientsRepository) {

    suspend operator fun invoke(): List<PatientRemoteModel> {
        return repository.getPatients().sortedBy { it.namePatient }
    }

}