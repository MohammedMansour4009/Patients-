package com.training.tasktwo.domain.model.add

import com.google.gson.annotations.SerializedName

data class AddPatientResponse(

    @SerializedName("condition")
    val condition: String,

    @SerializedName("_id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("address")
    val address: String,

    @SerializedName("mobile")
    val mobile: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("birthdate")
    val birthdate: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("photo")
    val photo: String,

    @SerializedName("createdAt")
    val createdAt: String,

    @SerializedName("updatedAt")
    val updatedAt: String,

    @SerializedName("__v")
    val v: Int,

    )
