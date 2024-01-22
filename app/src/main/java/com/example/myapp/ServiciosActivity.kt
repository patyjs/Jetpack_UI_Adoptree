package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AdoptTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ServiciosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting5()
        }
    }
}

data class TipoServiciosModel(val Servicio: String, val ImageId: Int)

@OptIn( ExperimentalMaterial3Api::class)
@Composable
fun CustomDialog(
    showDialog: Boolean,
    onCloseDialog: () -> Unit,
    onComment: (String) -> Unit
) {
    if (showDialog) {
        var commentText by remember { mutableStateOf("") }

        AlertDialog(
            onDismissRequest = { onCloseDialog() },
            title = { Text(text = "Agregar Comentario") },
            text = {
                Column {
                    TextField(
                        value = commentText,
                        onValueChange = { commentText = it },
                        label = { Text("Comentario") },
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .height(120.dp)
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onComment(commentText)
                        onCloseDialog()
                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("Comentar")
                }
            },
            dismissButton = {
                Button(
                    onClick = { onCloseDialog() },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("Cancelar")
                }
            }
        )
    }
}




@Composable
fun DrawServicioCard(
    data: TipoServiciosModel,
    modifier: Modifier = Modifier,
    showDialog: () -> Unit // Callback para mostrar el diálogo de comentario
) {
    var expanded by remember { mutableStateOf(false) }
    val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())

    Card(
        modifier = modifier.fillMaxWidth().clickable {
            expanded = !expanded
            showDialog() // Llama al callback para mostrar el diálogo cuando se hace clic en el CardView
        },
        shape = RoundedCornerShape(8.dp),

    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(data.ImageId),
                contentDescription = null,
                modifier = Modifier
                    .size(75.dp)
                    .clip(RoundedCornerShape(38.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = data.Servicio,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        if (expanded) {
            val currentDate = Calendar.getInstance().time
            val formattedDate = dateFormat.format(currentDate)

            Text(
                text = "Registrado!: $formattedDate",
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun Greeting5(modifier: Modifier = Modifier) {
    val misArboles: List<TipoServiciosModel> = listOf(
        TipoServiciosModel("Podar", R.drawable.pod),
        TipoServiciosModel("Regar", R.drawable.ri),
        TipoServiciosModel("Fertilizar", R.drawable.fertilizante),
        TipoServiciosModel("Crecimiento", R.drawable.crecimiento)

    )

    var showDialog by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        Text(
            text = "Servicios",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(misArboles) { data ->
                DrawServicioCard(data, modifier.padding(8.dp)) {
                    // Al hacer clic en el CardView, mostrar el diálogo
                    showDialog = true
                }
            }
        }

        // Lógica para mostrar el diálogo de comentario
        if (showDialog) {
            CustomDialog(
                showDialog = showDialog,
                onCloseDialog = { showDialog = false },
                onComment = { comment ->
                    // Lógica para procesar el comentario
                    println("Comentario ingresado: $comment")
                    showDialog = false // Cierra el diálogo después de comentar
                }
            )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview9() {
    AdoptTheme(darkTheme = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        )
        {
            Greeting5()
        }
        }
    }

@Preview(showBackground = true)
@Composable
fun GreetingDarkPreview9() {
    AdoptTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        )
        {
            Greeting5()
        }
    }
}

