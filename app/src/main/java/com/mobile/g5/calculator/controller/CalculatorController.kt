package com.mobile.g5.calculator.controller

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.mobile.g5.calculator.models.CalculatorAction
import com.mobile.g5.calculator.models.CalculatorModel

class CalculatorController(
    private val _model: CalculatorModel
) {
    private val LOG = "number"

    var model by mutableStateOf(_model)
    private var isCalculated = false

    fun onButtonPressed(value: String) {
        if (isCalculated) {
            model = CalculatorModel()
            isCalculated = false
        }

        when (value) {
            CalculatorAction.ADD -> enterOperation(value)
            CalculatorAction.SUBTRACT -> enterOperation(value)
            CalculatorAction.MULTIPLY -> enterOperation(value)
            CalculatorAction.DIVIDE -> enterOperation(value)
            CalculatorAction.DELETE -> delete()
            CalculatorAction.CLEAR -> model = CalculatorModel()
            CalculatorAction.EQUAL -> calculate()
            CalculatorAction.PERIOD -> enterDecimal()
            else -> enterNumber(value)

        }
    }

    private fun enterNumber(value: String) {
        if (model.operation == "") {
            if (model.num1.length >= MAX_NUM_LENGTH)
                return
            if (model.num1.length == 1 && model.num1 == "0")
                return
            model = model.copy(num1 = model.num1 + value)
            return
        }
        if (model.num2.length >= MAX_NUM_LENGTH)
            return
        if (model.num2.length == 1 && model.num2 == "0")
            return
        model = model.copy(num2 = model.num2 + value)
    }

    private fun enterDecimal() {
        if (model.operation == "" && !model.num1.contains(".") && model.num1.isNotBlank()) {
            model = model.copy(num1 = model.num1 + ".")
            return
        } else if (!model.num2.contains(".") && model.num2.isNotBlank()) {
            model = model.copy(num2 = model.num2 + ".")
            return
        }
    }

    private fun calculate() {
        val num1 = model.num1.toDoubleOrNull()
        val num2 = model.num2.toDoubleOrNull()

        if (model.num2 == "0") {
            model = model.copy(num1 = "Error", num2 = "", operation = "")
            return
        }

        if (num1 != null && num2 != null) {
            val result = when(model.operation) {
                CalculatorAction.ADD -> num1 + num2
                CalculatorAction.SUBTRACT -> num1 - num2
                CalculatorAction.MULTIPLY -> num1 * num2
                CalculatorAction.DIVIDE -> num1 / num2
                else -> return
            }
            isCalculated = true
            model = model.copy(num1 = result.toString().take(15), num2 = "", operation = "")
        }
    }

    private fun delete() {
        when {
            model.num2.isNotBlank() -> model = model.copy(num2 = model.num2.dropLast(1))
            model.operation != "" -> model = model.copy(operation = "")
            model.num1.isNotBlank() -> model = model.copy(num1 = model.num1.dropLast(1))
        }
    }

    private fun enterOperation(value: String) {
        if (model.num1.isNotBlank()) {
            model = model.copy(operation = value)
        }
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}