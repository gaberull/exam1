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

The first thing you'll notice about Kotlin is that there are no semicolons :)
The next thing you may notice is that it is similar to Python syntax :)
The last thing you'll notice is that there are weird ?, !, and -> symbols that you have no idea what they mean :(

Don't worry, it's simple.
Kotlin requires you to be specific when it comes to whether or not you want something to be nullable
This means no more NullPointerErrors because it is always defined :)

? means you are allowing nullable types
! mean do not allow nullable
-> is a way to define a lambda function. "Lambdas function is essentially anonymous functions that
    we can treat as values — we can, for example, pass them as arguments to methods, return them,
    or do any other thing we could do with a regular object." (Sachin Kumar)
 */

class MainActivity : AppCompatActivity() {

    /*
    Notice that this is only called when the Activity is created. Every time an orientation change is made
    the activity will be recreated. Try changing from Portrait mode to Landscape to see what happens.
    You must implement an onResume, onPause and cache your response to save between state changes.
    This is beyond the scope of the project, but it's worth noting.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        Go to res->layout->activity_main.xml
        This is what will be displayed for the activity. Try adding a text box or another button.
        Careful though, you need to add constraints or else you may not see what you've added when you re-run your app.
         */
        setContentView(R.layout.activity_main)

        /*
        Volley uses internet permissions which needs to be enabled in the AndroidManifest.xml
        Go to app->manifests->AndroidManifest.xml to view these permissions. (The permission is already there)
        Volley handles the actual call to your API
        (this) keyword is referring to the context of MainActivity
        (val) is how constant variables are declared in Kotlin
        (var) is how you declare mutable variables
        Types are implicit in Kotlin, but can be declare explicitly if you so wish to (the below is equivalent)
            - ex. val queue: RequestQueue! = Volley.newRequestQueue(this)
            - ie queue is of type RequestQueue!
            - hover over the variable queue and you'll get a popup with the type RequestQueue!
         */
        val queue = Volley.newRequestQueue(this)

        // Echo API Post request with JsonObjectRequest
        val url = "https://endpoint-294002.uc.r.appspot.com/demo"

        /*
        button refers to the Button in activity_main.xml
        The type Button has it's own handler for triggering logic when clicked
        This listener is actually inherited from it's parent class of type View
        Most things you can put into activity_main.xml inherit from View
        Therefore, most have access to setOnClickListener. Don't believe me?
        Try adding a listener to the eventTitle TextView
         */
        button.setOnClickListener {

            var message: String=""
            val postParameters = JSONObject()
            try {
                message = eventMessage.text.toString()
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            val request = JsonObjectRequest(
                Request.Method.GET,
                url+"?loc="+message,
                null,
                Response.Listener<JSONObject> { response ->
                    /*
                    event has a yellow squiggly underneath it because the IDE is trying to tell you that
                    there is no reason to declare a different variable in this scope. You should just use
                    response and remove this 'inline' variable that is redundant
                    Try removing it automatically by using the shortcut Alt+Enter -> Inline Variable
                     */
                    //                eventTitle.text = "${event.getString("title")}" Example of error that crashes app
                    effortview.text = "${response.getString("effort")}"
                    /*
                    eventTitle refers to the TextView in activity_main.xml
                    Go to it quickly by holding Ctrl+Click eventTitle
                     */
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