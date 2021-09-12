package com.example.helloworld

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloworld.ui.theme.HelloWorldTheme
import kotlinx.coroutines.launch

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
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(modifier = Modifier.fillMaxSize()
    , scaffoldState = scaffoldState) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(10.dp)

            ) {
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Enter Name") }
                )
                Button(
                    onClick = {
                        Log.d("lalit", "hay it's working")
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Hello $text")
                        }

                    },
                    modifier = Modifier.align(alignment = Alignment.End)
                ) {  //aligning particular part
                    Text(text = "standerd")

                }

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