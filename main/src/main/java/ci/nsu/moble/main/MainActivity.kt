package ci.nsu.moble.main


import android.R
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ci.nsu.moble.main.ui.theme.PracticeTheme

private val colorsMap = mapOf(
    "Red" to Red,
    "Orange" to Color(0xFFFF5722),
    "Yellow" to Yellow,
    "Green" to Green,
    "Blue" to Blue,
    "Indigo" to Color(0xFF4B0082),
    "Violet" to Color(0xFF9C27B0),

)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var inp by remember { mutableStateOf("") }
    var btnC by remember { mutableStateOf(Color.Green) }
    Column {
        TextField(
            value = inp,
            onValueChange = { inp = it },
            label = { Text("Введите цвет")},
            modifier = Modifier.width(500.dp).padding(20.dp)
        )

        Button(
            onClick = {
                val color = colorsMap[inp.trim()]
                if (color!=null) {
                    btnC = color
                }else { Log.w("Color_Err", "Цвет не найден")
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = btnC),
            modifier = modifier.width(500.dp).height(60.dp)
        ) {
            Text("Применить цвет")

        }
        for ((name, color) in colorsMap) {
            OutlinedTextField(value = name, onValueChange = {}, readOnly = true, colors = TextFieldDefaults.colors(
                focusedContainerColor = color,
                unfocusedContainerColor = color,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ), modifier = modifier.width(500.dp).padding(20.dp,5.dp))
        }
        //        не знаю как сдлеать отступы меньше,
    //        padding работает не тек как хочу

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticeTheme {
        Greeting("Android")
    }
}