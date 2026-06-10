package ci.nsu.moble.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Теперь все файлы в одном пакете, импорты не нужны
            val viewModel: DepositViewModel = viewModel()
            DepositApp(viewModel = viewModel)
        }
    }
}