package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.Models.MisArbolesModel
import com.example.myapp.ui.theme.MyappTheme

class MisArbolesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CargarMisArboles()
                }
            }
        }
    }
}

@Composable
fun CargarMisArboles(modifier: Modifier = Modifier) {
    val misArboles: List<MisArbolesModel> = listOf<MisArbolesModel>(
        MisArbolesModel("Honestidad", "Ahuehuete",R.drawable.img),
        MisArbolesModel("Honestidad", "Ahuehuete",R.drawable.img),
        MisArbolesModel("Honestidad", "Ahuehuete",R.drawable.img),
    )

    Column() {
        Text(
            text = "Mis árboles",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier=Modifier.padding(16.dp)
        )
        LazyColumn(modifier = modifier
            .fillMaxSize()) {

            items(misArboles) { data ->
                DrawCard(data,modifier.padding(8.dp))
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End)
    {
        FloatingActionButton(
            onClick = { },
        ) {
            Icon(Icons.Filled.Add, "Floating action button.")
        }
    }

}

@Composable
fun DrawCard(arbolData :MisArbolesModel, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row() {
            Image(
                painter = painterResource(arbolData.ImageId),
                contentDescription = "",
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 8.dp)) {
                Text(
                    text = arbolData.ValorMoral,
                    modifier = Modifier,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = arbolData.NombreArbol,
                    modifier = Modifier,
                    style = MaterialTheme.typography.headlineSmall
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    MyappTheme {
        CargarMisArboles()
    }
}