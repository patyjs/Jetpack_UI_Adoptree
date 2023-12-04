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
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.Color
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
        HistorialServiciosModel("8335896325", "Podar","12 de octubre 2023",R.drawable.pod),
        HistorialServiciosModel("8335896325","Regar", "5 de julio",R.drawable.ri),
        HistorialServiciosModel("8335896325","Fertilizar", "1 de noviembre",R.drawable.fertilizante),
        HistorialServiciosModel("8335896325", "Podar","12 de octubre",R.drawable.pod),
        HistorialServiciosModel("8335896325","Regar", "5 de julio",R.drawable.ri),
        HistorialServiciosModel("8335896325","Fertilizar", "1 de noviembre",R.drawable.fertilizante),
        HistorialServiciosModel("8335896325", "Podar","12 de octubre",R.drawable.pod),
        HistorialServiciosModel("8335896325","Regar", "5 de julio",R.drawable.ri),
        HistorialServiciosModel("8335896325","Fertilizar", "1 de noviembre",R.drawable.fertilizante),
        HistorialServiciosModel("8335896325", "Podar","12 de octubre 2023",R.drawable.pod),
        HistorialServiciosModel("8335896325","Regar", "5 de julio",R.drawable.ri),
        HistorialServiciosModel("8335896325","Fertilizar", "1 de noviembre",R.drawable.fertilizante),
        HistorialServiciosModel("8335896325", "Podar","12 de octubre",R.drawable.pod),
        HistorialServiciosModel("8335896325","Regar", "5 de julio",R.drawable.ri),
        HistorialServiciosModel("8335896325","Fertilizar", "1 de noviembre",R.drawable.fertilizante),
        HistorialServiciosModel("8335896325", "Podar","12 de octubre",R.drawable.pod),
        HistorialServiciosModel("8335896325","Regar", "5 de julio",R.drawable.ri),
        HistorialServiciosModel("8335896325","Fertilizar", "1 de noviembre",R.drawable.fertilizante),
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
    Column(modifier = Modifier
        .padding(16.dp, 8.dp)) {
        Row(modifier = Modifier
            .fillMaxWidth()) {
            Image(
                painter = painterResource(data.ImageId),
                contentDescription = "",
                modifier = Modifier
                    .width(65.dp)
                    .height(65.dp)
                    .clip(RoundedCornerShape(38.dp)),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier
                .padding(16.dp, 0.dp)
                .fillMaxWidth(),
                verticalArrangement = Arrangement.Center ){
                Text(
                    text = data.Servicio,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = data.Fecha,
                    style = MaterialTheme.typography.bodySmall
                )
                //Spacer(Modifier.weight(1f))

            }
        }

        Divider(color = Color.LightGray, thickness = 2.dp, modifier = Modifier)
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
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting3()
        }
    }
}
