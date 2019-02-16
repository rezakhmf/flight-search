package com.reza.skyscannertest.data.flightPrices.remote

data class Currency(
    val Code: String?,
    val DecimalDigits: Int?,
    val DecimalSeparator: String?,
    val RoundingCoefficient: Int?,
    val SpaceBetweenAmountAndSymbol: Boolean?,
    val Symbol: String?,
    val SymbolOnLeft: Boolean?,
    val ThousandsSeparator: String?
)