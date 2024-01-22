package com.example.myapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AdoptTheme
//import com.example.myapp.ui.theme.MyappTheme

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdoptTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InitializeUI("Android",isSystemInDarkTheme())
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InitializeUI(name: String, darktheme: Boolean,modifier: Modifier = Modifier) {

    var email_txt by remember { mutableStateOf("") }
    var password_txt by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        if (!darktheme){
            Image(
                painterResource(id = R.drawable.splash_image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(270.dp)
                    .fillMaxWidth()
            )
        } else {
            Image(
                painterResource(id = R.drawable.bannernight),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(270.dp)
                    .fillMaxWidth()
            )
        }

        Surface(
            color = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(
                topStartPercent = 6,
                topEndPercent = 6
            ),
            modifier = Modifier
                .padding(top = 250.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Iniciar sesión",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 32.dp, 0.dp, 0.dp),
                    value = email_txt,
                    label = { Text("Correo electrónico") },
                  //  leadingIcon = {
                    //    Icon(
                    //        painterResource(id = R.drawable.arroba_email_24),
                    //        contentDescription = null
                    //    )
                   // },
                    onValueChange = { entry ->
                        email_txt = entry
                    }
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = password_txt,
                    label = { Text("Contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                   // leadingIcon = {
                     //   Icon(
                        //    painterResource(id = R.drawable.password_24),
                        //    contentDescription = null
                      //  )
                  //  },
                    onValueChange = { entry ->
                        password_txt = entry
                    }
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 0.dp, vertical = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally, //centrar elementos de forma horizontal


                ) {
                    Text(
                        text = "¿Olvidaste tu contraseña?",
                        modifier = modifier,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )

                    ClickableText(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(MaterialTheme.colorScheme.primary)
                            ) {
                                append("Haz click aqui")
                            }
                        },
                        modifier = modifier,
                        onClick = {
                            // INICIA UN ACTIVITY NUEVO DE LA CLASE REGISTROACTIVITY Y NAVEGA A SU INTERFAZ
                            //context.startActivity(Intent(context, RegistroActivity::class.java))
                        }
                    )

                }

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp, vertical = 0.dp),
                    onClick = {  }
                ) {
                    Text("Acceder")
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 0.dp, vertical = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally, //centrar elementos de forma horizontal


                ) {
                    Text(
                        text = "¿No tienes una cuenta?",
                        modifier = modifier,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )

                    ClickableText(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(MaterialTheme.colorScheme.primary)
                            ) {
                                append("Crea tu cuenta aqui")
                            }
                        },
                        modifier = modifier,
                        onClick = {
                            // INICIA UN ACTIVITY NUEVO DE LA CLASE REGISTROACTIVITY Y NAVEGA A SU INTERFAZ
                            //context.startActivity(Intent(context, RegistroActivity::class.java))
                        }
                    )

                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    AdoptTheme(darkTheme = false) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            InitializeUI("Android",false)
        }
    }
}

@Preview
@Composable
fun GreetingDarkPreview2() {
    AdoptTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            InitializeUI("",true)
        }
    }
}
