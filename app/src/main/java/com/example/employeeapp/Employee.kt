package com.example.employeeapp

import java.io.Serializable

enum class TaxRate(val rate: Double) {
    MANAGER(0.15),
    NO_MANAGER(0.05)
}

class Employee: Serializable {
    var empName: String = ""
    var hoursWorked: Double = 0.0
    var hourlyRate: Double = 0.0
    var isManager: Boolean = false
    var autoDeductIncomeTax: Boolean = false
    var email: String = ""
    var weeklyPay: Double = 0.0
    var taxAmount: Double = 0.0
    var finalPay: Double = 0.0

    constructor(
        empName: String,
        hoursWorked: Double,
        hourlyRate: Double,
        isManager: Boolean,
        autoDeductIncomeTax: Boolean
    ) {
        this.empName = empName
        this.hoursWorked = hoursWorked
        this.hourlyRate = hourlyRate
        this.isManager = isManager
        this.autoDeductIncomeTax = autoDeductIncomeTax
        this.email = createEmail()
        this.weeklyPay = calculateWeeklyPay()
        this.taxAmount = calculateTaxAmount()
        this.finalPay = calculateFinalPay()
    }

    private fun createEmail(): String {
        return "$this.EmpName@company.com"
    }

    private fun calculateWeeklyPay(): Double {
        return this.hourlyRate * this.hoursWorked
    }

    private fun calculateTaxAmount(): Double {
        if (this.autoDeductIncomeTax == true) {
            var taxRate = TaxRate.NO_MANAGER.rate
            if (this.isManager == true) {
                taxRate = TaxRate.MANAGER.rate
            }
            return this.weeklyPay * taxRate
        }
        return 0.0
    }

    private fun calculateFinalPay(): Double {
        return this.weeklyPay - this.taxAmount
    }

    override fun toString(): String {
        return "Employee(empName='$empName', hoursWorked=$hoursWorked, hourlyRate=$hourlyRate, isManager=$isManager, autoDeductIncomeTax=$autoDeductIncomeTax, email='$email', weeklyPay=$weeklyPay, taxAmount=$taxAmount, finalPay=$finalPay)"
    }
}