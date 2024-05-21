package com.himanshu.animalchooser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.himanshu.animalchooser.ui.UserInputViewModel
import com.himanshu.animalchooser.ui.screens.Routes
import com.himanshu.animalchooser.ui.screens.UserInputScreen
import com.himanshu.animalchooser.ui.screens.WelcomeScreen
import com.himanshu.animalchooser.ui.theme.AnimalChooserTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalChooserTheme {
                 SetupNavigation()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun GreetingPreview() {
    AnimalChooserTheme {
        Greeting("Android")
    }
}
@Composable
fun SetupNavigation(userInputViewModel: UserInputViewModel = viewModel()){
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination =Routes.USER_INPUT_SCREEN ) {
        composable(Routes.WELCOME_SCREEN){
            WelcomeScreen(userInputViewModel,navController)
        }
        composable(Routes.USER_INPUT_SCREEN){
            UserInputScreen(userInputViewModel)
        }
    }
}
