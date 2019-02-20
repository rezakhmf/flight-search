package com.reza.skyscannertest.data.flightPrices.remote

import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("Code")
    val code: String?,
    @SerializedName("Id")
    val id: Int?,
    @SerializedName("Name")
    val name: String?,
    @SerializedName("ParentId")
    val parentId: Int?,
    @SerializedName("Type")
    val type: String?
)