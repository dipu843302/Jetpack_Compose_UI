package com.example.demoui


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.MagnifierStyle.Companion.Default
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy.Companion.Default
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle.Companion.Default
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle

@Composable
fun StatusBreak(status: String) {

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
                StatusViewText("In a Meeting")
               // Text(text = status, fontSize = 18.sp, color = Color(0xFF001818))
            }
            Text(
                text = "Not taking calls until",
                color = Color(0xFF8495b1),
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 4.dp, top = 31.dp, bottom = 20.dp)
            )
            TextViewBreakCard(
                "Further Notice",
                textColor = Color(0xFF6285FF),
                borderColor = Color(0xFF6285FF),
                backgroundColor = Color.White
            )

            Spacer(modifier = Modifier.padding(6.dp))

            TextViewBreakCard(
                "Next Hour",
                textColor = Color(0xFF001818),
                borderColor = Color(0xFFf6f8fc),
                backgroundColor = Color(0xFFf6f8fc)
            )

            Spacer(modifier = Modifier.padding(6.dp))

            TextViewBreakCard(
                "Next 2 Hours",
                textColor = Color(0xFF001818),
                borderColor = Color(0xFFf6f8fc),
                backgroundColor = Color(0xFFf6f8fc)
            )

            Spacer(modifier = Modifier.padding(6.dp))

            TextViewBreakCard(
                "Custom",
                textColor = Color(0xFF001818),
                borderColor = Color(0xFFf6f8fc),
                backgroundColor = Color(0xFFf6f8fc)
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
    val text = remember { mutableStateOf(status ) }
    BasicTextField(modifier = Modifier.fillMaxWidth()
        .background(Color.Transparent),
        value = text.value,
        onValueChange = {newValue->
            text.value=newValue
        },
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colors.onSurface,
            fontSize = 20.sp
        ),
        readOnly = true,

    )
}

@Composable
fun CustomDialog(
    dialogState:Boolean,
    onDismissRequest : ( dialogState:Boolean)-> Unit
) {
    if(dialogState){
        AlertDialog(onDismissRequest = {
            onDismissRequest(false)

        },
            {
                StatusBreak("Break")

            }
                // StatusView(takingCallOrNot = true, statusHeading = "Taking calls", statusSubHeading = "I can take calls")
        )
    }


}

@Preview
@Composable
fun DefaultPreview2() {
    StatusBreak(status = "In a Meeting")
}