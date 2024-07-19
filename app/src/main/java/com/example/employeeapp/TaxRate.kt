package com.example.employeeapp

data class TaxRate(val rate: Double) {
    companion object {
        val MANAGER = TaxRate(0.15)
        val NO_MANAGER = TaxRate(0.05)
    }
}
