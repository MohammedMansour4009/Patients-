package com.training.tasktwo.domain.usecase.details

import com.training.tasktwo.domain.model.patients.PatientRemoteModel
import com.training.tasktwo.domain.repo.patients.PatientsRepository
import javax.inject.Inject

class GetPatientByIdUseCase @Inject constructor(private val repository: PatientsRepository) {

    suspend operator fun invoke(id: String): PatientRemoteModel {
        return repository.getPatientById(id)
    }
}