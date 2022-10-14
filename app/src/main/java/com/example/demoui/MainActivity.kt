package com.example.demoui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demoui.ui.theme.BackGroundColorGrey
import com.example.demoui.ui.theme.DemoUITheme
import com.example.demoui.ui.theme.StatusTextColorBlack
import javax.net.ssl.SSLEngineResult.Status

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoUITheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,

                    ) {
                    CallStatus()
                 //   NavigationScreen(takingCallOrNot = true, statusHeading = "Available", statusSubHeading = "Take calls")
                  //
                }
            }
        }
    }
}

@Composable
fun NavigationScreen(
    takingCallOrNot: Boolean,
    statusHeading: String,
    statusSubHeading: String,

) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "StatusView") {
        composable(route = "StatusView") {
            StatusView(
                takingCallOrNot,
                statusHeading,
                statusSubHeading,
            )
        }
        composable(route = "adopt") {
            //AdoptionScreen()
        }
    }
}

@Composable
fun CallStatus() {
    var dialogState by remember {
        mutableStateOf(false)
    }

    Button(onClick = {
        dialogState = true
    }) {
        Text(text = "Status")
    }
    OpenDialog(dialogState = dialogState, onDismissRequest = {
        dialogState = it
    })
}

@Composable
fun StatusView(
    takingCallOrNot: Boolean,
    statusHeading: String,
    statusSubHeading: String,
) {


    val checkStatus by remember {
        mutableStateOf(takingCallOrNot)
    }

    Card(
        modifier = Modifier
            .width(320.dp)
            .heightIn(410.dp)
            .background(Color.White),

        shape = RoundedCornerShape(corner = CornerSize(25.dp))
    ) {
        Column {
            Row(modifier = Modifier.padding(start = 22.dp, top = 26.dp, end = 24.dp)) {
                Image(
                    painter = painterResource(id = if (checkStatus) R.drawable.ic_available_icon else R.drawable.ic_not_available_icon),
                    contentDescription = "",
                    modifier = Modifier.padding(top = 4.dp)
                )
                Column {
                    Text(
                        text = statusHeading,
                        modifier = Modifier.padding(start = 11.dp),
                        color = Color(0xFF4a4a4a),
                        fontSize = 18.sp
                    )
                    Text(
                        text = statusSubHeading,
                        modifier = Modifier.padding(start = 11.dp),
                        color = Color(0xFF8495b1),
                        fontSize = 15.sp
                    )
                }
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                Available()
                NotTakingCalls()
            }
        }
    }
}


@Composable
fun Available() {
    Card(
        modifier = Modifier
            .width(320.dp)
            .heightIn(64.dp)
            .padding(start = 18.dp, top = 24.dp, bottom = 20.dp, end = 22.dp),
        backgroundColor = BackGroundColorGrey,
        border = BorderStroke(1.dp, Color(0xff009900)),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.green),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 9.dp, top = 19.dp, end = 9.dp)
                        .heightIn(9.dp)
                        .width(9.dp)
                )
                Text(
                    text = "I’m Available",
                    color = Color(0xFF4a4a4a),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 14.dp)
                )
            }
            Text(
                text = "I can take calls",
                color = Color(0xFF8495b1),
                fontSize = 13.sp,
                modifier = Modifier.padding(start = 27.dp, bottom = 13.dp)
            )
        }
    }
}


@Composable
fun NotTakingCalls() {
    Card(
        modifier = Modifier
            .padding(start = 10.dp)
            .width(320.dp)
            .height(282.dp),
        elevation = 0.dp,
        backgroundColor = Color.White,
        border = BorderStroke(0.dp, Transparent)
    ) {
        Column {
            Text(
                text = "I'm Not Taking Calls",
                color = Color(0xFF8495b1),
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 15.dp, bottom = 5.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {

                StatusCardView("In a Meeting", modifier = Modifier.clickable {
//                    Dialog(
//                        status = "In a Meeting",
//                        duration1 = ,
//                        duration2 = ,
//                        duration3 = ,
//                        duration4 = ,
//                        dialogState = ,
//                        onDismissRequest =
//                    )
                })
                StatusCardView("At Lunch", modifier = Modifier)
                StatusCardView("On Vacation", modifier = Modifier)
                StatusCardView("Custom", modifier = Modifier)
            }
        }
    }
}


@Composable
fun StatusCardView(
    StatusText: String,
    modifier: Modifier
) {
    Card(
        modifier
            .width(320.dp)
            .height(50.dp)
            .padding(end = 14.dp, top = 8.dp),
        backgroundColor = BackGroundColorGrey,
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Image(
                painter = painterResource(id = R.drawable.red),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 9.dp, top = 5.dp, end = 9.dp)
                    .heightIn(9.dp)
                    .width(9.dp)
            )
            Text(
                text = StatusText,
                color = StatusTextColorBlack,
                fontSize = 14.sp,
            )
        }
    }
}

@Composable
fun OpenDialog(
    dialogState: Boolean,
    onDismissRequest: (dialogState: Boolean) -> Unit
) {
    if (dialogState) {
        androidx.compose.ui.window.Dialog(
            onDismissRequest = { onDismissRequest(false) },
        ) {
            Surface(
                shape = RoundedCornerShape(25.dp)
            )
            {
                // StatusBreak(status = "asd")
                StatusView(
                    takingCallOrNot = true,
                    statusHeading = "Available",
                    statusSubHeading = "Take calls"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DemoUITheme {
        StatusView(takingCallOrNot = true, "Taking Calls", "I can take calls")

        //  Available()
        //  NotTakingCalls()
    }
}