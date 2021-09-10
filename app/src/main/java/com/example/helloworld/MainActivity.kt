package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloworld.ui.theme.HelloWorldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                SimpleFilledTextFieldSample()
            }
        }
    }




@Composable
fun SimpleFilledTextFieldSample() {
    var text by remember { mutableStateOf("") }

   Column(modifier = Modifier.fillMaxWidth(),
       horizontalAlignment = Alignment.CenterHorizontally) {
       Column(modifier = Modifier.padding(8.dp)
           ,verticalArrangement = Arrangement.spacedBy(10.dp)

       ) {
           OutlinedTextField(
               value = text,
               onValueChange = { text = it },
               label = { Text("Enter Name") }
           )
           Button(onClick = { /*TODO*/ }, modifier = Modifier.align(alignment = Alignment.End)) {  //aligning particular part
               Text(text = "standerd")

           }

       }
   }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelloWorldTheme {

    }
}