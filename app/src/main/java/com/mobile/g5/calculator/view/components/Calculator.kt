package com.mobile.g5.calculator.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.g5.calculator.controller.CalculatorController
import com.mobile.g5.calculator.models.CalculatorAction
import com.mobile.g5.calculator.models.CalculatorModel
import com.mobile.g5.calculator.ui.theme.LightGray
import com.mobile.g5.calculator.ui.theme.MediumGray
import com.mobile.g5.calculator.ui.theme.Orange


@Composable
fun Calculator(
    calculatorController: CalculatorController,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    onAction: (value: String) -> Unit
) {


    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            Text(
                text = calculatorController.model.num1 + calculatorController.model.operation + calculatorController.model.num2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
            ) {
                CalculatorButton(
                    symbols = "AC",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.CLEAR)
                    })
                CalculatorButton(
                    symbols = "Del",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.DELETE)
                    })
                CalculatorButton(
                    symbols = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.DIVIDE)
                    })
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
            ) {
                CalculatorButton(
                    symbols = "7",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction("7")
                    })
                CalculatorButton(
                    symbols = "8",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction("8")
                    })
                CalculatorButton(
                    symbols = "9",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction("9")
                    })
                CalculatorButton(
                    symbols = "*",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.MULTIPLY)
                    })
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
            ) {
                CalculatorButton(
                    symbols = "4",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction("4")
                    })
                CalculatorButton(
                    symbols = "5",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction("5")
                    })
                CalculatorButton(
                    symbols = "6",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction("6")
                    })
                CalculatorButton(
                    symbols = "+",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.ADD)
                    })
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
            ) {
                CalculatorButton(
                    symbols = "1",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction("1")
                    })
                CalculatorButton(
                    symbols = "2",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction("2")
                    })
                CalculatorButton(
                    symbols = "3",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction("3")
                    })
                CalculatorButton(
                    symbols = "-",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.SUBTRACT)
                    })
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
            ) {
                CalculatorButton(
                    symbols = "0",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction("0")
                    })
                CalculatorButton(
                    symbols = ",",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.PERIOD)
                    })
                CalculatorButton(
                    symbols = "=",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.EQUAL)
                    })
            }
        }
    }
}

@Preview
@Composable
fun Prev() {
    val model = CalculatorModel()
    val controller = CalculatorController(model)

    Calculator(
        calculatorController = controller, modifier = Modifier
            .fillMaxSize()
            .background(
                Color.DarkGray
            )
            .padding(16.dp),
        onAction = controller::onButtonPressed
    )
}