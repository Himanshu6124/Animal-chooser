package com.himanshu.animalchooser.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.himanshu.animalchooser.R
import com.himanshu.animalchooser.data.UserDataUIEvents
import com.himanshu.animalchooser.ui.AnimalCards
import com.himanshu.animalchooser.ui.ButtonComponent
import com.himanshu.animalchooser.ui.TextComponent
import com.himanshu.animalchooser.ui.TextFieldComponent
import com.himanshu.animalchooser.ui.TopBar
import com.himanshu.animalchooser.ui.UserInputViewModel

@Preview(showBackground = true)
@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel = viewModel()) {

    var selectedImage by remember { mutableStateOf("CAT") }

    Column(
        modifier = Modifier.padding(top = 50.dp, start = 10.dp, end = 10.dp),
    ) {
        TopBar()
        Spacer(
            modifier = Modifier
                .width(20.dp)
                .height(10.dp)
        )
        TextComponent(
            text = "Let's learn about you !!",
            size = 18.sp,
            color = Color.Black
        )
        Spacer(
            modifier = Modifier
                .width(20.dp)
                .height(10.dp)
        )

        TextComponent(
            text = "This app will prepare a detailed screen based on your selected preference",
            size = 18.sp,
            color = Color.Black
        )
        Spacer(
            modifier = Modifier
                .width(20.dp)
                .height(10.dp)
        )
        TextComponent(
            text = "Name",
            size = 18.sp,
            color = Color.Black
        )
        Spacer(
            modifier = Modifier
                .width(20.dp)
                .height(10.dp)
        )
        TextFieldComponent(onTextChange = {
            userInputViewModel.onEvent(
                UserDataUIEvents.UserNameEntered(
                    it
                )
            )
        })
        Spacer(
            modifier = Modifier
                .width(20.dp)
                .height(10.dp)
        )
        TextComponent(
            text = "What do you like ?",
            size = 18.sp,
            color = Color.Black
        )
        Spacer(
            modifier = Modifier
                .width(20.dp)
                .height(10.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
        ) {
            AnimalCards(R.drawable.cat, userInputViewModel.uiState.value.animalSelected == "CAT") {
                selectedImage = it
                userInputViewModel.onEvent(UserDataUIEvents.AnimalSelected(it))
            }
            AnimalCards(R.drawable.dog, userInputViewModel.uiState.value.animalSelected == "DOG") {
                selectedImage = it
                userInputViewModel.onEvent(UserDataUIEvents.AnimalSelected(it))
            }
        }
        Spacer(
            modifier = Modifier.weight(1f)
        )
        if (userInputViewModel.isValid())
            ButtonComponent(onClicked = {})
    }
}