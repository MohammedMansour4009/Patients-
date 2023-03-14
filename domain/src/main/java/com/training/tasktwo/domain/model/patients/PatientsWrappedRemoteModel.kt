package com.training.tasktwo.domain.model.patients

data class PatientsWrappedRemoteModel(

    val status: Int,

    val message: String,

    val data: List<PatientRemoteModel>


)
