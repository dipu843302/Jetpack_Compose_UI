package com.example.demoui


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BreakStatus(status: String) {
    Card(
        modifier = Modifier
            .width(344.dp)
            .heightIn(401.dp),
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(15.dp))
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
                Text(text = status, fontSize = 18.sp, color = Color(0xFF001818))
            }
            Text(
                text = "Not taking calls until",
                color = Color(0xFF8495b1),
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 4.dp, top = 31.dp, bottom = 20.dp)
            )
            Card(
                modifier = Modifier
                    .width(295.dp)
                    .height(40.dp),
                border = BorderStroke(1.dp, color = Color(0xFF6285FF)),
                shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Center
                ) {
                    Text(text = "Further Notice", color = Color(0xFF6285FF), fontSize = 16.sp)
                }
            }
            
            Spacer(modifier = Modifier.padding(6.dp))

            Card(
                modifier = Modifier
                    .width(295.dp)
                    .height(40.dp)
                   ,
                backgroundColor = Color(0xFFf6f8fc),
                shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Center
                ) {
                    Text(text = "Next Hour", color = Color(0xFF001818), fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.padding(6.dp))

            Card(
                modifier = Modifier
                    .width(295.dp)
                    .height(40.dp),
                backgroundColor = Color(0xFFf6f8fc),
                shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Center
                ) {
                    Text(text = "Next 2 Hours", color = Color(0xFF001818), fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.padding(6.dp))

            Card(
                modifier = Modifier
                    .width(295.dp)
                    .height(40.dp),
                backgroundColor = Color(0xFFf6f8fc),
                shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Center
                ) {
                    Text(text = "Custom", color = Color(0xFF001818), fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.padding(15.dp))
            
            Button(onClick = { /*TODO*/ }, modifier = Modifier.width(295.dp).heightIn(40.dp),
                  shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF4684FF))
                ) {
                Text(text = "Done", color = Color.White, fontSize = 16.sp)
            }

        }

    }
}

@Preview
@Composable
fun DefaultPreview2() {
    BreakStatus(status = "In a Meeting")
}