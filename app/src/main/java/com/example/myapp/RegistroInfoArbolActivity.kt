package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AdoptTheme
//import com.example.myapp.ui.theme.MyappTheme

class RegistroInfoArbolActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdoptTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Greeting2(modifier: Modifier = Modifier) {
    val options = listOf("", "Responsabilidad", "Respeto", "Tolerencia", "Compromiso","Equidad")
    val options2 = listOf("", "Palo de rosa", "Mezquite", "Huizache", "Acacia", "Mimbre")
    val options3 = listOf("", "Siembra", "Adopción")
    var expanded by remember { mutableStateOf(false) }
    var expanded2 by remember { mutableStateOf(false) }
    var expanded3 by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }
    var selectedOptionText2 by remember { mutableStateOf(options[0]) }
    var selectedOptionText3 by remember { mutableStateOf(options[0]) }

    var tamaño_txt by remember { mutableStateOf("") }
    var perimetro_txt by remember { mutableStateOf("") }
    var tipo_txt by remember { mutableStateOf("") }

    Column( // PARA COLOCAR ELEMENTOS DE FORMA VERTICAL (UNO ENCIMA DE OTRO)
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
    )
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
                text = "Registra tu árbol",
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

            Row(modifier = Modifier
                .fillMaxWidth()) {

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    value = selectedOptionText,
                    readOnly = true,
                    label = { Text("Valor") },
                   // leadingIcon = {
                     //   Icon(
                       //     painterResource(id = R.drawable.estrellas_24),
                       //     contentDescription = null
                     //   )
                 //   },
                    onValueChange = { })

                Spacer(modifier = Modifier.width(8.dp))

                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                ) {
                    IconButton(
                        modifier = Modifier,
                        onClick = {
                            expanded = !expanded
                        })
                    {
                        Icon(
                            painterResource(id = R.drawable.search_24),
                            contentDescription = null)
                    }

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        options.forEach{
                                item -> DropdownMenuItem(
                            text = { Text(text = item) },
                            onClick = {
                                selectedOptionText = item
                                expanded = false
                            })
                        }
                    }
                }
            }

            Row(modifier = Modifier
                .fillMaxWidth()) {

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    value = selectedOptionText2,
                    readOnly = true,
                    label = { Text("Nombre generico") },
                  //  leadingIcon = {
                      //  Icon(
                          //  painterResource(id = R.drawable.texto_generico_24),
                          //  contentDescription = null
                      //  )
                  //  },
                    onValueChange = { })

                Spacer(modifier = Modifier.width(8.dp))

                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                ) {
                    IconButton(
                        modifier = Modifier,
                        onClick = {
                            expanded2 = !expanded2
                        })
                    {
                        Icon(
                            painterResource(id = R.drawable.search_24),
                            contentDescription = null)
                    }

                    DropdownMenu(
                        expanded = expanded2,
                        onDismissRequest = { expanded2 = false }
                    ) {
                        options2.forEach{
                                item -> DropdownMenuItem(
                            text = { Text(text = item) },
                            onClick = {
                                selectedOptionText2 = item
                                expanded2 = false
                            })
                        }
                    }
                }
            }


            Row(modifier = Modifier
                .fillMaxWidth()) {

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    value = selectedOptionText3,
                    readOnly = true,
                    label = { Text("Tipo de adopción") },
                    onValueChange = { })

                Spacer(modifier = Modifier.width(8.dp))

                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                ) {
                    IconButton(
                        modifier = Modifier,
                        onClick = {
                            expanded3 = !expanded3
                        })
                    {
                        Icon(
                            painterResource(id = R.drawable.search_24),
                            contentDescription = null)
                    }

                    DropdownMenu(
                        expanded = expanded3,
                        onDismissRequest = { expanded3 = false }
                    ) {
                        options3.forEach{
                                item -> DropdownMenuItem(
                            text = { Text(text = item) },
                            onClick = {
                                selectedOptionText3 = item
                                expanded3 = false
                            })
                        }
                    }
                }
            }


            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = tamaño_txt,
                label = { Text("Tamaño") },
              //  leadingIcon = {
                 //   Icon(
                     //   painterResource(id = R.drawable.circle_24),
                     //   contentDescription = null
                 //   )
               // },
                onValueChange = { entry ->
                    tamaño_txt = entry
                })

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = perimetro_txt,
                label = { Text("Perímetro") },
               // leadingIcon = {
                //    Icon(
                  //      painterResource(id = R.drawable.circle_24),
                  //      contentDescription = null
                  //  )
              //  },
                onValueChange = { entry ->
                    perimetro_txt = entry
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
fun GreetingPreview4() {
    AdoptTheme(darkTheme = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        )
        {
            Greeting2()
    }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingDarkPreview4() {
    AdoptTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        )
        {
            Greeting2()
        }
    }
}