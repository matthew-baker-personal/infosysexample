package com.example.infosysexample.dataclasses

data class Attributes(val text_color:String, val size:Int){
    companion object {
        val default=Attributes("#000000",10)
    }
}
