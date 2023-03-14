package com.training.tasktwo.domain.model.patients

import com.google.gson.annotations.SerializedName

data class PatientRemoteModel(

    val condition: String,

    @SerializedName("_id")
    val id: String,

    @SerializedName("name")
    val namePatient: String,

    val address: String,

    val mobile: String,

    val email: String,

    val birthdate: String,

    val gender: String,

    val photo: String,

    val test: List<TestModel>,

    //local var
    var selected: Boolean = false
)
