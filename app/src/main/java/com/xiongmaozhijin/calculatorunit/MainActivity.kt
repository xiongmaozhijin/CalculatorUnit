package com.xiongmaozhijin.calculatorunit

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xiongmaozhijin.calculatorunit.ui.theme.CalculatorUnitTheme
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorUnitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box {
                        CalculatorUnit()
                    }
                }
            }
        }
    }


}


@Preview
@Composable
fun CalculatorUnit() {
    val labelList = arrayOf(
        arrayOf("C", "+/-", "←", "/"),
        arrayOf("4", "5", "6", "-"),
        arrayOf("1", "2", "3", "+"),
        arrayOf("0", ".", "="),
    )

    val context = LocalContext.current;

    Column() {
        // display output layout
        Box(
            Modifier
                .background(MaterialTheme.colors.onBackground)
                .fillMaxWidth()
                .fillMaxHeight(0.37f)
        ) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()) {
                Box(modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)) {
                    Text(
                        fontSize = 24.sp,
                        text = "0",
                        color = Color.White,
                        style = MaterialTheme.typography.body1,
                    )
                }
                Box(modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(10.dp)) {
                    Text(
                        modifier = Modifier.align(Alignment.BottomEnd),
                        fontSize = 28.sp,
                        text = "0", color = Color.White, style = MaterialTheme.typography.body2
                    )
                }
            }
        }
        // input layout
        Box(
            Modifier
                .fillMaxHeight()
                .background(Color.DarkGray)
        ) {
            Column() {
                labelList.forEach { rowArray ->
                    Row(
                        Modifier
                            .weight(1f)
                            .fillMaxHeight(1f)
                    ) {
                        rowArray.forEach { label ->
                            CalculateButton(
                                Modifier
                                    .weight(
                                        when (label) {
                                            "0", "." -> 0.25f
                                            "=" -> 0.75f
                                            else -> 1f
                                        }
                                    ), onClick = {
                                    Toast.makeText(context, label, Toast.LENGTH_SHORT).show()
                                },
                                label = label
                            )
                        }
                    }
                }

            }


        }
    }
}

@Composable
fun CalculateButton(modifier: Modifier, label: String = "0", onClick: () -> Unit) {
    Box(
        modifier
            .clip(RoundedCornerShape(50))
            .padding(6.dp)
            .background(MaterialTheme.colors.secondary)
            .fillMaxHeight()
            .clickable(true, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            fontSize = 36.sp,
            style = MaterialTheme.typography.body1,
            color = Color.White
        )
    }
}