package com.example.task3


import Adapter.CapybaraAdapter
import android.os.Bundle
import android.widget.Adapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task3.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    lateinit var binding :ActivityDashboardBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CapybaraAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = arrayListOf(
            R.drawable.capybara,
        )

        val CapybaraName = arrayListOf("Capybara", "kapibara")
        val CapybaraDesc = arrayListOf("This is a capybara", " this is a kapibara")

        val fullName : String = intent.getStringExtra("fullName").toString()
        val email :String = intent.getStringExtra("email").toString()
        val password:String = intent.getStringExtra("password").toString()
        val gender :String = intent.getStringExtra("gender").toString()
        val country :String = intent.getStringExtra("country").toString()
        val city: String = intent.getStringExtra("city").toString()

        binding.idName.text = fullName
        binding.idEmail.text = email
        binding.idGender.text = gender
        binding.idCountry.text = country
        binding.idCity.text = city

        adapter = CapybaraAdapter(
            this@DashboardActivity, imageList, CapybaraName, CapybaraDesc
        )

        binding.capybararecyclerview.adapter = adapter
        binding.capybararecyclerview.layoutManager = LinearLayoutManager(this@DashboardActivity)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}