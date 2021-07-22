package com.example.infosysexample.dataclasses

data class Card(val title:Title, val description:Description, val image:Image){
    companion object{
        val default=Card(Title.default,Description.default,Image.default)
    }
}
