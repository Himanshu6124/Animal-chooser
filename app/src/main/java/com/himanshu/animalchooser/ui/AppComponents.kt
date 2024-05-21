package com.himanshu.animalchooser.ui

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.himanshu.animalchooser.R

const val TAG = "APP_COMPONENT"

@Composable
fun TopBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Hi there ,😊",
            fontStyle = FontStyle.Italic,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.baseline_android_24),
            contentDescription = "android"
        )
    }
}

@Composable
fun TextComponent(text: String, size: TextUnit, color: Color) {
    Text(
        text = text,
        fontSize = size,
        color = color,
        fontWeight = FontWeight.Normal
    )
}

@Composable
fun TextFieldComponent(onTextChange: (String) -> Unit) {
    var currentValue by remember { mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            currentValue = it
            onTextChange(it)
        },
        placeholder = { Text(text = "Enter text") },
        textStyle = TextStyle.Default.copy(),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions {
            Log.d(TAG, "Done button pressed")
            localFocusManager.clearFocus()
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalCards(image: Int = R.drawable.dog, selectedImage: Boolean, onSelected: (String) -> Unit) {

    Card(
        modifier = Modifier.size(110.dp),
        onClick =
        {
            val selected = if (image == R.drawable.cat) "CAT" else "DOG"
            onSelected(selected)
        },
        elevation = CardDefaults.cardElevation(10.dp, 20.dp),
        shape = CardDefaults.shape,
        border = BorderStroke(
            2.dp,
            color = if (selectedImage) Color.Red else Color.Transparent
        )
    ) {
        Image(
            modifier = Modifier.padding(10.dp),
            painter = painterResource(id = image),
            contentDescription = "cat"
        )
    }
}

@Composable
fun ButtonComponent(onClicked :()->Unit){
    Button( modifier = Modifier.fillMaxWidth(1f).padding(20.dp),
        onClick = { onClicked() }) {
        Text(text = "Go to Detail")
    }
}