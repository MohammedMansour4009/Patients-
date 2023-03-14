package com.training.tasktwo.domain.usecase.add

import com.training.tasktwo.domain.model.AddPatientRemoteModel
import com.training.tasktwo.domain.model.add.BodyAddPatientModel
import com.training.tasktwo.domain.repo.patients.PatientsRepository
import javax.inject.Inject

class AddPatientUseCase @Inject constructor(private val repository: PatientsRepository) {

    suspend operator fun invoke(bodyAddPatientModel: BodyAddPatientModel): AddPatientRemoteModel {
        return repository.addPatients(bodyAddPatientModel)
    }
}