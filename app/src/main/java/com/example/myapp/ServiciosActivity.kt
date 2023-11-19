package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AdoptTheme
import com.example.myapp.Models.HistorialServiciosModel
import com.example.myapp.Models.TipoServiciosModel


class ServiciosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdoptTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting5()
                }
            }
        }
    }
}

@Composable
fun Greeting5(modifier: Modifier = Modifier) {

    val misArboles: List<TipoServiciosModel> = listOf<TipoServiciosModel>(
        TipoServiciosModel("Poda", R.drawable.poda),
        TipoServiciosModel("Riego", R.drawable.poda),
        TipoServiciosModel("Fertilización", R.drawable.poda),

    )

    Column {
        Text(
            text = "Servicios",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier=Modifier.padding(16.dp)
        )
        LazyColumn(modifier = modifier
            .fillMaxSize()) {

            items(misArboles) { data ->
                DrawServicioCard(data,modifier.padding(8.dp))
            }
        }
    }


}

@Composable
fun DrawServicioCard(data: TipoServiciosModel, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = modifier
        .fillMaxWidth()
    ) {
        Column {
            Row {
                Image(
                    painter = painterResource(data.ImageId),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(24.dp, 24.dp, 0.dp, 24.dp)
                        .width(75.dp)
                        .height(75.dp)
                        .clip(RoundedCornerShape(38.dp)),
                    contentScale = ContentScale.Crop
                )

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)) {
                    Text(
                        text = data.Servicio,
                        modifier = Modifier
                            ,
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Row {
                        Button(modifier = Modifier,
                            onClick = {  }) {
                            Text("Registrar")

                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(modifier = Modifier,
                            onClick = {  }) {
                            Text("Comentar")

                        }
                    }
                }
            }
        }


    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview8() {
    AdoptTheme() {
        Greeting5()
    }
}