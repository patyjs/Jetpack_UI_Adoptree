package com.example.myapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.input.key.Key.Companion.Calendar
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.ui.theme.MyappTheme

class RegistroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InitializeRegistroUI("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun InitializeRegistroUI(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    var name_txt by remember { mutableStateOf("") }
    var pat_txt by remember { mutableStateOf("") }
    var mat_txt by remember { mutableStateOf("") }
    var email_txt by remember { mutableStateOf("") }
    var password_txt by remember { mutableStateOf("") }
    var password2_txt by remember { mutableStateOf("") }
    var cel_txt by remember { mutableStateOf("") }
    var curp_txt by remember { mutableStateOf("") }
    var selectedDateText by remember { mutableStateOf("") }

    // SE INICIALIZA UNA VARIABLE CON UN OBJETO DEL TIPO DATEPICKERDIALOG, CON UNA FECHA PREDETERMINADA DE 01/06/2022
    // PARA MANDARLO A LLAMAR DESDE LA ORDEN DE EJECUCION DE UN BOTON
    // EL DATEPICKER NO ES UN ELEMENTO DE LA INTERFAZ, ES UN ELEMENTO EMERGENTE DEL SISTEMA QUE SE LLAMA EN EL MOMENTO DE SER REQUERIDO
    val datePicker = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
            selectedDateText = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
        }, 2023, 6, 1
    )


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
                text = "Registro",
                modifier = modifier,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 0.dp)
                    .verticalScroll(rememberScrollState())){
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = name_txt,
                label = { Text( "Nombre(s)") },
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.persona_24),
                        contentDescription = null)
                },
                onValueChange = { entry ->
                    name_txt = entry
                })

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = pat_txt,
                label = { Text( "Apellido paterno") },
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.persona_24),
                        contentDescription = null)
                },
                onValueChange = { entry ->
                    pat_txt = entry
                })

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = mat_txt,
                label = { Text( "Apellido materno") },
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.persona_24),
                        contentDescription = null)
                },
                onValueChange = { entry ->
                    mat_txt = entry
                })

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = email_txt,
                label = { Text( "Correo") },
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.arroba_email_24),
                        contentDescription = null)
                },
                onValueChange = { entry ->
                    email_txt = entry
                })

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = password_txt,
                label = { Text( "Crear contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.password_24),
                        contentDescription = null)
                },
                onValueChange = { entry ->
                    password_txt = entry
                })

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = password2_txt,
                label = { Text( "Repetir contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.password_24),
                        contentDescription = null)
                },
                onValueChange = { entry ->
                    password2_txt = entry
                })

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ){
                OutlinedTextField(
                    modifier = Modifier
                        .clickable(enabled = false) {  }
                        .fillMaxWidth(0.8f),

                    value = selectedDateText,
                    label = { Text( "Fecha de nacimiento" ) },
                    leadingIcon = {
                        Icon(
                            painterResource(id = R.drawable.calendar_month_24),
                            contentDescription = null)
                    },
                    onValueChange = { entry ->
                        password_txt = entry
                    })

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .align(Alignment.CenterVertically),
                    onClick = {
                        // MUESTRA UN DATEPICKER DEL SISTEMA
                        datePicker.show()
                    })
                {
                    Icon(
                        painterResource(id = R.drawable.edit_calendar_24),
                        contentDescription = null)
                }
            }



            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = cel_txt,
                label = { Text( "Número celular") },
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.phone_24),
                        contentDescription = null)
                },
                onValueChange = { entry ->
                    cel_txt = entry
                })

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = curp_txt,
                label = { Text( "Curp") },
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.curp_24),
                        contentDescription = null)
                },
                onValueChange = { entry ->
                    curp_txt = entry
                })

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp, vertical = 16.dp),
                onClick = {  }
            ) { Text("Registrar") }

            }
        }
    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    MyappTheme {
        InitializeRegistroUI("Android")
    }
}