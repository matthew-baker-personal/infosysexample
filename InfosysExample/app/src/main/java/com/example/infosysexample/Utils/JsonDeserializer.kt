package com.example.infosysexample.Utils

import com.example.infosysexample.dataclasses.*
import org.json.JSONObject

object JsonDeserializer {

    //Deserialize the list manually because the list is rather complicated
    //Also break the task into parts to make changing/reusing code easier
    //It is worth noting that extention functions are used frequently here to shorten the code
    //As much of the original json structure was preservered in case this ever needs to be replaced
    //  with a converter like moshi

    fun getCardsGFromJson(j:JSONObject):List<CardG>{
        val list=ArrayList<CardG>()

        j.getJSONObject("page").getJSONArray("cards").apply{
            for(i in 0 until length()){
                list.add(getJSONObject(i).getCardGFromJson())
            }
        }

        return list
    }

    private fun JSONObject.getCardGFromJson():CardG{
        getString("card_type").let {
            return CardG(it,getJSONObject("card").getCardFromJson(it))
        }
    }

    private fun JSONObject.getCardFromJson(s:String):Card//: Card
    {
        return if (s=="text"){
            getString("value").let{words->
                getJSONObject("attributes").let{attr->
                    Attributes(attr.getString("text_color"),attr.getJSONObject("font").getInt("size")).let {
                        Card(Title(words,it),Description(null,it),Image.default)
                    }
                }
            }
        }else if(s=="title_description"){
            Card(getJSONObject("title").getTitleFromJson(),getJSONObject("description").getDescriptionFromJson(),Image.default)
        }else{
            Card(getJSONObject("title").getTitleFromJson(),getJSONObject("description").getDescriptionFromJson(),getJSONObject("image").getImageFromJSON())
        }
    }

    private fun JSONObject.getImageFromJSON(): Image {
        val size =getJSONObject("size")
        return Image(getString("url"),Size(size.getInt("width"),size.getInt("height")))
    }

    private fun JSONObject.getDescriptionFromJson(): Description {
        return Description(getString("value"),getJSONObject("attributes").getAttributeFromJSON())
    }

    private fun JSONObject.getTitleFromJson(): Title {
        return Title(getString("value"),getJSONObject("attributes").getAttributeFromJSON())
    }
    private fun JSONObject.getAttributeFromJSON():Attributes{
        return Attributes(getString("text_color"),getJSONObject("font").getInt("size"))
    }
}