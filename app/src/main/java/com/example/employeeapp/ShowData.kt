package com.example.employeeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.employeeapp.databinding.ActivityShowDataBinding

class ShowData : AppCompatActivity() {
    lateinit var binding: ActivityShowDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent != null) {
            val employee:Employee = intent.getSerializableExtra("EXTRA_EMPLOYEE") as Employee
            displayResults(employee)
        }

        binding.btnGoBack.setOnClickListener {
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun displayResults(employee: Employee) {
        binding.tvResults.text = """
           Emp. name: ${employee.empName}
           Hours worked: ${employee.hoursWorked.toString()}
           Hourly rate: ${employee.hourlyRate.toString()}
           Is Manager?: ${if (employee.isManager == true) "Yes" else "No"}
           Weekly pay before tax deduction: ${'$'}${"%.2f".format(employee.weeklyPay)}
           Income tax deducted: ${'$'}${"%.2f".format(employee.taxAmount)}
           Final pay: ${'$'}${"%.2f".format(employee.finalPay)}
       """.trimIndent()
    }
}
