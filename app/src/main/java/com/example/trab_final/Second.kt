package com.example.trab_final

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.trab_final.ui.theme.Trab_finalTheme

class Second : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Trab_finalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SecondApp()
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun SecondApp(){
    val context= LocalContext.current
    Column(verticalArrangement = Arrangement.Center) {
        Button(
            onClick = { /* Handle login */
                composeEmail(context, arrayOf("email@email.com"), "Assunto do email")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue
            )
        ){
            Text("Send a email", color = Color.White)
        }
    }
}

fun composeEmail(context: Context, address: Array<String>, subject:String){
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "*/"
        putExtra(Intent.EXTRA_EMAIL, address)
        putExtra(Intent.EXTRA_SUBJECT, subject)
    }

    startActivity(context, Intent.createChooser(intent, "Send Email"),
    null)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Trab_finalTheme {
        Greeting2("Android")
    }
}