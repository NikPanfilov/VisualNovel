package com.example.visualnovel

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.visualnovel.databinding.GameMainBinding
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.*
import kotlinx.serialization.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

class GameActivity : AppCompatActivity() {

    private lateinit var transition:Transition
    private lateinit var binding:GameMainBinding
    private lateinit var name:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GameMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        transition=Transition(this)
        name=intent.getStringExtra("username").toString()
        nextScene(0)
        binding.buttonVariant1.setOnClickListener{nextScene(0)}
        binding.buttonVariant2.setOnClickListener{nextScene(1)}
        binding.buttonVariant3.setOnClickListener{nextScene(2)}
    }

    private fun nextScene(next: Int){
        binding.buttonVariant1.visibility= View.INVISIBLE
        binding.buttonVariant2.visibility= View.INVISIBLE
        binding.buttonVariant3.visibility= View.INVISIBLE

        val data=transition.playerChoice(next)

        if(data.id==0){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("end",1)
            startActivity(intent)
        }

        binding.textView.text=data.message.replace("<username>",name)
        binding.backgroundImage.setImageResource(resources.getIdentifier(data.image,"drawable",packageName))
        binding.buttonVariant1.text=data.choices[0].text
        binding.buttonVariant1.visibility= View.VISIBLE

        if(data.choices.size>1){
            binding.buttonVariant2.text=data.choices[1].text
            binding.buttonVariant2.visibility= View.VISIBLE
        }
        if(data.choices.size>2){
            binding.buttonVariant3.text=data.choices[2].text
            binding.buttonVariant3.visibility= View.VISIBLE
        }
    }
}