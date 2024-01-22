package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.compose.AdoptTheme
import com.example.compose.md_theme_dark_onPrimary
import com.example.compose.md_theme_light_logo
import com.example.compose.md_theme_light_onPrimaryContainer
import com.example.compose.md_theme_light_primaryContainer
import com.example.myapp.ui.theme.dodge

//import com.example.myapp.ui.theme.MyappTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdoptTheme() {
                // A surface container using the 'background' color from the theme
                val context = LocalContext.current
                WindowCompat.setDecorFitsSystemWindows(window, false)
                window.statusBarColor = Color.Transparent.toArgb()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting6()
                }
            }
        }
    }
}

@Composable
fun Greeting6(modifier: Modifier = Modifier) {

    Box( //para delimitar el tamaño completo de la pantalla en la vista previa
        modifier = Modifier
            .background(Color(red = 254, green = 255, blue = 227))
            .fillMaxSize()
    )
    {
        Column(
            // PARA COLOCAR ELEMENTOS DE FORMA VERTICAL (UNO ENCIMA DE OTRO)
            modifier = Modifier
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally, //alinea los elementos de la columna horizontalmente centrados
        )
        {
            Image(
                painter = painterResource(id = R.drawable.imagotipoapp1),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
            )

            Text(
                text = "Siembra Valores",
                modifier = modifier,
                fontSize = 42.sp,
                color = md_theme_light_logo,
                fontFamily = dodge
            )

}}}

@Preview(showBackground = true)
@Composable
fun GreetingPreview8() {
    AdoptTheme(darkTheme = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        )
        {
            Greeting6()
        }
    }
}