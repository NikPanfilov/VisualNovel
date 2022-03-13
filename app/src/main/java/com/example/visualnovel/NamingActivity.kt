package com.example.visualnovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.visualnovel.databinding.NamingMainBinding

class NamingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=NamingMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.confirmButton.setOnClickListener{
            if(binding.usernameTextView.text.toString()==""){
                Toast.makeText(this,"Пожалуйста, введи имя!",Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, GameActivity::class.java)
                intent.putExtra("username",binding.usernameTextView.text.toString())
                startActivity(intent)
            }
        }
    }
}