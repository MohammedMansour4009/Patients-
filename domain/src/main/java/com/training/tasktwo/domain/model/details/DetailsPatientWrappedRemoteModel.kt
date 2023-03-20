package com.training.tasktwo.domain.model.details

import com.training.tasktwo.domain.model.patients.PatientRemoteModel

data class DetailsPatientWrappedRemoteModel(

    val status: Int,

    val message: String,

    val data: PatientRemoteModel

)
