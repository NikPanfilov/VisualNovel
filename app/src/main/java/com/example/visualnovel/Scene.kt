package com.example.visualnovel

import kotlinx.serialization.Serializable

@Serializable
data class Choices(val text:String,val nextIndex:String){

}
@Serializable
data class Scene(val id:Int,val image:String,val message:String,val choices:List<Choices>)

