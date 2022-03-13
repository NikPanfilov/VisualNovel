package com.example.visualnovel

import android.content.Context
import android.content.Intent
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import kotlinx.serialization.json.decodeFromStream

class Transition(gameContext: Context) {
    private val scenes:List<Scene>
    private var current=0
    private val context = gameContext

    init {
        scenes=Json.decodeFromString(loadJSON())
    }

    private fun loadJSON(): String {
        return context.resources.assets.open("screens.json").bufferedReader().use { it.readText() }
    }
    fun playerChoice(next:Int):Scene{
        current=scenes[current].choices[next].nextIndex.toInt()
        if (current==-1){
            return scenes[0]
        }
        return scenes[current]
    }
}