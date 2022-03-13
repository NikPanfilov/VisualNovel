package com.example.visualnovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.visualnovel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val end:Int=intent.getIntExtra("end",0)
        if(end==1){
            binding.myVisualNovel.text="Спасибо, что поиграли"
            binding.begin.text="Пройти ещё раз"
        }

        binding.begin.setOnClickListener {
            val intent = Intent(this, NamingActivity::class.java)
            startActivity(intent)
        }
    }
}
