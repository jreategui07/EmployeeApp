package com.example.employeeapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.employeeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            goToShowData(createEmployee())
        }
    }

    private fun createEmployee(): Employee {
        return Employee(
            binding.etEmpName.text.toString(),
            binding.etHoursWorked.text.toString().toDouble(),
            binding.etHourlyRate.text.toString().toDouble(),
            binding.swIsManager.isChecked,
            binding.cbDeductTax.isChecked
        )
    }

    private fun goToShowData(employee: Employee) {
        val intent: Intent = Intent(this@MainActivity, ShowData::class.java)
        intent.putExtra("EXTRA_EMPLOYEE", employee)
        startActivity(intent)
    }
}