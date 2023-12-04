package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AdoptTheme


class RecuperacionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdoptTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting4("Android")
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Greeting4(name: String, modifier: Modifier = Modifier) {

    var email_txt by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Image(
            painter = painterResource(id = R.drawable.recuperacion),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(300.dp)
                .padding(vertical = 20.dp)
        )

        Text(
            text = "Restablecimiento de contraseña",
            modifier = modifier,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 20.dp)) {

            Text(
                text = "Ingresa tu dirección de correo electrónico asociada con tu cuenta.",
                modifier = modifier,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal

            )
            Text(
                text = "Te enviaremos un enlace de verificación.",
                modifier = modifier,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)

        ) {

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = email_txt,
                label = { Text("Correo") },

                onValueChange = { entry ->
                    email_txt = entry
                })


        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 16.dp),
            onClick = {  }
        ) { Text("Recuperar cuenta") }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    AdoptTheme(darkTheme = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        )
        {
            Greeting4("Android")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingDarkPreview7() {
    AdoptTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        )
        {
            Greeting4("Android")
        }
    }
}