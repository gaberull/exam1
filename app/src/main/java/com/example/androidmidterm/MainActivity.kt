package com.example.androidmidterm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject

/*
This project and source code was cloned from CodyStandridge at https://github.com/CodyStandridge/AndroidMidTerm
and is meant to be used as a reference or starting base code for the Exam 1 - Individual Effort
Feel free to use, modify, or redistribute this code :)
*/

class MainActivity : AppCompatActivity() {

    // Notice that this is only called when the Activity is created. Every time an orientation change is made
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Go to res->layout->activity_main.xml
        setContentView(R.layout.activity_main)

        // Volley uses internet permissions which needs to be enabled in the AndroidManifest.xml
        // Go to app->manifests->AndroidManifest.xml to view these permissions. (The permission is already there)
        val queue = Volley.newRequestQueue(this)

        // Echo API Post request with JsonObjectRequest
        val url = "https://cocomo-python-api.appspot.com/_ah/api/echo/v1/echo"

        // button refers to the Button in activity_main.xml
        button.setOnClickListener {

            val postParameters = JSONObject()
            try {
                val message: String = eventMessage.text.toString()
                postParameters.put("message", message)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            val request = JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    postParameters,
                    Response.Listener<JSONObject> { response ->
                        val event = response
                        // event has a yellow squiggly underneath it because it is redundant
                        // Try removing it automatically by using the shortcut Alt+Enter -> Inline Variable
                        eventTitle.text = "${event.getString("message")}"
                        // eventTitle refers to the TextView in activity_main.xml
                    },
                    // The same way we get the response info from a successful API call we can get error info
                    Response.ErrorListener { error ->
                        eventTitle.text = "Error calling API. ${error.message}"
                    }
            )

            queue.add(request)
        }

//        https://github.com/CodyStandridge/AndroidMidTerm
//        // OU Calendar url
//        // TODO: change this to your url after you have endpoints
//        val url = "https://calendar.ou.edu/live/json/events"
//
//        // OU calendar returns a Json Array, if your website returns a Json Object then use JsonObjectRequest
//        val stringRequest = JsonArrayRequest(Request.Method.GET, url, null,
//            Response.Listener<JSONArray> { response ->
//                val event = response[0] as JSONObject
//                // eventTitle is the id for the textbox in activity_main.xml
//                eventTitle.text = "Event title is : ${event.getString("title")}"
//            },
//            Response.ErrorListener { eventTitle.text = "That didn't work" })
//
//        // button is the id for the button in activity_main.xml
//        button.setOnClickListener {
//            queue.add(stringRequest)
//        }
    }
}

/*
References
https://github.com/CodyStandridge/AndroidMidTerm
https://kotlinlang.org/docs/tutorials/kotlin-for-py/declaring-variables.html
https://medium.com/mindorks/lambda-function-in-kotlin-22ded595298
 */