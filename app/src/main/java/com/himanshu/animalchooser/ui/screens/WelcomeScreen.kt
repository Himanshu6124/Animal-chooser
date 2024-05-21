package com.himanshu.animalchooser.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.himanshu.animalchooser.ui.TextComponent
import com.himanshu.animalchooser.ui.TopBar
import com.himanshu.animalchooser.ui.UserInputViewModel

@Preview(showBackground = true)
@Composable
fun WelcomeScreen(
    userInputViewModel: UserInputViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {

    Column(
        modifier = Modifier.padding(20.dp, 2.dp),
    ) {
        TopBar()
        Spacer(modifier = Modifier
            .width(20.dp)
            .height(10.dp))
        TextComponent(
            text = "Let's learn about you",
            size = 18.sp,
            color = Color.Black
        )
    }
}