package com.mobile.g5.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mobile.g5.calculator.controller.CalculatorController
import com.mobile.g5.calculator.models.CalculatorModel
import com.mobile.g5.calculator.ui.theme.CalculatorTheme
import com.mobile.g5.calculator.view.components.Calculator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model = CalculatorModel()
        val controller = CalculatorController(model)

        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
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
            }
        }
    }
}
