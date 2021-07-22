package com.example.infosysexample.dataclasses



data class CardG(val card_type:String, val card:Card){
    companion object{
        val default=CardG("Default",Card.default)
    }
}
