package com.example.visualnovel.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.visualnovel.R
import com.example.visualnovel.databinding.NamingMainBinding

class NamingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=NamingMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.confirmButton.setOnClickListener{
            if(binding.usernameTextView.text.toString()==""){
                Toast.makeText(this,getString(R.string.empty_name),Toast.LENGTH_LONG).show()//
            }else{
                val intent = Intent(this, GameActivity::class.java)
                intent.putExtra("username",binding.usernameTextView.text.toString())
                startActivity(intent)
            }
        }
    }
}