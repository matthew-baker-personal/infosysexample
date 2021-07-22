package com.example.infosysexample.dataclasses

data class Image(val url:String?,val size :Size){
    companion object{
        val default=Image(null,Size(0,0))
    }
}
