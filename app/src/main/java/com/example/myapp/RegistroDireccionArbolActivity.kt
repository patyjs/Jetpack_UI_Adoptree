package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.ui.theme.MyappTheme

class RegistroDireccionArbolActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Greeting(modifier: Modifier = Modifier) {

    var calle_txt by remember { mutableStateOf("") }
    var numExt_txt by remember{ mutableStateOf("") }
    var numInt_txt by remember{ mutableStateOf("") }
    var colonia_txt by remember { mutableStateOf("") }
    var cp_txt by remember { mutableStateOf("") }
    var estado_txt by remember { mutableStateOf("") }
    var ciudad_txt by remember { mutableStateOf("") }

    Column( // PARA COLOCAR ELEMENTOS DE FORMA VERTICAL (UNO ENCIMA DE OTRO)
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
            .verticalScroll(rememberScrollState()))
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
                text = "¿Donde está tu árbol?",
                modifier = modifier,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 0.dp)
                ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = calle_txt,
                label = { Text("Calle") },
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.house_24),
                        contentDescription = null
                    )
                },
                onValueChange = { entry ->
                    calle_txt = entry
                })

            Row() {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(0.5f),
                    value = numExt_txt,
                    label = { Text("Núm. Ext.") },
                    leadingIcon = {
                        Icon(
                            painterResource(id = R.drawable.gato_24),
                            contentDescription = null
                        )
                    },
                    onValueChange = { entry ->
                        numExt_txt = entry
                    })

                Spacer(modifier = Modifier.width(8.dp))

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = numInt_txt,
                    label = { Text("Núm. Int.") },
                    leadingIcon = {
                        Icon(
                            painterResource(id = R.drawable.gato_24),
                            contentDescription = null
                        )
                    },
                    onValueChange = { entry ->
                        numInt_txt = entry
                    })
            }

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = colonia_txt,
                label = { Text("Colonia") },
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.colonia_24),
                        contentDescription = null
                    )
                },
                onValueChange = { entry ->
                    colonia_txt = entry
                })
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = ciudad_txt,
                label = { Text("Ciudad") },
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.colonia_24),
                        contentDescription = null
                    )
                },
                onValueChange = { entry ->
                    ciudad_txt = entry
                })

            OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
            value = estado_txt,
            label = { Text("Estado") },
            leadingIcon = {
                Icon(
                    painterResource(id = R.drawable.colonia_24),
                    contentDescription = null
                )
            },
            onValueChange = { entry ->
                estado_txt = entry
            })
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = cp_txt,
                label = { Text("Código postal") },
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.gato_24),
                        contentDescription = null
                    )
                },
                onValueChange = { entry ->
                    cp_txt = entry
                })

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp, vertical = 16.dp),
                onClick = { }
            ) { Text("Registrar") }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyappTheme {
        Greeting()
    }
}