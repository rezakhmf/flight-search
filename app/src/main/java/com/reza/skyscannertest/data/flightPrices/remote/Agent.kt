package com.reza.skyscannertest.data.flightPrices.remote

import com.google.gson.annotations.SerializedName

data class Agent(
    @SerializedName("Id")
    val id: Int?,
    @SerializedName("ImageUrl")
    val imageUrl: String?,
    @SerializedName("Name")
    val name: String?,
    @SerializedName("OptimisedForMobile")
    val optimisedForMobile: Boolean?,
    @SerializedName("Status")
    val status: String?,
    @SerializedName("type")
    val type: String?
)