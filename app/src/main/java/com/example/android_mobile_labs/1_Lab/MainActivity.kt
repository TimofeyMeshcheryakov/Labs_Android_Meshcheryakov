package com.example.android_mobile_labs.`1_Lab`

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_mobile_labs.ui.theme.Android_Mobile_LabsTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Text(
                modifier = Modifier
                    .background(color = Color.Red)
                    .border(5.dp, Color.Blue, CircleShape)
                    .padding(30.dp, 16.dp, 25.dp, 32.dp)
                    .width(90.dp),
                text = "Hello world",
                fontWeight = FontWeight.Bold,
                color = Color.Green,
                fontSize = 20.sp,
                fontFamily = FontFamily.Cursive
            )
        }
    }
}

