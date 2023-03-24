package com.training.tasktwo.domain.usecase.add

import com.training.tasktwo.domain.model.add.AddPatientResponse
import com.training.tasktwo.domain.model.add.AddPatientRequest
import com.training.tasktwo.domain.repo.patients.PatientsRepository
import javax.inject.Inject

class AddPatientUseCase @Inject constructor(private val repository: PatientsRepository) {

    suspend operator fun invoke(bodyAddPatientModel: AddPatientRequest): AddPatientResponse {
        return repository.addPatients(bodyAddPatientModel)
    }
}