package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("test2")
class Test2Controller {

    @GetMapping
    fun get(): String = "Test"

    @GetMapping("/2")
    fun get2(): String {
        // Test data
        val rate1 = RateOutput(1.0, 2.0, 3.0, 1, 12, "SAC", "FIXA")
        val rate2 = RateOutput(1.5, 2.5, 3.5, 1, 12, "SAC", "VARIAVEL")
        val rate3 = RateOutput(0.5, 1.5, 2.5, 1, 12, "MIX", "FIXA")
        val rate4 = RateOutput(1.2, 2.2, 3.2, 1, 12, "MIX", "VARIAVEL")

        val rate5 = RateOutput(1.0, 2.0, 9.0, 1, 12, "SAC", "FIXA")
        val rate6 = RateOutput(1.5, 2.5, 10.5, 1, 12, "SAC", "VARIAVEL")
        val rate7 = RateOutput(0.5, 1.5, 11.5, 1, 12, "MIX", "FIXA")
        val rate8 = RateOutput(1.2, 2.2, 1.2, 1, 12, "MIX", "VARIAVEL")

        val fee1 = FeesOutput(100.0)
        val fee2 = FeesOutput(200.0)

        val tax1 = TaxesOutput(10.0)
        val tax2 = TaxesOutput(20.0)

        val pricingOutput1 = PricingOutput(listOf(rate1, rate2), listOf(fee1), listOf(tax1))
        val pricingOutput2 = PricingOutput(listOf(rate3, rate4), listOf(fee2), listOf(tax2))
        val pricingOutput3 = PricingOutput(listOf(rate5, rate6))
        val pricingOutput4 = PricingOutput(listOf(rate7, rate8))

        val result = extract(listOf(pricingOutput1, pricingOutput2, pricingOutput3, pricingOutput4))
        println(result)
        return result.toString()
    }

    fun extract(lstPricingOutput: List<PricingOutput>): PricingOutput {
        // Flatten all the rates and group by amortizationType and rateType
        val groupedRates = lstPricingOutput
            .flatMap { it.rates }
            .groupBy { RateKey(it.amortizationType, it.rateType) }

        // Select the best rates by finding the minimum totalAnnualInterestRate within each group
        val bestRates = groupedRates.map { (_, rates) ->
            rates.minByOrNull { it.totalAnnualInterestRate }!!
        }.sortedBy { it.totalAnnualInterestRate }

        // Extract the corresponding fees and taxes for the selected bestRates
        val bestFees = lstPricingOutput.flatMap { it.fees }
        val bestTaxes = lstPricingOutput.flatMap { it.taxes }

        val resultRates = bestRates.map { bestRate ->
            val matchingOutput = lstPricingOutput.firstOrNull {
                it.rates.contains(bestRate)
            }
            Triple(bestRate, matchingOutput?.fees ?: emptyList(), matchingOutput?.taxes ?: emptyList())
        }

        val resultFees = resultRates.flatMap { it.second }.distinct()
        val resultTaxes = resultRates.flatMap { it.third }.distinct()

        return PricingOutput(rates = bestRates, fees = resultFees, taxes = resultTaxes)
    }

    data class PricingOutput(
        val rates: List<RateOutput>,
        val fees: List<FeesOutput> = emptyList(),
        val taxes: List<TaxesOutput> = emptyList()
    )

    data class RateOutput(
        val variableAnnualInterestRate: Double,
        val fixedAnnualInterestRate: Double,
        val totalAnnualInterestRate: Double,
        val applicationStartMonth: Int,
        val applicationEndMonth: Int,
        val amortizationType: String,
        val rateType: String
    )

    data class FeesOutput(val feeValue: Double)
    data class TaxesOutput(val aliquotValue: Double)

    data class RateKey(val amortizationType: String, val rateType: String)


}
