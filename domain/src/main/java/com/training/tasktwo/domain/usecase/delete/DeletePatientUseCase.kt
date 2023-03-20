package com.training.tasktwo.domain.usecase.delete

import com.training.tasktwo.domain.model.delete.PatientDeleteResponseModel
import com.training.tasktwo.domain.repo.patients.PatientsRepository
import javax.inject.Inject

class DeletePatientUseCase @Inject constructor(private val repository: PatientsRepository) {

    suspend operator fun invoke(id: String): PatientDeleteResponseModel {
        return repository.deletePatients(id)
    }
}