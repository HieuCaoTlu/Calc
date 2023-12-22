package com.example.calc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calc.ui.theme.CalcTheme
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalcTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator()
                }
            }
        }
    }
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Calculator() {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf(0f) }
    val hideKey = LocalSoftwareKeyboardController.current
    var showResult by remember { mutableStateOf(false)}
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff91C8E4)),
        contentAlignment = Alignment.Center,

    ) {
        Column (modifier = Modifier
            .padding(60.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally,) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xffFFE5AD), shape = RoundedCornerShape(15.dp))
                    .height(50.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                ) {
                Text("Máy tính", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(20.dp))
            NumberInput("đầu tiên", number1, onValueChange = {number1 = it})
            Spacer(modifier = Modifier.height(20.dp))
            NumberInput("thứ hai", number2, onValueChange = {number2 = it})
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {result = number1.toFloat() + number2.toFloat()
                    hideKey?.hide()
                    showResult = true},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF749BC2)),
                modifier = Modifier
                    .width(100.dp)
                    .height(50.dp)
            ) {
                Text(text = "Tính", color = Color.DarkGray, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(20.dp))
            if (showResult) {
                Text(text = result.toString(), fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun NumberInput(name: String, num: String, onValueChange: (String) -> Unit) {
    TextField(
        value = num,
        onValueChange = onValueChange,
        placeholder = {Text(text = "Số hạng $name: ")},
        singleLine = true,
        shape = MaterialTheme.shapes.large,
        colors = TextFieldDefaults.textFieldColors(
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color(0xFFF6F4EB)
        ),
        textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalcTheme {
        Calculator()
    }
}