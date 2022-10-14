package com.example.demoui


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.demoui.ui.theme.BackGroundColorGrey
import com.example.demoui.ui.theme.StatusTextColorBlack

@Composable
fun StatusBreak(
    status: String,
    duration1: String,
    duration2: String,
    duration3: String,
    duration4: String,
) {

    Card(
        modifier = Modifier
            .width(344.dp)
            .heightIn(401.dp),
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(25.dp))
    ) {
        Column(
            modifier = Modifier.padding(
                start = 25.4.dp,
                top = 27.dp,
                end = 24.6.dp,
                bottom = 24.dp
            )
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.down), contentDescription = "",
                    modifier = Modifier
                        .width(14.dp)
                        .heightIn(7.dp)
                        .padding(top = 6.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.red),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 12.dp, top = 9.dp, end = 10.dp)
                        .heightIn(9.dp)
                        .width(9.dp)
                )
                StatusViewText(status)

            }
            Text(
                text = "Not taking calls until",
                color = Color(0xFF8495b1),
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 4.dp, top = 31.dp, bottom = 20.dp)
            )
            TextViewBreakCard(
                duration1,
                textColor = Color(0xFF6285FF),
                borderColor = Color(0xFF6285FF),
                backgroundColor = Color.White
            )

            Spacer(modifier = Modifier.padding(6.dp))

            TextViewBreakCard(
                duration2,
                textColor = StatusTextColorBlack,
                borderColor = Color(0xFFf6f8fc),
                backgroundColor = BackGroundColorGrey
            )

            Spacer(modifier = Modifier.padding(6.dp))

            TextViewBreakCard(
                duration3,
                textColor = StatusTextColorBlack,
                borderColor = Color(0xFFf6f8fc),
                backgroundColor = BackGroundColorGrey
            )

            Spacer(modifier = Modifier.padding(6.dp))

            TextViewBreakCard(
                duration4,
                textColor = StatusTextColorBlack,
                borderColor = Color(0xFFf6f8fc),
                backgroundColor = BackGroundColorGrey
            )

            Spacer(modifier = Modifier.padding(15.dp))

            DoneButton()
        }
    }
}


@Composable
fun TextViewBreakCard(
    statusHour: String,
    textColor: Color,
    borderColor: Color,
    backgroundColor: Color
) {
    Card(
        modifier = Modifier
            .width(295.dp)
            .height(40.dp),
        border = BorderStroke(1.dp, color = borderColor),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor),
            contentAlignment = Center
        ) {
            Text(text = statusHour, color = textColor, fontSize = 16.sp)
        }
    }
}


@Composable
fun DoneButton() {
    Button(
        onClick = { /*TODO*/ }, modifier = Modifier
            .width(295.dp)
            .heightIn(40.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF4684FF))
    ) {
        Text(text = "Done", color = Color.White, fontSize = 16.sp)
    }
}


@Composable
fun StatusViewText(status: String) {
    val bln = true
    var text = remember { mutableStateOf(status) }
    if (bln) {
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            value = text.value,
            onValueChange = { newValue ->
                text.value = newValue
            },
            textStyle = LocalTextStyle.current.copy(
                color = StatusTextColorBlack,
                fontSize = 20.sp
            ),
            readOnly = true,
        )
    } else {
        text = remember { mutableStateOf("") }
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            value = text.value,
            onValueChange = { newValue ->
                text.value = newValue
            },

            textStyle = LocalTextStyle.current.copy(
                color = StatusTextColorBlack,
                fontSize = 20.sp,
            ),
            readOnly = false,
            decorationBox = { innerTextField ->
                if (text.value.isEmpty()) {
                    Text("Add a custom title", color = Color(0xFF8495b1), fontSize = 20.sp)
                }
                innerTextField()
            }
        )
    }
}


@Composable
fun Dialog(
    status: String,
    duration1: String,
    duration2: String,
    duration3: String,
    duration4: String,
    dialogState: Boolean,
    onDismissRequest: (dialogState: Boolean) -> Unit
) {
    if (dialogState) {
        Dialog(
            onDismissRequest = { onDismissRequest(false) },
        ) {
            Surface(
                shape = RoundedCornerShape(25.dp)
            )
            {
                StatusBreak(status,duration1,duration2,duration3,duration4)

            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview2() {
    StatusBreak("In a Meeting","Further Notice","Next Hour","Next 2 Hours","Custom")
    //StatusBreak("Lunch","15 Minutes","30 Minutes","Next Hour","Custom")
  //  StatusBreak("Vacation","1 Day","2 Days","1 Week","Custom")
//    StatusBreak("","Further Notice","Next Hour","Next 2 Hours","Custom")
}