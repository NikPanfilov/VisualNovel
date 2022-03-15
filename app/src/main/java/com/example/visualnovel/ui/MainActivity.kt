package com.example.visualnovel.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.visualnovel.R
import com.example.visualnovel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gamePassed=intent.getBooleanExtra("gameOver",false)
        if(gamePassed){
            binding.myVisualNovel.text= getString(R.string.gratitude)
            binding.begin.text=getString(R.string.go_game_again)
        }

        binding.begin.setOnClickListener {
            val intent = Intent(this, NamingActivity::class.java)
            startActivity(intent)
        }
    }
}
