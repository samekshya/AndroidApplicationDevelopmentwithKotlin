package com.example.task3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding

    val countries = arrayOf("Nepal", "India", "china", "USA", "Canada", "Australia")
    val cities = arrayOf("Kathmandu", "Pokhara", "Chitwan", "Butwal")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        countryAdapter.setDropDownViewResource((android.R.layout.simple_spinner_dropdown_item))
        binding.spinnerCountryDropdown.adapter = countryAdapter

        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, cities)
        binding.enterCity.setAdapter(cityAdapter)
        binding.enterCity.threshold = 1

        binding.submitBtn.setOnClickListener {
            val fullName : String = binding.fullName.text.toString()
            val email : String = binding.email.text.toString()
            val password  :String = binding.password.toString()
            val malee  = binding.isMale.isChecked
            val femalee   = binding.isFemale.isChecked
            val country = binding.spinnerCountryDropdown.selectedItem?.toString()?:""
            val city = binding.enterCity.text.toString()

            val agreedTerms = binding.termsCondition.isChecked

            val gender = when{
                malee -> "Male"
                femalee -> "Female"
                else -> ""
            }


            if(fullName.isEmpty()){
                binding.fullName.error = "name can't be empty"
            }else if(email.isEmpty()){
                binding.email.error = "email can't be empty"
            }else if(password.isEmpty()){
                binding.password.error = "password can't be empty"
            }else if (!malee && !femalee){
                Toast.makeText(this,"please select a gender", Toast.LENGTH_SHORT).show()
            }else if (!agreedTerms){
                Toast.makeText(this, "You must agree to the text and condition", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this@MainActivity, DashboardActivity::class.java)
                intent.putExtra("fullName", fullName)
                intent.putExtra("email", email)
                intent.putExtra("gender", gender)
                intent.putExtra("country", country)
                intent.putExtra("city", city)
                startActivity(intent)


            }


        }



        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}