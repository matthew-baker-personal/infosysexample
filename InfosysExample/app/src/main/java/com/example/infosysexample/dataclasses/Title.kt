package com.example.infosysexample.dataclasses

data class Title(val value:String, val attributes: Attributes){
    companion object{
        val default=Title("An Error Occured",Attributes.default)
    }
}
