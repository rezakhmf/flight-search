package com.reza.skyscannertest.data.flightPrices.remote

import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("Code")
    val code: String?,
    @SerializedName("DecimalDigits")
    val decimalDigits: Int?,
    @SerializedName("DecimalSeparator")
    val decimalSeparator: String?,
    @SerializedName("RoundingCoefficient")
    val roundingCoefficient: Int?,
    @SerializedName("SpaceBetweenAmountAndSymbol")
    val spaceBetweenAmountAndSymbol: Boolean?,
    @SerializedName("Symbol")
    val symbol: String?,
    @SerializedName("SymbolOnLeft")
    val symbolOnLeft: Boolean?,
    @SerializedName("ThousandsSeparator")
    val thousandsSeparator: String?
)