package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AdoptTheme
import com.example.myapp.Models.HistorialServiciosModel
import com.example.myapp.Models.MisArbolesModel
//import com.example.myapp.ui.theme.MyappTheme

class HistorialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdoptTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting3()
                }
            }
        }
    }
}

@Composable
fun Greeting3(modifier: Modifier = Modifier) {
    val misArboles: List<HistorialServiciosModel> = listOf<HistorialServiciosModel>(
        HistorialServiciosModel("Poda", "12 de octubre",R.drawable.poda),
        HistorialServiciosModel("Riego", "5 de julio",R.drawable.riego1),
        HistorialServiciosModel("Fertilizacion", "1 de noviembre",R.drawable.fertilizante),
    )

    Column {
        Text(
            text = "Historial de servicios",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier=Modifier.padding(16.dp)
        )
        LazyColumn(modifier = modifier
            .fillMaxSize()) {

            items(misArboles) { data ->
                DrawHistoryCard(data,modifier.padding(8.dp))
            }
        }
    }


}

@Composable
fun DrawHistoryCard(data: HistorialServiciosModel, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = modifier
        .animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioNoBouncy,
                stiffness = Spring.StiffnessMedium
            ))
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

                Text(
                    text = data.Servicio,
                    modifier = Modifier
                        .padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(Modifier.weight(1f))

                IconButton(
                    modifier = Modifier
                        .size(64.dp)
                        .padding(16.dp),
                    onClick = {
                        expanded = !expanded
                    })
                {
                    Icon(
                        painterResource(
                            id = if(expanded) R.drawable.arrow_up_24 else R.drawable.arrow_down_24),
                        contentDescription = null)
                }
            }

            if (expanded) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = data.Fecha,
                        modifier = Modifier,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    AdoptTheme(darkTheme = false) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting3()
        }
    }
}
@Preview
@Composable
fun GreetingDarkPreview6() {
    AdoptTheme(darkTheme = true) {
        Greeting3()
    }
}