package com.example.android_mobile_labs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_mobile_labs.ui.theme.Android_Mobile_LabsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AsciiTransform()
        }
    }
}

val symbols = mapOf(
    'A' to arrayOf("  #  ", " # # ", "#####", "#   #", "#   #"),
    'B' to arrayOf("#### ", "#   #", "#### ", "#   #", "#### "),
    'C' to arrayOf(" ####", "#    ", "#    ", "#    ", " ####"),
    'D' to arrayOf("#### ", "#   #", "#   #", "#   #", "#### "),
    'E' to arrayOf("#####", "#    ", "###  ", "#    ", "#####"),
    'F' to arrayOf("#####", "#    ", "###  ", "#    ", "#    "),
    'G' to arrayOf(" ####", "#    ", "#  ##", "#   #", " ####"),
    'H' to arrayOf("#   #", "#   #", "#####", "#   #", "#   #"),
    'I' to arrayOf("#####", "  #  ", "  #  ", "  #  ", "#####"),
    'J' to arrayOf("#####", "    #", "    #", "#   #", " ### "),
    'K' to arrayOf("#   #", "#  # ", "##   ", "#  # ", "#   #"),
    'L' to arrayOf("#    ", "#    ", "#    ", "#    ", "#####"),
    'M' to arrayOf("#   #", "## ##", "# # #", "#   #", "#   #"),
    'N' to arrayOf("#   #", "##  #", "# # #", "##  #", "#   #"),
    'O' to arrayOf(" ### ", "#   #", "#   #", "#   #", " ### "),
    'P' to arrayOf("#### ", "#   #", "#### ", "#    ", "#    "),
    'Q' to arrayOf(" ### ", "#   #", "#   #", "#  ##", " ####"),
    'R' to arrayOf("#### ", "#   #", "#### ", "#  # ", "#   #"),
    'S' to arrayOf(" ####", "#    ", " ### ", "    #", "#### "),
    'T' to arrayOf("#####", "  #  ", "  #  ", "  #  ", "  #  "),
    'U' to arrayOf("#   #", "#   #", "#   #", "#   #", " ### "),
    'V' to arrayOf("#   #", "#   #", "#   #", " # # ", "  #  "),
    'W' to arrayOf("#   #", "#   #", "# # #", "## ##", "#   #"),
    'X' to arrayOf("#   #", " # # ", "  #  ", " # # ", "#   #"),
    'Y' to arrayOf("#   #", " # # ", "  #  ", "  #  ", "  #  "),
    'Z' to arrayOf("#####", "   # ", "  #  ", " #   ", "#####"),
    '0' to arrayOf(" ### ", "#   #", "#   #", "#   #", " ### "),
    '1' to arrayOf("  #  ", " ##  ", "  #  ", "  #  ", "#####"),
    '2' to arrayOf(" ### ", "#   #", "   # ", "  #  ", "#####"),
    '3' to arrayOf(" ### ", "#   #", "  ## ", "#   #", " ### "),
    '4' to arrayOf("#   #", "#   #", "#####", "    #", "    #"),
    '5' to arrayOf("#####", "#    ", "#### ", "    #", "#### "),
    '6' to arrayOf(" ####", "#    ", "#### ", "#   #", " ### "),
    '7' to arrayOf("#####", "    #", "   # ", "  #  ", " #   "),
    '8' to arrayOf(" ### ", "#   #", " ### ", "#   #", " ### "),
    '9' to arrayOf(" ### ", "#   #", " ####", "    #", " ### "),
    ' ' to arrayOf("  #  ", "  #  ", "  #  ", "  #  ", "  #  ") //Это не баг, спецом так сделал пробел
)
@Composable
fun AsciiTransform() {
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    val logo = """
  #####   ###   #   #  #   #  #####  ####   #####  By Rudy
 #       #   #  ##  #  #   #  #      #   #    #
 #       #   #  # # #  #   #  ###    ####     #
 #       #   #  #  ##   # #   #      #  #     #
  #####   ###   #   #    #    #####  #   #    #
"""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = logo,
            fontFamily = FontFamily.Monospace,
            fontSize = 10.sp,
            modifier = Modifier.padding(bottom = 30.dp)
        )

        Text(
            text = output,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 20.dp)
        )
        OutlinedTextField(
            value = input,
            onValueChange = {
                input = it
            },
            label = {
                Text("Введите текст")
            },
            modifier = Modifier.fillMaxWidth(0.9f)
        )
        Button(
            onClick = {
                output = generateAsciiArt(input)
            },
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("Преобразовать")
        }
    }
}

fun generateAsciiArt(text: String): String {
    val ascii = Array(5) { StringBuilder() }
    for (i in text.uppercase()) {
        val art = symbols[i] ?: arrayOf("  ?  ", "  ?  ", "  ?  ", "  ?  ", "  ?  ")
        for (i in 0..4) ascii[i].append(art[i]).append(" ")
    }
    return ascii.joinToString("\n")
}