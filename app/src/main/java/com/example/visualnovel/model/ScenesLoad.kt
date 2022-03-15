package com.example.visualnovel.model

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ScenesLoad(gameContext: Context) {
    private val scenes:List<Scene>
    private var current=0
    private val context = gameContext

    init {
        scenes=Json.decodeFromString(loadJSON())
    }

    private fun loadJSON(): String {
        return context.resources.assets.open(JSON_FILENAME).bufferedReader().use { it.readText() }
    }
    fun playerChoice(next:Int): Scene {
        current=scenes[current].choices[next].nextIndex.toInt()
        if (current==-1){
            return scenes[0]
        }
        return scenes[current]
    }

    companion object {
        private const val JSON_FILENAME="screens.json"
    }
}