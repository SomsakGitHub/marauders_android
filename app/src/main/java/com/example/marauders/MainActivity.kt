package com.example.marauders

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.marauders.ui.theme.MaraudersTheme
import okhttp3.ResponseBody
import retrofit2.Retrofit


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaraudersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
//                    LoginScreen()
                    var text = ""

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TextField(
                            value = text,
                            onValueChange = { text = it },
                            label = { Text("username") }
                        )

                        TextField(
                            value = text,
                            onValueChange = { text = it },
                            label = { Text("password") }
                        )

                        Button(onClick = {
                            NetworkConnectionManager().callServer(
                                networkCallbackListener,
                                "somsakGitHub"
                            )
                        }) {
                            Text(text = "Login")
                        }
                    }
                }
            }
        }
    }

    var networkCallbackListener: OnNetworkCallbackListener = object : OnNetworkCallbackListener {
        override
        fun onResponse(user: User?, retrofit: Retrofit?) {
            Log.e("logUser=>",user?.node_id.toString())
        }

        override fun onBodyError(responseBodyError: ResponseBody?) {
            //404 (error not null)
        }

        override fun onBodyErrorIsNull() {
            //404 (error is null)
        }

        override fun onFailure(t: Throwable?) {
            //fail any course
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaraudersTheme {
        Greeting("Android")
    }
}