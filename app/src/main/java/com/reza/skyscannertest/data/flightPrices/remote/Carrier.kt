package com.reza.skyscannertest.data.flightPrices.remote

import com.google.gson.annotations.SerializedName

data class Carrier(
    @SerializedName("Code")
    val code: String?,
    @SerializedName("DisplayCode")
    val displayCode: String?,
    @SerializedName("Id")
    val id: Int?,
    @SerializedName("ImageUrl")
    val imageUrl: String?,
    @SerializedName("Name")
    val name: String?
)