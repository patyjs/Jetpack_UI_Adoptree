package com.example.myapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.ui.theme.MyappTheme

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InitializeUI("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InitializeUI(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    var email_txt by remember { mutableStateOf("") }
    var password_txt by remember { mutableStateOf("") }

    Column( // PARA COLOCAR ELEMENTOS DE FORMA VERTICAL (UNO ENCIMA DE OTRO)
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp))
    {
        Image(
            painter = painterResource(id = R.drawable.splash_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(270.dp)
        )

        // SE UTLILIZAN COLUMNAS ANIDADAS PARA AGRUPAR Y ORGANIZAR ELEMENTOS, SIN PERDER EL APILAMIENTO VERTICAL
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally, //centrar elementos de forma horizontal
        ) {
            Text(
                text = "Iniciar sesion",
                modifier = modifier,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            //horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            // Text(
            //     text = "Correo electronico",
            //     modifier = modifier
            // )

            //Image(
              //  painter = painterResource(id = R.drawable.arroba_email_24),
                //contentDescription = null,
                //modifier = Modifier
                  //  .width(36.dp)
            //)

            // Spacer(modifier = Modifier.width(12.dp))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = email_txt,
                label = { Text( "Correo electronico") },
                leadingIcon = {
                    Icon(painterResource(id = R.drawable.arroba_email_24),
                        contentDescription = null)
                },
                onValueChange = { entry ->
                    email_txt = entry
                }
            )
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            //horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Text(
            //     text = "Contrasena",
            //     modifier = modifier
            // )

            // Image(
               // painter = painterResource(id = R.drawable.password_24),
                //contentDescription = null,
               // modifier = Modifier
                 //   .width(36.dp)
            //)

            // Spacer(modifier = Modifier.width(12.dp))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = password_txt,
                label = { Text( "Contrasena") },
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = {
                      Icon(painterResource(id = R.drawable.password_24),
                      contentDescription = null)
                },
                onValueChange = { entry ->
                    password_txt = entry
                }
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp),
            onClick = {  }
        ) {
            Text("Acceder")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally, //centrar elementos de forma horizontal


        ) {
            Text(
                text = "¿No tienes una cuenta?",
                modifier = modifier,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )

            ClickableText(
                text = AnnotatedString(
                    text = "Crea una aquí.",
                ),
                modifier = modifier,
                onClick = {
                    // INICIA UN ACTIVITY NUEVO DE LA CLASE REGISTROACTIVITY Y NAVEGA A SU INTERFAZ
                    context.startActivity(Intent(context, RegistroActivity::class.java))
                }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyappTheme {
        InitializeUI("Android")
    }
}