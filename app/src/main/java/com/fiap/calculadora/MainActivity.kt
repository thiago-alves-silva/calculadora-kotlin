package com.fiap.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSum = findViewById<Button>(R.id.btnSum);
        val btnSubtraction = findViewById<Button>(R.id.btnSubtraction);
        val btnMultiplication = findViewById<Button>(R.id.btnMultiplication);
        val btnDivision = findViewById<Button>(R.id.btnDivision);
        val resultText = findViewById<TextView>(R.id.resultText);

        val calculate = View.OnClickListener { btn ->
            val valueOne: Double =
                findViewById<EditText>(R.id.valueOne).text.toString().toDouble();
            val valueTwo: Double =
                findViewById<EditText>(R.id.valueTwo).text.toString().toDouble();
            val calculationResult: Double = when (btn.id) {
                btnSum.id -> valueOne + valueTwo;
                btnSubtraction.id -> valueOne - valueTwo;
                btnMultiplication.id -> valueOne * valueTwo;
                btnDivision.id -> valueOne / valueTwo;
                else -> Double.NaN;
            }
            val rest = calculationResult.rem(2.0).absoluteValue;

            if (calculationResult.isFinite())
                resultText.text = String.format(
                    if (rest != 0.0 && rest != 1.0) "%.2f" else "%.0f", calculationResult
                );
            else
                resultText.text = "Impossível Calcular";
        }

        btnSum.setOnClickListener(calculate);
        btnSubtraction.setOnClickListener(calculate);
        btnMultiplication.setOnClickListener(calculate);
        btnDivision.setOnClickListener(calculate);
    }
}