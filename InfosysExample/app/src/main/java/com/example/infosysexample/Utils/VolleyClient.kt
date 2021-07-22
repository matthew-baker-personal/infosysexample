package com.example.infosysexample.Utils

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.Volley
import com.example.infosysexample.dataclasses.CardG
import org.json.JSONObject
import java.lang.Exception
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit

//we need to declare the internet permission in our manifest to use volley here
object VolleyClient {
    //normally this would be a base URL but since we currently only have one api call to make we
    //  keep it as just our one URL
    const val URL="https://private-8ce77c-tmobiletest.apiary-mock.com/test/home"
    private lateinit var queue: RequestQueue

    //make our request queue
    fun setQueue(c: Context){
        //check if we have a queue yet, if not make one
        if (!this::queue.isInitialized)
            queue = Volley.newRequestQueue(c)
    }

    fun getCardsG():List<CardG>{
        // using a future object to make this request appear syncronous to outside code
        val future=RequestFuture.newFuture<JSONObject>()

        val request=JsonObjectRequest(Request.Method.GET,URL,null,future,future)

        queue.add(request)
        return try {
            // Timeout included here in case the response never arrives
            JsonDeserializer.getCardsGFromJson(future.get(30, TimeUnit.SECONDS))

            //default card lists in case of error
        }catch(e:InterruptedException){
            ArrayList<CardG>().apply{
                add(CardG.default)
            }
        }catch (e:ExecutionException){
            ArrayList<CardG>().apply{
                add(CardG.default)
            }
        }
    }
}