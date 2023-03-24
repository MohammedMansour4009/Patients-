package com.training.tasktwo.domain.model

import com.training.tasktwo.domain.model.patients.PatientRemoteModel

data class BaseWrapper<T>(
    val status: Int,

    val message: String,

    val data: T
)
